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

/**
 * Controlador para a compra de Ripple
 * Autor: Manuella
 */
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
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                double real = res.getDouble("reais");
                double ripple = res.getDouble("ripple");
                double qtdR = Double.parseDouble(view.getCompraRi().getText());
                double precoRipple = c1.getQtdRipple().getValor();
                double compraRipple = qtdR * precoRipple;
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
                double valorFinalRipple = ripple + qtdR;
                double valorFinalReais = real - valorTotal;

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                boolean tipo = true;
                dao.extratoGeral(timestamp, tipo, valorTotal, precoRipple, "Ripple", valorFinalReais, valorFinalRipple, c1.getQtdBit().getValor(), c1.getQtdEt().getValor(), 0);

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

    @Override
    public double taxaCompraRipple() {
        return 0.01;
    }
}
