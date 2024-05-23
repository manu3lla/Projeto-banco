package model;

/**
* @author Manuella
 */
public class Ethereum extends Moedas implements Tarifacao {
    //pega informações do model das moedas
    public Ethereum(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, nomemoeda);
    }
//pega as taxas de compra e venda das ethereums e cotação pela tarifação
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
