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
import view.DepositoReal;
import view.Login;
import view.SaqueReal;

/**
 *
 * @author Manuella
 */
public class ControllerSaque {
     private Reais reais;
     private SaqueReal view;
     
     
    public ControllerSaque(SaqueReal view) {
        this.reais = new Reais(0, 0, 0, "Reais");
        this.view = view;
        
        
    }

    public ControllerSaque(Reais reais) {
        this.reais = reais;
    }

    public void saqueReal(Investidor investidor) {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
            double real = res.getDouble("reais");
            double saque = Double.parseDouble(view.getTxtSaque().getText());
            double valorFinal = real - saque;
            dao.depositar(investidor, valorFinal);
            JOptionPane.showMessageDialog(view, "Depósito feito!");
            System.out.println("Saldo atual: " + valorFinal);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}

}
