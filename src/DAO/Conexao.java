
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
//estabelecendo conexao com o banco de dados "testee"
public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/testee",
        "postgres","fei");
        return conexao;
    }
}