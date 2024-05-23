package model;

/**
 * @author Manuella
 */
public class Ripple extends Moedas implements Tarifacao {
    //pega informações do model das moedas
    public Ripple(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, nomemoeda);
    }
     //pega as taxas de compra e venda das bitcoins e cotação pela tarifação
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
