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
import view.VendaRi;


/**
 *
 * @author Manuella
 */
public class ControllerVendaRipple implements Tarifacao {
     private Reais reais;
     private Investidor investidor;
     private VendaRi view;
     private Carteira c1;
     
     
    public ControllerVendaRipple(VendaRi view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 =investidor.getC1();
    }

    public ControllerVendaRipple(Reais reais) {
        this.reais = reais;
    }

    public void vendaRipple() {
    Conexao conexao = new Conexao();
    try {
        //estabelecendo a conexão
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultar(investidor);
        if (res.next()) {
            //pega informações no banco, principalmente para serem utilizadas no extrato
            int investidorId = res.getInt("id");
            double real = res.getDouble("reais");
            double bitcoin = res.getDouble("bitcoin");
            double ethereum = res.getDouble("ethereum");
            double cotacao = getCotacao(2);
            double ripple = res.getDouble("ripple");
            //pega quantidade de ripples que o usuario quer comprar na view
            double qtdRi = Double.parseDouble(view.getTxtRi().getText());
            if (qtdRi > ripple ) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente, tente novamente!");
                return;
            }
            //pega preço fixo da moeda na carteira
            double precoRipple = c1.getQtdRipple().getValor();
            //contas para realizar a compra de ethereum, aplicando cotação e taxa respectivas
            double vendaRipple = qtdRi * cotacaoMoedas(precoRipple);
            double taxaRipple = vendaRipple * taxaVendaRipple();
            double valorTotal = vendaRipple + taxaRipple;
            
            if (qtdRi <= 0) {
                JOptionPane.showMessageDialog(view, "Número de ripples a serem compradas negativo, escreva novamente");
                return;
            }
            if (ripple < qtdRi) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para a venda de Ripples");
                return;
            }
             //declara valor de reais e ripple a serem colocadas no banco
            double valorFinalRipple = ripple - qtdRi;
            double valorFinalReais = real + valorTotal;
            dao.comprarReal(investidor, valorFinalReais);
            dao.geralRipple(investidor, valorFinalRipple);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            boolean tipo = false;
             // manda informações para o banco (extrato, reais e ripples após a transação)
            dao.extratoGeral(investidor, timestamp, tipo, valorTotal, cotacao, "Ripple  TX: 0.01", valorFinalReais, bitcoin, ethereum, valorFinalRipple, investidorId);
            JOptionPane.showMessageDialog(view, "Venda de ripples feita!");
            JOptionPane.showMessageDialog(view, "Saldo atual em reais: " + valorFinalReais 
                    + " " + "Saldo atual em ripple: " + valorFinalRipple);
        } else {
            JOptionPane.showMessageDialog(view, "Erro de conexão.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
} //pega a taxa de compra da ripple pela implementação da interface Tarifação
    @Override
    public double taxaVendaRipple() {
        return 0.01;
    }

}