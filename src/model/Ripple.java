package model;

/**
 * Classe que representa a moeda Ripple.
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
