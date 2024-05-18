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
import java.sql.Timestamp;
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
    public ResultSet consultarPorCPF(Usuario usuario) throws SQLException{
        String sql = "select * from aa where cpf = ? and nome = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getNome());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    public void atualizar(Usuario usuario) throws SQLException{
        String sql = "update aa set senha = ? where cpf = ? and nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getCpf());
        statement.setString(3, usuario.getNome());
        statement.execute();
        conn.close();
    }
    public void depositar(Investidor investidor, double valor) throws SQLException{
        String sql = "UPDATE aa SET reais = ? WHERE senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void comprarReal(Investidor investidor, double valor) throws SQLException{
        String sql = "UPDATE aa SET reais = ? WHERE senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void geralBit(Investidor investidor, double valor) throws SQLException{
        String sql = "UPDATE aa SET bitcoin = ? WHERE senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void geralRipple(Investidor investidor, double valor) throws SQLException{
        String sql = "UPDATE aa SET ripple = ? WHERE senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    public void geralEthereum(Investidor investidor, double valor) throws SQLException{
        String sql = "UPDATE aa SET ethereum = ? WHERE senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
  
    public void extratoGeral(Investidor investidor, Timestamp data, boolean tipo, double valor, double cotacao, String nomeMoeda, double saldoReais, double saldoBitcoin, double saldoEthereum, double saldoRipple, int investidorId) throws SQLException {
    String checkSql = "SELECT id FROM extrato WHERE id = ?";
    try (PreparedStatement checkStatement = conn.prepareStatement(checkSql)) {
        checkStatement.setInt(1, investidorId);
        ResultSet resultado = checkStatement.executeQuery();
        if (!resultado.next()) {
            return;
        }
    }

    String insertSql = "INSERT INTO extrato (data, tipo, valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
        insertStatement.setTimestamp(1, data);
        insertStatement.setBoolean(2, tipo);
        insertStatement.setDouble(3, valor);
        insertStatement.setDouble(4, cotacao);
        insertStatement.setString(5, nomeMoeda);
        insertStatement.setDouble(6, saldoReais);
        insertStatement.setDouble(7, saldoBitcoin);
        insertStatement.setDouble(8, saldoEthereum);
        insertStatement.setDouble(9, saldoRipple);
        insertStatement.setInt(10, investidorId);

        insertStatement.executeUpdate();
    }
}
    public ResultSet obterExtrato(Investidor investidor, int Id) throws SQLException {
        String sql = "SELECT * FROM extrato WHERE id_pessoa = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, Id);
        statement.execute();
        ResultSet res = statement.getResultSet();
        return res;
    }
    
    public Usuario consultarNomeCpf(Usuario usuario) throws SQLException {
    String sql = "SELECT nome, cpf FROM aa WHERE cpf = ? AND senha = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, usuario.getCpf());
    statement.setString(2, usuario.getSenha());
    ResultSet resultado = statement.executeQuery();
    if (resultado.next()) {
        String nome = resultado.getString("nome");
        String cpf = resultado.getString("cpf");
        Usuario usuarioConsultado = new Usuario();
        usuarioConsultado.setNome(nome);
        usuarioConsultado.setCpf(cpf);
        
        return usuarioConsultado;
    } else {
        return null;
    }
}

}

