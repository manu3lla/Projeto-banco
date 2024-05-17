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
import view.VendaEt;
import view.VendaRi;


/**
 *
 * @author Manuella
 */
public class ControllerVendaEt implements Tarifacao {
     private Reais reais;
     private Investidor investidor;
     private VendaEt view;
     private Carteira c1;
     
     
    public ControllerVendaEt(VendaEt view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 =investidor.getC1();
        
        
    }

    public ControllerVendaEt(Reais reais) {
        this.reais = reais;
    }

    public void vendaEt() {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
            double real = res.getDouble("reais");
            double bitcoin = res.getDouble("bitcoin");
            double ethereum = res.getDouble("ethereum");
            double ripple = res.getDouble("ripple");
            double qtdEt = Double.parseDouble(view.getTxtEt().getText());
            if (qtdEt > ethereum) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente, tente novamente!");
                return;
            }
            double precoAtualEthereum = c1.getQtdEt().getValor();
            double compraEt = (qtdEt*precoAtualEthereum) * cotacaoMoedas(precoAtualEthereum);
            double taxaEt = compraEt * taxaVendaEthereum();
            double valorTotal = compraEt + taxaEt;

            if (qtdEt <= 0) {
                JOptionPane.showMessageDialog(view, "Número de ethereum a serem compradas negativo, escreva novamente");
                return;
            }
            if (real <= valorTotal) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para a venda de Ethereums");
                return;
            }
            double valorFinalEt = ethereum - qtdEt;
            double valorFinalReais = real + valorTotal;
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralEthereum(investidor, valorFinalEt);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            boolean tipo = true;
            dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacaoMoedas(precoAtualEthereum), "Ethereum   taxa: 0.02", valorFinalReais, bitcoin, valorFinalEt, ripple, 0);
            JOptionPane.showMessageDialog(view, "Depósito feito!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em ethereum: " + valorFinalEt);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
    }
@Override
    public double taxaVendaEthereum() {
        return 0.02;
    }
}