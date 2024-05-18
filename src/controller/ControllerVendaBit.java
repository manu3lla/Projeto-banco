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
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import model.Reais;
import model.Tarifacao;
import view.Compra;
import view.CompraBit;
import view.DepositoReal;
import view.VendaBit;


/**
 *
 * @author Manuella
 */
public class ControllerVendaBit implements Tarifacao{
     private Reais reais;
     private Investidor investidor;
     private VendaBit view;
     private Carteira c1;
     
     
    public ControllerVendaBit(VendaBit view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 =investidor.getC1();
        
        
    }

    public ControllerVendaBit(Reais reais) {
        this.reais = reais;
    }

    public void vendaBitcoin() {
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
            double qtdBit = Double.parseDouble(view.getTxtBit().getText());
            if (qtdBit > bitcoin ) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente, tente novamente!");
                return;
            }
            double precoAtualBit = c1.getQtdBit().getValor();
            double compraBitcoin = qtdBit * cotacaoMoedas(precoAtualBit);
            double taxaBitcoin = compraBitcoin * taxaVendaBitcoin();
            System.out.println(taxaVendaBitcoin());
            double valorTotal = compraBitcoin + taxaBitcoin;
            
            if (qtdBit <= 0) {
                JOptionPane.showMessageDialog(view, "Número de bitcoins a serem compradas negativo, escreva novamente");
                return;
            }
            if (bitcoin < qtdBit) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para a venda de Bitcoins");
                return;
            }
            double valorFinalBitcoin = bitcoin - qtdBit;
            double valorFinalReais = real + valorTotal;
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralBit(investidor, valorFinalBitcoin);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            boolean tipo = true;
            dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacaoMoedas(precoAtualBit), "Bitcoin  TX: 0.03", valorFinalReais, valorFinalBitcoin, ethereum, ripple, investidorId);
            JOptionPane.showMessageDialog(view, "Venda de bitcoins feita!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em bitcoins: " + valorFinalBitcoin);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}
    @Override
    public double taxaVendaBitcoin() {
        return 0.03;
    }
}