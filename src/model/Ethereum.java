package model;

/**
 * Classe que representa a moeda Ethereum.
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
