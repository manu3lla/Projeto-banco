/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Manuella
 */
public class Moedas {
   private double valor;
   private String nomemoeda;
   private ArrayList<Moedas> novasMoedas;

    public ArrayList<Moedas> getNovasMoedas() {
        return novasMoedas;
    }

    public void setNovasMoedas(ArrayList<Moedas> novasMoedas) {
        this.novasMoedas = novasMoedas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomemoeda() {
        return nomemoeda;
    }

    public void setNomemoeda(String nomemoeda) {
        this.nomemoeda = nomemoeda;
    }

    @Override
    public String toString() {
        return "Moedas{" + "valor=" + valor + ", nomemoeda=" + nomemoeda + '}';
    }

    public Moedas(double valor, String nomemoeda) {
        this.valor = valor;
        this.nomemoeda = nomemoeda;
    }

    public Moedas() {
    }
   
   
   
}
