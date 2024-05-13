/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manuella
 */
public class Investidor extends Usuario {
    private Carteira c1;
    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        c1 = new Carteira();
    }
    
    public Investidor(){
        super();
    }

    public Carteira getC1() {
        return c1;
    }

    public void setC1(Carteira c1) {
        this.c1 = c1;
    }
    
    public void FazerCarteira() {
        c1 = new Carteira();
        System.out.println("Nova carteira criada para o investidor.");
    }
}
