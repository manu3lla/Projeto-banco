/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Reais;
import model.Tarifacao;
import view.Compra;
import view.CompraRipple;
import view.DepositoReal;
import view.Venda;


/**
 *
 * @author Manuella
 */
public class ControllerCompraRipple implements Tarifacao {
     private Reais reais;
     private Investidor investidor;
     private CompraRipple view;
     private Venda view2;
     
     
    public ControllerCompraRipple(CompraRipple view, Venda view2, Investidor investidor) {
        this.reais = new Reais(0, "Reais");
        this.view = view;
        this.view2 = view2;
        this.investidor = investidor;
        
        
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
            double precoRipple = 2.32;
            double compraRipple = qtdR * cotacaoCompra(precoRipple);
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
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralRipple(investidor, valorFinalRipple);
            JOptionPane.showMessageDialog(view, "Depósito feito!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em Ripples: " + valorFinalRipple);
            
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
    public void exibirCotacaoAtual() {
        double precoRipple = 2.32;
        double cotacaoAtual = cotacaoCompra(precoRipple);

        JOptionPane.showMessageDialog(view, "Cotação atual da Ripple: " + cotacaoAtual);
    }
}