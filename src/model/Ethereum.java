/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifmperes
 */
public class Ethereum extends Moedas implements Tarifacao {

    public Ethereum(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, nomemoeda);
    }

    @Override
    public double taxaCompraEthereum() {
        return Tarifacao.super.taxaCompraEthereum();
    }

    @Override
    public double taxaVendaEthereum() {
        return Tarifacao.super.taxaVendaEthereum();
    }

    @Override
    public double cotacaoMoedas(double precoAtual) {
        return Tarifacao.super.cotacaoMoedas(precoAtual);
    }
}