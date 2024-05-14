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
   private double valor, taxavenda, taxacompra, cotacao;
   private String nomemoeda;

    public double getTaxavenda() {
        return taxavenda;
    }

    public void setTaxavenda(double taxavenda) {
        this.taxavenda = taxavenda;
    }

    public double getTaxacompra() {
        return taxacompra;
    }

    public void setTaxacompra(double taxacompra) {
        this.taxacompra = taxacompra;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
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
        return "Moedas{" + "valor=" + valor + ", taxavenda=" + taxavenda + ", taxacompra=" + taxacompra + ", cotacao=" + cotacao + ", nomemoeda=" + nomemoeda + '}';
    }

    public Moedas(double valor, double taxavenda, double taxacompra, double cotacao, String nomemoeda) {
        this.valor = valor;
        this.taxavenda = taxavenda;
        this.taxacompra = taxacompra;
        this.cotacao = cotacao;
        this.nomemoeda = nomemoeda;
    }

    

    public Moedas() {
    }
   
   
   
}
