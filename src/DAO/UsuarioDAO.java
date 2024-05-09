/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Usuario;
import java.sql.PreparedStatement;
import model.Investidor;

public class UsuarioDAO {
    private Connection conn;
    
    public UsuarioDAO (Connection conn){
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        //String sql = "select * from aluno where usuario = '" +
        //        aluno.getUsuario() + "' AND senha = '" +
        //        aluno.getSenha() + "'";
        String sql = "select * from aa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    public void depositar(Investidor investidor, double valor) throws SQLException{
        String sql = "update aa set reais = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    public void comprarReal(Investidor investidor, double valor) throws SQLException{
        String sql = "update aa set reais = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void comprarBit(Investidor investidor, double valor) throws SQLException{
        String sql = "update aa set bitcoin = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void comprarRipple(Investidor investidor, double valor) throws SQLException{
        String sql = "update aa set ripple = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void comprarEthereum(Investidor investidor, double valor) throws SQLException{
        String sql = "update aa set ethereum = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
}
