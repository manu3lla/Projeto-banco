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
import model.Carteira;
import model.Investidor;
import model.Reais;
import model.Tarifacao;
import view.Compra;
import view.CompraBit;
import view.DepositoReal;


/**
 *
 * @author Manuella
 */
public class ControllerCompraBit implements Tarifacao {
     private Reais reais;
     private Investidor investidor;
     private CompraBit view;
     private Carteira c1;
     
     
    public ControllerCompraBit(CompraBit view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view =view;
        this.investidor = investidor;
        
        
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
            double real = res.getDouble("reais");
            double bitcoin = res.getDouble("bitcoin");
            double qtdBit = Double.parseDouble(view.getQuantidadeB().getText());
            double precoAtualBit = 317415.56; 
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
            double valorFinalBitcoin = bitcoin + qtdBit;
            double valorFinalReais = real - valorTotal;
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
    @Override
    public double taxaCompraBitcoin() {
        return 0.02;
    }

}