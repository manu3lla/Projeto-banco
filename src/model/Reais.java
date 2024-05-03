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
    private Carteira carteira;
    public Reais(double taxacompra, double taxavenda, double valor, String nomemoeda) {
        super(0, 0, 0, "Reais");
    }
    
    
    
    public void SaqueReal(double valor){
        if (carteira == null) {
            carteira = new Carteira(0, 0, 0, 0);
        } else {
            double saldoReal = carteira.getValorreal();
            double valorAtual = saldoReal - valor;
            carteira.setValorreal(saldoReal);
            System.out.println("Saque realizado!");
            System.out.println("Valor atual na carteira: " + " " + valorAtual);
        }
        
    }
    
}
