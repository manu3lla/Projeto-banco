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
import view.CompraEthereum;

/**
 * Autor: Manuella
 */
public class ControllerCompraEthereum implements Tarifacao {
    private Reais reais;
    private Investidor investidor;
    private CompraEthereum view;
    private Carteira c1;

    public ControllerCompraEthereum(CompraEthereum view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 = investidor.getC1();
    }

    public ControllerCompraEthereum(Reais reais) {
        this.reais = reais;
    }

    public void compraEthereum() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                 //pega informações no banco, principalmente para serem utilizadas no extrato
                int investidorId = res.getInt("id");
                double real = res.getDouble("reais");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double cotacao = getCotacao(1);
                double ripple = res.getDouble("ripple");   
                //pega quantidade de ethereums que o usuario quer comprar na view
                double qtdEthereum = Double.parseDouble(view.getComprarE().getText());
                //pega preço fixo da moeda na carteira
                double precoAtualEthereum = c1.getQtdEt().getValor();
                //contas para realizar a compra de ethereum, aplicando cotação e taxa respectivas
                double compraEt = qtdEthereum * cotacaoMoedas(precoAtualEthereum);
                double taxaEthereum = compraEt * taxaCompraEthereum();
                double valorTotal = compraEt + taxaEthereum;
                System.out.println(valorTotal);

                if (qtdEthereum <= 0) {
                    JOptionPane.showMessageDialog(view, "Número de Ethereums a serem compradas negativo, escreva novamente");
                    return;
                }
                if (real < valorTotal) {
                    JOptionPane.showMessageDialog(view, "Saldo insuficiente em reais para a compra de Ethereums");
                    return;
                }
                //declara valor de reais e ethereums a serem colocadas no banco
                double valorFinalEthereum = ethereum + qtdEthereum;
                double valorFinalReais = real - valorTotal;
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                boolean tipo = true;
                // manda informações para o banco (extrato, reais e ethereums após a transação)
                dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacao, "Ethereum  TX: 0.01", valorFinalReais, bitcoin, valorFinalEthereum, ripple, investidorId);
                dao.comprarReal(investidor, valorFinalReais);
                dao.geralEthereum(investidor, valorFinalEthereum);
                JOptionPane.showMessageDialog(view, "Compra realizada com sucesso!");
                JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                        + " " + "Saldo atual em Ethereum: " + valorFinalEthereum);
            } else {
                JOptionPane.showMessageDialog(view, "Erro de conexão.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
    //pega a taxa de compra da ethereum pela implementação da interface Tarifação
    @Override
    public double taxaCompraEthereum() {
        return 0.01;
    }

}
