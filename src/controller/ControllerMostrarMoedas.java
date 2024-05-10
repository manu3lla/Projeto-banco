package controller;
import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.MostrarMoedas;

public class ControllerMostrarMoedas {
    private MostrarMoedas view;
    private Investidor investidor;

    public ControllerMostrarMoedas(MostrarMoedas view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    public boolean mostraMoeda() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                String nome = res.getString("nome");
                String cpf = res.getString("CPF");
                double real = res.getDouble("reais");
                double ripple = res.getDouble("ripple");
                double ethereum = res.getDouble("ethereum");
                double bitcoin = res.getDouble("bitcoin");
                view.getTxtNome().setText(nome);
                view.getTxtCpf().setText(cpf);
                view.getTxtReal().setText(String.valueOf(real));
                view.getTxtBit().setText(String.valueOf(bitcoin));
                view.getTxtEt().setText(String.valueOf(ethereum));
                view.getTxtRipple().setText(String.valueOf(ripple));
                
                return true;
            } else {
                JOptionPane.showMessageDialog(view, "Usuário não encontrado.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
            return false;
        }
    }
}
