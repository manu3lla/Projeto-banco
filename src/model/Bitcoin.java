/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifmperes
 */

public class Bitcoin extends Moedas implements Tarifacao {
    //pega informações do model das moedas
    public Bitcoin(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, nomemoeda);
    }
    //pega as taxas de compra e venda das bitcoins e cotação pela tarifação
    @Override
    public double taxaCompraBitcoin() {
        return Tarifacao.super.taxaCompraBitcoin();
    }

    @Override
    public double taxaVendaBitcoin() {
        return Tarifacao.super.taxaVendaBitcoin();
    }

    @Override
    public double cotacaoMoedas(double precoAtual) {
        return Tarifacao.super.cotacaoMoedas(precoAtual);
    }
}


