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
import view.CompraBit;
import view.DepositoReal;
import view.VendaRi;


/**
 *
 * @author Manuella
 */
public class ControllerVendaRipple implements Tarifacao {
     private Reais reais;
     private Investidor investidor;
     private VendaRi view;
     
     
    public ControllerVendaRipple(VendaRi view, Investidor investidor) {
        this.reais = new Reais(0, "Reais");
        this.view = view;
        this.investidor = investidor;
        
        
    }

    public ControllerVendaRipple(Reais reais) {
        this.reais = reais;
    }

    public void vendaRipple() {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
            double real = res.getDouble("reais");
            double ripple = res.getDouble("ripple");
            double qtdRi = Double.parseDouble(view.getTxtRi().getText());
            if (qtdRi > ripple ) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente, tente novamente!");
                return;
            }
            double precoAtualVendaRipple = 2.32;
                double vendaRipple = qtdRi * cotacaoMoedas(precoAtualVendaRipple);
                double taxaRipple = vendaRipple * taxaVendaRipple();
                double valorTotal = vendaRipple + taxaRipple;
            
            if (qtdRi <= 0) {
                JOptionPane.showMessageDialog(view, "Número de ripples a serem compradas negativo, escreva novamente");
                return;
            }
            if (real <= valorTotal) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para a venda de Ripples");
                return;
            }
            double valorFinalRipple = ripple - qtdRi;
            double valorFinalReais = real + valorTotal;
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralRipple(investidor, valorFinalRipple);
            JOptionPane.showMessageDialog(view, "Depósito feito!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em ripple: " + valorFinalRipple);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}
    @Override
    public double taxaVendaRipple() {
        return 0.01;
    }

}