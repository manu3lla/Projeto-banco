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
import java.sql.Timestamp;
import view.Login;
import view.Opcoes;
import view.SaqueReal;

/**
 *
 * @author Manuella
 */
public class ControllerSaque {
     private Reais reais;
     private SaqueReal view;
     
     
    public ControllerSaque(SaqueReal view) {
        this.reais = new Reais(0,0,0, 0, "Reais");
        this.view = view;
        
        
    }

    public ControllerSaque(Reais reais) {
        this.reais = reais;
    }

    public void saqueReal(Investidor investidor) {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
            int investidorId = res.getInt("id");
            double real = res.getDouble("reais");
            double bitcoin = res.getDouble("bitcoin");
            double ethereum = res.getDouble("ethereum");
            double ripple = res.getDouble("ripple");
            double saque = Double.parseDouble(view.getTxtSaque().getText());
             if (saque > real) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente, tente novamente!");
                return;
            }
            double valorFinal = real - saque;
            dao.depositarSacar(investidor, valorFinal);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            boolean tipo = true;
            dao.extratoGeral(investidor, timestamp, tipo, saque, 1.0, "Real  TX: 1", valorFinal, bitcoin, ethereum, ripple, investidorId);
            JOptionPane.showMessageDialog(view, "Saque feito!" + "Saldo atual: " + valorFinal);
            view.dispose();
            Opcoes opcoes = new Opcoes(investidor);
            opcoes.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}

}
