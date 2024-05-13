/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manuella
 */
public class Carteira {
    private Reais qtdReais;
    private Bitcoin qtdBit;
    private Ethereum qtdEt;
    private Ripple qtdRipple;

    public Reais getQtdReais() {
        return qtdReais;
    }

    public void setQtdReais(Reais qtdReais) {
        this.qtdReais = qtdReais;
    }

    public Bitcoin getQtdBit() {
        return qtdBit;
    }

    public void setQtdBit(Bitcoin qtdBit) {
        this.qtdBit = qtdBit;
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

    public Carteira() {
    }

    public Carteira(Reais qtdReais, Bitcoin qtdBit, Ethereum qtdEt, Ripple qtdRipple) {
        this.qtdReais = qtdReais;
        this.qtdBit = qtdBit;
        this.qtdEt = qtdEt;
        this.qtdRipple = qtdRipple;
    }
    
    
}
