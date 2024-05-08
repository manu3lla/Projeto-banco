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
import view.Compra;
import view.CompraBit;
import view.DepositoReal;


/**
 *
 * @author Manuella
 */
public class ControllerCompraBit {
     private Reais reais;
     private CompraBit view;
     
     
    public ControllerCompraBit(CompraBit view) {
        this.reais = new Reais(0, 0, 0, "Reais");
        this.view = view;
        
        
    }

    public ControllerCompraBit(Reais reais) {
        this.reais = reais;
    }

    public void compraBitcoin(Investidor investidor) {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
            double real = res.getDouble("reais");
            double bitcoin = res.getDouble("bitcoin");
            double qtdBit = Double.parseDouble(view.getQuantidadeB().getText());
            double compraBit = (qtdBit*0.0000031);
            if (bitcoin <= 0) {
                JOptionPane.showMessageDialog(view, "Número de bitcoins a serem compradas negativo, escreva novamente");
                return;
            }
            if (real <= compraBit) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente em reais para a compra de Bitcoins");
                return;
            }
            double valorFinalReal = real - compraBit;
            double valorFinalBitcoin = bitcoin + qtdBit;
            dao.depositar(investidor, valorFinalReal);
            dao.depositar(investidor, valorFinalBitcoin);
            JOptionPane.showMessageDialog(view, "Depósito feito!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReal 
                    + " " + "Saldo atual em bitcoins: " + valorFinalBitcoin);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}

}