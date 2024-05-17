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
import java.sql.Timestamp;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import view.Extrato;

/**
 * Autor: Manuella
 */
public class ControllerExtrato {
    private Reais reais;
    private Investidor investidor;
    private Extrato view;
    private Carteira c1;

    public ControllerExtrato(Extrato view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 = investidor.getC1();
    }

    public void carregarExtrato() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet resultado = dao.consultar(investidor);
            if (resultado.next()){
                int id = resultado.getInt("id");
                ResultSet res = dao.obterExtrato(investidor, id);
            StringBuilder extratoTexto = new StringBuilder();

            while (res.next()) {
                Timestamp data = res.getTimestamp("data");
                boolean tipo = res.getBoolean("tipo");
                double valor = res.getDouble("valor");
                double cotacao = res.getDouble("cotacao");
                String nomeMoeda = res.getString("nome_moeda");
                double saldoReais = res.getDouble("real");
                double saldoBitcoin = res.getDouble("bitcoin");
                double saldoEthereum = res.getDouble("ethereum");
                double saldoRipple = res.getDouble("ripple");

            extratoTexto.append("Data: ").append(data).append(", ");
            extratoTexto.append("Tipo: ").append(tipo ? "Compra" : "Venda").append(", ");
            extratoTexto.append("Valor: ").append(valor).append(", ");
            extratoTexto.append("Cotação: ").append(cotacao).append(", ");
            extratoTexto.append("Moeda: ").append(nomeMoeda).append(", ");
            extratoTexto.append("Saldo em Reais: ").append(saldoReais).append(", ");
            extratoTexto.append("Saldo em Bitcoin: ").append(saldoBitcoin).append(", ");
            extratoTexto.append("Saldo em Ethereum: ").append(saldoEthereum).append(", ");
            extratoTexto.append("Saldo em Ripple: ").append(saldoRipple).append("\n");
            }

             JTextArea textArea = (JTextArea) ((JViewport) view.getTxtExtrato().getComponent(0)).getView();
                textArea.setText(extratoTexto.toString());
        } 
            }
            catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar extrato: " + e.getMessage());
        }
            
    }
}
