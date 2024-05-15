package controller;

import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DAO.Conexao;
import model.Carteira;
import model.Investidor;
import model.Tarifacao;
import view.AtualizaCot;
import view.MostraCot;

public class ControllerAtCot implements Tarifacao {
    private Investidor investidor;
    private Carteira carteira;

    public ControllerAtCot(Investidor investidor, Carteira carteira) {
        this.investidor = investidor;
        this.carteira = carteira;
    }

    public boolean atualizarCotacao(AtualizaCot view) {
        return atualizarCotacaoGeral(view);
    }

    public boolean atualizarCotacao(MostraCot view) {
        return atualizarCotacaoGeral(view);
    }

    private boolean atualizarCotacaoGeral(Object view) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()) {
                double cotacaobit = cotacaoMoedas(317415.56);
                double cotacaoet = cotacaoMoedas(15513.85);
                double cotacaor = cotacaoMoedas(2.32);
                setCotacao(0, cotacaobit);
                setCotacao(1, cotacaoet);
                setCotacao(2, cotacaor);
                if (view instanceof AtualizaCot) {
                    ((AtualizaCot) view).getTxtBit().setText(String.format("%.2f", cotacaobit));
                    ((AtualizaCot) view).getTxtEt().setText(String.format("%.2f", cotacaoet));
                    ((AtualizaCot) view).getTxtRi().setText(String.format("%.2f", cotacaor));
                } else if (view instanceof MostraCot) {
                    ((MostraCot) view).getBtVendaBit().setText(String.format("%.2f", cotacaobit));
                    ((MostraCot) view).getBtCompraEt().setText(String.format("%.2f", cotacaoet));
                    ((MostraCot) view).getBtVendaRi().setText(String.format("%.2f", cotacaor));
                }
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        }
    }
}
