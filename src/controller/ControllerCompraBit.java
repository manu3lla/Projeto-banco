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
import view.CompraBit;

/**
 * Autor: Manuella
 */
public class ControllerCompraBit implements Tarifacao {
    private Reais reais;
    private Investidor investidor;
    private CompraBit view;
    private Carteira c1;

    public ControllerCompraBit(CompraBit view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 = investidor.getC1();
    }

    public ControllerCompraBit(Reais reais) {
        this.reais = reais;
    }
    
    public void compraBitcoin() {
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
                double cotacao = getCotacao(0);
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");
                //pega quantidade de bitcoins que o usuario quer comprar na view
                double qtdBit = Double.parseDouble(view.getQuantidadeB().getText());
                //pega preço fixo da moeda na carteira
                double precoAtualBit = c1.getQtdBit().getValor();
                //contas para realizar a compra de bitcoin, aplicando cotação e taxa respectivas
                double compraBitcoin = qtdBit * cotacaoMoedas(precoAtualBit);
                double taxaBitcoin = compraBitcoin * taxaCompraBitcoin();
                double valorTotal = compraBitcoin + taxaBitcoin;
                
                if (qtdBit <= 0) {
                    JOptionPane.showMessageDialog(view, "Número de bitcoins a serem compradas negativo, escreva novamente");
                    return;
                }
                if (real <= valorTotal) {
                    JOptionPane.showMessageDialog(view, "Saldo insuficiente em reais para a compra de Bitcoins");
                    return;
                }
                //declara valor de reais e bitcoins a serem colocadas no banco
                double valorFinalBitcoin = bitcoin + qtdBit;
                double valorFinalReais = real - valorTotal;
                //pega data exata que usuário realizou a compra de bitcoins
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                //se tipo for "true" é uma compra
                boolean tipo = true;
                // manda informações para o banco (extrato, reais e bitcoins após a transação)
                dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacao, "Bitcoin TX: 0.02", valorFinalReais, valorFinalBitcoin, ethereum, ripple, investidorId);
                dao.comprarReal(investidor, valorFinalReais);
                dao.geralBit(investidor, valorFinalBitcoin);
                JOptionPane.showMessageDialog(view, "Depósito feito!");
                JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                        + " " + "Saldo atual em bitcoins: " + valorFinalBitcoin);
            } else {
                JOptionPane.showMessageDialog(view, "Erro de conexão.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
//pega a taxa de compra da bitcoin pela implementação da interface Tarifação
    @Override
    public double taxaCompraBitcoin() {
        return 0.02;
    }

}
