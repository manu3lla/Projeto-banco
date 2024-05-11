/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author Manuella
 */
public interface Tarifacao {
    default double taxaCompraBitcoin() {
        return 0.02;
    }
    default double taxaVendaBitcoin() {
        return 0.03;
    }
    default double taxaCompraEthereum() {
        return 0.01;
    }
    default double taxaVendaEthereum() {
        return 0.02;
    }
    default double taxaCompraRipple() {
        return 0.01;
    }
    default double taxaVendaRipple() {
        return 0.01;
    }
    default double cotacaoCompra(double precoAtual) {
        double variacao = precoAtual * 0.05;
        double variacaoMoedas = variacao * new Random().nextDouble();
        return precoAtual + variacaoMoedas;
    }

    default double cotacaoVenda(double precoAtual) {
        double variacao = precoAtual * 0.05;
        double variacaoMoedas = variacao * new Random().nextDouble();
        return precoAtual - variacaoMoedas;
    }
    
}


