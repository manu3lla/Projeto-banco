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
        conn.close();
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
    public void atualizarCotacaoBitcoin(double cotacaoBitcoin) throws SQLException {
    String sql = "UPDATE cotacoes SET cotacaobit = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setDouble(1, cotacaoBitcoin);
    statement.execute();
}
    public void atualizarCotacaoEth(double cotacaoEt) throws SQLException {
    String sql = "UPDATE cotacoes SET cotacaoethereum = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setDouble(1, cotacaoEt);
    statement.execute();
}
    public void atualizarCotacaoRi(double cotacaoRi) throws SQLException {
    String sql = "UPDATE cotacoes SET cotacaoripple = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setDouble(1, cotacaoRi);
    statement.execute();
}
    public void extratoGeral(Timestamp data, boolean tipo, double valor, double cotacao, String nomeMoeda, double saldoReais, double saldoBitcoin, double saldoEthereum, double saldoRipple, int investidorId) throws SQLException {
    String sql = "INSERT INTO extrato (data, tipo, valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setTimestamp(1, data);
        statement.setBoolean(2, tipo);
        statement.setDouble(3, valor);
        statement.setDouble(4, cotacao);
        statement.setString(5, nomeMoeda);
        statement.setDouble(6, saldoReais);
        statement.setDouble(7, saldoBitcoin);
        statement.setDouble(8, saldoEthereum);
        statement.setDouble(9, saldoRipple);
        statement.setInt(10, investidorId);
        
        statement.executeUpdate();
    }

    }
}
