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
    private double valorbitcoin, valorripple, valorethereum, valorreal;

    public double getValorbitcoin() {
        return valorbitcoin;
    }

    public void setValorbitcoin(double valorbitcoin) {
        this.valorbitcoin = valorbitcoin;
    }

    public double getValorripple() {
        return valorripple;
    }

    public void setValorripple(double valorripple) {
        this.valorripple = valorripple;
    }

    public double getValorethereum() {
        return valorethereum;
    }

    public void setValorethereum(double valorethereum) {
        this.valorethereum = valorethereum;
    }

    public double getValorreal() {
        return valorreal;
    }

    public void setValorreal(double valorreal) {
        this.valorreal = valorreal;
    }

    @Override
    public String toString() {
        return "Carteira{" + "valorbitcoin=" + valorbitcoin + ", valorripple=" + valorripple + ", valorethereum=" + valorethereum + ", valorreal=" + valorreal + '}';
    }

    

    public Carteira() {
    }

    public Carteira(double valorbitcoin, double valorripple, double valorethereum, double valorreal) {
        this.valorbitcoin = valorbitcoin;
        this.valorripple = valorripple;
        this.valorethereum = valorethereum;
        this.valorreal = valorreal;
    }
    
    
    
}
