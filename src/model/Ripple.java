/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifmperes
 */
public class Ripple extends Moedas implements Tarifacao {

    public Ripple(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, nomemoeda);
    }

    @Override
    public double taxaCompraRipple() {
        return Tarifacao.super.taxaCompraRipple();
    }

    @Override
    public double taxaVendaRipple() {
        return Tarifacao.super.taxaVendaRipple();
    }

    @Override
    public double cotacaoMoedas(double precoAtual) {
        return Tarifacao.super.cotacaoMoedas(precoAtual);
    }
}