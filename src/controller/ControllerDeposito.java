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

/**
 *
 * @author Manuella
 */
public class ControllerDeposito {
     private Reais reais;
     private DepositoReal view;
     
     
    public ControllerDeposito(DepositoReal view) {
        this.reais = new Reais(0, 0, 0, "Reais");
        this.view = view;
        
        
    }

    public ControllerDeposito(Reais reais) {
        this.reais = reais;
    }

    public void depositoReal(Investidor investidor){
        Conexao conexao = new Conexao();
        try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar(investidor);
                double real = res.getDouble("reais");
                double deposito = Double.parseDouble(view.getTxtDeposito().getText());
                double valorFinal = deposito+real;
                dao.depositar(investidor, valorFinal);
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão");
            }

        
    }
}
