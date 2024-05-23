package control;

import DAO.Conexao;
import model.Usuario;
import view.Login;
import java.sql.Connection;
import DAO.UsuarioDAO;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Carteira;
import model.Investidor;
import view.Login;
import view.Opcoes;

public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public boolean loginUsuario(){
        //pega o usuario no banco, seu nome, cpf e senha
        Usuario usuario = new Usuario(null, view.getTxtCpf().getText(),
                                      view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                //se usuário existir no banco ele deixa entrar no programa
            JOptionPane.showMessageDialog(view,"Login Feito!");
            String nome = res.getString("nome");
            String cpf = res.getString("cpf");
            String senha = res.getString("senha");
            Investidor investidor = new Investidor(nome, cpf, senha);
            Opcoes opcoesFrame = new Opcoes(investidor);
            opcoesFrame.setVisible(true);
            view.setVisible(false);
            return true;
            } else{
                JOptionPane.showMessageDialog(view,"Login não foi efeituado.");
                return false;
            }
            
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
            return false;
        }
    }
}

