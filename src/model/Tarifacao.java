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
    double[] cotacoes = new double[3];
    
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
    
    default double cotacaoMoedas(double precoAtual) {
        Random random = new Random();
        double variacao = (random.nextDouble() - 0.5) * 0.01;
        return precoAtual * (1 + variacao);
    }
    default void setCotacao(int index, double cotacao) {
        cotacoes[index] = cotacao;
    }
    default double getCotacao(int index) {
        return cotacoes[index];
    }
    
    
}


