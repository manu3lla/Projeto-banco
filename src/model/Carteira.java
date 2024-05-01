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
    private String valorbitcoin, valorripple, valorethereum, valorreal;

    public String getValorbitcoin() {
        return valorbitcoin;
    }

    public void setValorbitcoin(String valorbitcoin) {
        this.valorbitcoin = valorbitcoin;
    }

    public String getValorripple() {
        return valorripple;
    }

    public void setValorripple(String valorripple) {
        this.valorripple = valorripple;
    }

    public String getValorethereum() {
        return valorethereum;
    }

    public void setValorethereum(String valorethereum) {
        this.valorethereum = valorethereum;
    }

    public String getValorreal() {
        return valorreal;
    }

    public void setValorreal(String valorreal) {
        this.valorreal = valorreal;
    }

    @Override
    public String toString() {
        return "Carteira{" + "valorbitcoin=" + valorbitcoin + ", valorripple=" + valorripple + ", valorethereum=" + valorethereum + ", valorreal=" + valorreal + '}';
    }

    public Carteira() {
    }

    public Carteira(String valorbitcoin, String valorripple, String valorethereum, String valorreal) {
        this.valorbitcoin = valorbitcoin;
        this.valorripple = valorripple;
        this.valorethereum = valorethereum;
        this.valorreal = valorreal;
    }
    
    
    
}
