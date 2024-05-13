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
import view.CompraEthereum;
import view.DepositoReal;
import view.MostraCot;
import view.MostrarMoedas;


/**
 *
 * @author Manuella
 */
public class ControllerCompraEthereum implements Tarifacao {
     private Reais reais;
     private Investidor investidor;
     private CompraEthereum view;
     private MostraCot view2;
     
     
    public ControllerCompraEthereum(CompraEthereum view, Investidor investidor) {
        this.reais = new Reais(0, "Reais");
        this.view = view;
        this.investidor = investidor;
        
        
        
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
            double real = res.getDouble("reais");
            double ethereum = res.getDouble("ethereum");
            double qtdEthereum = Double.parseDouble(view.getComprarE().getText());
            double precoAtualCompraEthereum = 15513.85;
            double compraEt = qtdEthereum * cotacaoMoedas(precoAtualCompraEthereum);
            double taxaEthereum = compraEt * taxaCompraEthereum();
            double valorTotal = compraEt + taxaEthereum;
            
            if (qtdEthereum <= 0) {
                JOptionPane.showMessageDialog(view, "Número de Ethereums a serem compradas negativo, escreva novamente");
                return;
            }
            if (real <= valorTotal) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente em reais para a compra de Ethereums");
                return;
            }
            double valorFinalEthereum = ethereum + qtdEthereum;
            double valorFinalReais = real - valorTotal;
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralEthereum(investidor, valorFinalEthereum);
            JOptionPane.showMessageDialog(view, "Depósito feito!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em Ethereum: " + valorFinalEthereum);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}
    @Override
    public double taxaCompraEthereum() {
        return 0.01;
    }
}