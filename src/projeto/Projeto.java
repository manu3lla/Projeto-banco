/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto;

import view.Login;
//Programa em Java de um banco de criptomoedas, onde podemos fazer depósitos, saques,
//comprar e vender bitcoins, ethereum, ripples, atualizar cotação e aplicar tanto essas quanto
//taxas nas compras e vendas para simular um banco mais realista, podemos também ver o saldo
//e extrato. Além disso, para entrar em cada opção há uma verificação de cpf e senha para ficar
//mais seguro. O programa funciona a partir dos modelos usuários, investidor, carteira, interface
//de tarifação e moedas especificas, cada uma herda ou implementa informações de outras nos modelos
//(alguns implementam, outros herdam, depende de sua posição na hierarquia), assim como espeficicado
//pela professora, podendo ser visto ao longo do programa.
//Manuella Filipe Peres R.A 24.123.036-6


/**
 *
 * @author unifmperes
 */
public class Projeto {
    public static void main(String[] args) {
        //onde o programa vai abrir automaticamente, ou seja, abre automaticamente no login
       Login l = new Login();
       l.setVisible(true);
    }
    
}
