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
import javax.swing.JOptionPane;

public class ControllerSenha {
    public boolean verSenha(Investidor investidor) {
    Conexao conexao = new Conexao();

    boolean senhaCorreta = false;

    while (!senhaCorreta) {
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                String cpfJanela = JOptionPane.showInputDialog("Digite seu CPF:");
                String senhaJanela = JOptionPane.showInputDialog("Digite sua senha:");
                String cpfBanco = res.getString("cpf");
                String senhaBanco = res.getString("senha");
                if (cpfJanela.equals(cpfBanco) && senhaJanela.equals(senhaBanco)) {
                    senhaCorreta = true;
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha incorretos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    return true;
}

}
