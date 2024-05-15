/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Carteira;
import model.Investidor;
import model.Reais;
import view.CompraEthereum;
import view.Extrato;

/**
 *
 * @author Manuella
 */
public class ControllerExtrato {
    private Reais reais;
     private Investidor investidor;
     private Extrato view;
     private Carteira c1;
     
     
    public ControllerExtrato(Extrato view, Investidor investidor) {
        this.reais = new Reais(0, 0, 0, 0, "Reais");
        this.view = view;
        this.investidor = investidor;
        this.c1 =c1;
        
    }
    
}
