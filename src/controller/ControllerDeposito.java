/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Carteira;
import model.Reais;
import view.DepositoReal;
import view.Login;

/**
 *
 * @author Manuella
 */
public class ControllerDeposito {
     private Reais reais;
     private DepositoReal view;
     
     
    public ControllerDeposito(DepositoReal view) {
        this.reais = new Reais(0, 0, 0, "Reais");
        this.view = view;
        
        
    }

    public ControllerDeposito(Reais reais) {
        this.reais = reais;
    }
    
    
    public void depositarReais(double valor) {
        reais.DepositoReal(valor);
    }
}
