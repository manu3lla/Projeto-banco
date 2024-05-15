package model;

/**
 * 
 * @author Manuella
 */
public class Carteira implements Tarifacao {
    private Reais qtdReais;
    private Bitcoin qtdBit;
    private Ethereum qtdEt;
    private Ripple qtdRipple;

    public Carteira() {
        this.qtdReais = new Reais(0, 0, 0, 1, "Real");
        this.qtdBit = new Bitcoin(317415.56, 0.03, 0.02, getCotacaoBitcoin(), "Bitcoin");
        this.qtdEt = new Ethereum(15513.85, 0.02, 0.01, getCotacaoEthereum(), "Ethereum");
        this.qtdRipple = new Ripple(2.32, 0.01, 0.01, getCotacaoRipple(), "Ripple");
    }

    private double getCotacaoBitcoin() {
        return cotacaoMoedas(317415.56);
    }

    private double getCotacaoEthereum() {
        return cotacaoMoedas(15513.85);
    }

    private double getCotacaoRipple() {
        return cotacaoMoedas(2.32);
    }

    public Bitcoin getQtdBit() {
        if (qtdBit == null) {
            qtdBit = new Bitcoin(0, 0.03, 0.02, getCotacaoBitcoin(), "Bitcoin");
        }
        return qtdBit;
    }

    public void setQtdBit(Bitcoin qtdBit) {
        this.qtdBit = qtdBit;
    }

    public Reais getQtdReais() {
        return qtdReais;
    }

    public void setQtdReais(Reais qtdReais) {
        this.qtdReais = qtdReais;
    }

    public Ethereum getQtdEt() {
        return qtdEt;
    }

    public void setQtdEt(Ethereum qtdEt) {
        this.qtdEt = qtdEt;
    }

    public Ripple getQtdRipple() {
        return qtdRipple;
    }

    public void setQtdRipple(Ripple qtdRipple) {
        this.qtdRipple = qtdRipple;
    }

    @Override
    public String toString() {
        return "Carteira{" + "qtdReais=" + qtdReais + ", qtdBit=" + qtdBit + ", qtdEt=" + qtdEt + ", qtdRipple=" + qtdRipple + '}';
    }
}
