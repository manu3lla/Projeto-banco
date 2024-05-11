/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Usuario;
import view.AtualizaUs;
import java.sql.ResultSet;
import view.Login;

/**
 *
 * @author Manuella
 */
public class ControllerAtualiza {
    private AtualizaUs view;

    public ControllerAtualiza(AtualizaUs view) {
        this.view = view;
    }

    public boolean atualizarUsuario() {
        String cpf = view.getTxtCpf().getText();
        String senha = view.getTxtSenha().getText();
        Conexao conexao = new Conexao();
        Usuario usuario = new Usuario(null, view.getTxtCpf().getText(),
                                      view.getTxtSenha().getText());

        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);

            if (res.next()) {
                JOptionPane.showMessageDialog(view, "Login Feito!");
                String nome = res.getString("nome");
                Investidor investidor = new Investidor(nome, cpf, senha);
                String novaSenha = "";
                dao.atualizar(usuario);

                return true;
            } else {
                JOptionPane.showMessageDialog(view, "Atualização de senha não foi efetuada.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão");
            return false;
        }
    }
}
