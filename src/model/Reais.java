/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifmperes
 */
public class Reais extends Moedas {

    public Reais(double taxacompra, double taxavenda, double valor, String nomemoeda) {
        super(0, 0, 0, "Reais");
    }
    
    public void DepositoReal(double valor, Carteira carteira){
        if (carteira == null) {
            carteira = new Carteira("0", "0", "0", String.valueOf(valor));
        } else {
            double saldoReal = Double.parseDouble(carteira.getValorreal());
            saldoReal += valor;
            carteira.setValorreal(String.valueOf(saldoReal));
        }
        System.out.println("Depósito realizado!");
    }
    
}
