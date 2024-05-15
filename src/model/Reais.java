package model;

public class Reais extends Moedas {
    public Reais(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, "Real");
    }
}
