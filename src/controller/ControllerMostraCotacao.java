package controller;
import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Carteira;
import model.Investidor;
import model.Tarifacao;
import view.MostraCot;

public class ControllerMostraCotacao implements Tarifacao {
    private MostraCot view;
    private Investidor investidor;
    private Carteira c1;

    public ControllerMostraCotacao(MostraCot view, Investidor investidor, Carteira c1) {
        this.view = view;
        this.investidor = investidor;
        this.c1 = c1;
    }

    public boolean mostraCota() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                double cotacaobit = investidor.getC1().getQtdBit().cotacaoMoedas(317415.56);
                view.getBtVendaBit().setText(String.valueOf(cotacaobit));
                double cotacaoet = investidor.getC1().getQtdBit().cotacaoMoedas(15513.85);
                view.getBtCompraEt().setText(String.valueOf(cotacaoet));
                double cotacaor = investidor.getC1().getQtdBit().cotacaoMoedas(2.32);
                view.getBtVendaRi().setText(String.valueOf(cotacaor));
                System.out.println(cotacaobit);
                System.out.println(cotacaoet);
                System.out.println(cotacaor);
                
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
