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
import view.Opcoes;

/**
 *
 * @author Manuella
 */
public class ControllerSenha {

    public void verSenha(Investidor investidor) {
    Conexao conexao = new Conexao();
    try {
        
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
           String senhaDigitada = senha.getTxtSenha();
           String senhaBanco = res.getString("senha");
                if (senhaDigitada.equals(senhaBanco)) {
                    JOptionPane.showMessageDialog(null, "Bem vindo usuário!");
                    Opcoes opcoes = new Opcoes(investidor);
                    opcoes.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
        }
        } } catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
}

}