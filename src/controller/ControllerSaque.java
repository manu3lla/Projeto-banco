/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Carteira;
import model.Reais;
import view.DepositoReal;
import view.SaqueReal;

/**
 *
 * @author Manuella
 */
public class ControllerSaque {
    private Reais reais;
     private SaqueReal view;

    public ControllerSaque(SaqueReal view) {
        this.reais = new Reais(0, 0, 0, "Reais");
        this.view = view;
        
        
    }

    public ControllerSaque(Reais reais) {
        this.reais = reais;
    }
    
    
    public void sacarReais(double valor) {
        reais.SaqueReal(valor);
    }
}
