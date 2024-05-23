package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import model.Reais;
import model.Tarifacao;
import view.CompraRipple;

public class ControllerCompraRipple implements Tarifacao {
    private Reais reais;
    private Investidor investidor;
    private CompraRipple view;
    private Carteira c1;

    public ControllerCompraRipple(CompraRipple view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 = investidor.getC1();
    }

    public ControllerCompraRipple(Reais reais) {
        this.reais = reais;
    }

    public void compraRipple() {
        Conexao conexao = new Conexao();
        try {
            //estabelecendo a conexão
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                //pega informações no banco, principalmente para serem utilizadas no extrato
                int investidorId = res.getInt("id");
                double real = res.getDouble("reais");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");
                //pega quantidade de ripples que o usuario quer comprar na view
                double qtdR = Double.parseDouble(view.getCompraRi().getText());
                //pega preço fixo da moeda na carteira
                double precoRipple = c1.getQtdRipple().getValor();
                //contas para realizar a compra de ethereum, aplicando cotação e taxa respectivas
                double cotacao = getCotacao(2);
                double compraRipple = qtdR* cotacaoMoedas(precoRipple);
                double taxaCompraRi = compraRipple * taxaCompraRipple();
                double valorTotal = compraRipple + taxaCompraRi;

                if (qtdR <= 0) {
                    JOptionPane.showMessageDialog(view, "Número de Ripples a serem compradas negativo, escreva novamente");
                    return;
                }
                if (real <= valorTotal) {
                    JOptionPane.showMessageDialog(view, "Saldo insuficiente em reais para a compra de Ripples");
                    return;
                }
                 //declara valor de reais e ripples a serem colocadas no banco
                double valorFinalRipple = ripple + qtdR;
                double valorFinalReais = real - valorTotal;

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                boolean tipo = true;
                // manda informações para o banco (extrato, reais e ripples após a transação)
                dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacao, "Ripple    TX: 0.01", valorFinalReais, bitcoin, ethereum, valorFinalRipple, investidorId);
                dao.comprarReal(investidor, valorFinalReais);
                dao.geralRipple(investidor, valorFinalRipple);
                JOptionPane.showMessageDialog(view, "Compra realizada com sucesso!");
                JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais + " Saldo atual em Ripples: " + valorFinalRipple);

            } else {
                JOptionPane.showMessageDialog(view, "Erro de conexão.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
     //pega a taxa de compra da ripple pela implementação da interface Tarifação
    @Override
    public double taxaCompraRipple() {
        return 0.01;
    }
}
