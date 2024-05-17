package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import model.Reais;
import view.DepositoReal;
import view.Opcoes;

/**
 * Controlador para realizar depósitos em Reais
 * Autor: Manuella
 */
public class ControllerDeposito {
    private Reais reais;
    private DepositoReal view;
    private Carteira c1;

    public ControllerDeposito(DepositoReal view) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
    }

    public ControllerDeposito(Reais reais) {
        this.reais = reais;
    }

    public void depositoReal(Investidor investidor) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                double real = res.getDouble("reais");
                double deposito = Double.parseDouble(view.getTxtDeposito().getText());
                if (deposito <= 0) {
                    JOptionPane.showMessageDialog(view, "Valor de depósito negativo, deposite um valor positivo");
                    return;
                }
                double valorFinal = deposito + real;
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                boolean tipo = true;
                dao.extratoGeral(timestamp, tipo, deposito, 1.0, "Real", valorFinal, 0.0, 0.0, 0.0, 0);
                dao.depositar(investidor, valorFinal);
                JOptionPane.showMessageDialog(view, "Depósito realizado com sucesso! Saldo atual: " + valorFinal);
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
