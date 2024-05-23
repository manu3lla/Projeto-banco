package model;

public class Reais extends Moedas {
    //pega informações do model das moedas
    public Reais(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        super(valor, taxavenda, taxacompra, cotacao, "Real");
    }
}
