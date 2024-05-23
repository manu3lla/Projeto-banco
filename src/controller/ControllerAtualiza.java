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
    private Investidor investidor;

    public ControllerAtualiza(AtualizaUs view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    public boolean atualizarUsuario(Investidor investidor) {
        try {
            //conectando com o banco
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultarPorCPF(investidor);
            //ve se o nome e cpf correspondem com o banco, caso sim, deixa usuário atualizar senha
            if (res.next() && investidor.getCpf().equals(res.getString("cpf"))
                    && investidor.getNome().equals(res.getString("nome"))) {
                dao.atualizar(investidor);
                JOptionPane.showMessageDialog(view, "Atualização de senha foi efetuada.");
                return true;
            } else {
                JOptionPane.showMessageDialog(view, "Atualização de senha não foi efetuada.");
                return false;
            }
            //erro de conexão
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão");
            return false;
        }
    }
}
