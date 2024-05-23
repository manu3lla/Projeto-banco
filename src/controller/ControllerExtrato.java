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
import java.text.DecimalFormat;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import model.Usuario;
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
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        ResultSet resultado = usuarioDAO.consultar(investidor);
        if (resultado.next()) {
            //pega id do usuario
            int id = resultado.getInt("id");
            ResultSet res = usuarioDAO.obterExtrato(investidor, id);
            StringBuilder extratoTexto = new StringBuilder();
            DecimalFormat df = new DecimalFormat("#.##");
            while (res.next()) {
                //pega o usuario especifico dentro da conexão e ve seu nome e cpf
                Usuario usuarioConsultado = usuarioDAO.consultarNomeCpf(investidor);
                if (usuarioConsultado != null) {
                    String nome = usuarioConsultado.getNome();
                    String cpf = usuarioConsultado.getCpf();
                    extratoTexto.append("Nome: ").append(nome).append("\n");
                    extratoTexto.append("CPF: ").append(cpf).append("\n");
                }
                else{
                    System.out.println("Usuário não encontrado");}
                //pega informações no banco
                Timestamp data = res.getTimestamp("data");
                boolean tipo = res.getBoolean("tipo");
                double valor = res.getDouble("valor");
                double cotacao = res.getDouble("cotacao");
                String nomeMoeda = res.getString("nome_moeda");
                double saldoReais = res.getDouble("real");
                double saldoBitcoin = res.getDouble("bitcoin");
                double saldoEthereum = res.getDouble("ethereum");
                double saldoRipple = res.getDouble("ripple");
                //printando informações no extrato
                extratoTexto.append("Data: ").append(data).append(" ");
                extratoTexto.append("Moeda: ").append(nomeMoeda).append(" ");
                extratoTexto.append("CT: ").append(df.format(cotacao)).append(", ");
                extratoTexto.append(tipo ? "- " : "+ ");
                extratoTexto.append(df.format(valor)).append(" ");
                extratoTexto.append("REAL: ").append(df.format(saldoReais)).append(" ");
                extratoTexto.append("BTC: ").append(df.format(saldoBitcoin)).append(" ");
                extratoTexto.append("ETH: ").append(df.format(saldoEthereum)).append(" ");
                extratoTexto.append("XRP: ").append(df.format(saldoRipple)).append("\n\n");
            }
            //manda para a view do extrato para printar as informações acima
            JTextArea textArea = (JTextArea) ((JViewport) view.getTxtExtrato().getComponent(0)).getView();
            textArea.setText(extratoTexto.toString());
        } else {
            JOptionPane.showMessageDialog(view, "Nenhum resultado encontrado.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro ao carregar extrato: " + e.getMessage());
    }
}

}
