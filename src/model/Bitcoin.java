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

    public Bitcoin(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(317415.56, taxavenda, taxacompra, cotacao, "Bitcoin");
    }
    
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


