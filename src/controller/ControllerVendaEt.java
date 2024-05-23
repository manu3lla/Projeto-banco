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
            //pega informações no banco, principalmente para serem utilizadas no extrato
            int investidorId = res.getInt("id");
            double real = res.getDouble("reais");
            double bitcoin = res.getDouble("bitcoin");
            double ethereum = res.getDouble("ethereum");
            double cotacao = getCotacao(1);
            double ripple = res.getDouble("ripple");
            //pega quantidade de ethereums que o usuario quer comprar na view
            double qtdEt = Double.parseDouble(view.getTxtEt().getText());
            if (qtdEt > ethereum) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente, tente novamente!");
                return;
            }
            //pega preço fixo da moeda na carteira
            double precoAtualEthereum = c1.getQtdEt().getValor();
             //contas para realizar a compra de ethereum, aplicando cotação e taxa respectivas
            double compraEt = qtdEt * cotacaoMoedas(precoAtualEthereum);
            double taxaEt = compraEt * taxaVendaEthereum();
            double valorTotal = compraEt + taxaEt;

            if (qtdEt <= 0) {
                JOptionPane.showMessageDialog(view, "Número de ethereum a serem compradas negativo, escreva novamente");
                return;
            }
            if (ethereum < qtdEt) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para a venda de Ethereums");
                return;
            }
             //declara valor de reais e ethereums a serem colocadas no banco
            double valorFinalEt = ethereum - qtdEt;
            double valorFinalReais = real + valorTotal;
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralEthereum(investidor, valorFinalEt);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            boolean tipo = false;
            // manda informações para o banco (extrato, reais e ethereums após a transação)
            dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacao, "Ethereum  TX: 0.02", valorFinalReais, bitcoin, valorFinalEt, ripple, investidorId);
            JOptionPane.showMessageDialog(view, "Venda de ethereums feita!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em ethereum: " + valorFinalEt);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
    }
        //pega a taxa de compra da ethereum pela implementação da interface Tarifação
@Override
    public double taxaVendaEthereum() {
        return 0.02;
    }
}