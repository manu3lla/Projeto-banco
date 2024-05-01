/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manuella
 */
public class Moedas {
   private double taxacompra, taxavenda, valor;
   private String nomemoeda;

    public double getTaxacompra() {
        return taxacompra;
    }

    public void setTaxacompra(double taxacompra) {
        this.taxacompra = taxacompra;
    }

    public double getTaxavenda() {
        return taxavenda;
    }

    public void setTaxavenda(double taxavenda) {
        this.taxavenda = taxavenda;
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
        return "Moedas{" + "taxacompra=" + taxacompra + ", taxavenda=" + taxavenda + ", valor=" + valor + ", nomemoeda=" + nomemoeda + '}';
    }

    public Moedas(double taxacompra, double taxavenda, double valor, String nomemoeda) {
        this.taxacompra = taxacompra;
        this.taxavenda = taxavenda;
        this.valor = valor;
        this.nomemoeda = nomemoeda;
    }

    public Moedas() {
    }
   
   
   
}
