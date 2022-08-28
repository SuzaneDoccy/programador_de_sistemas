/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculosalariominimo;

import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Long quantidadeSalarioMinimos;
        
        SalarioUsuario salarioUsuario = new SalarioUsuario();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Favor digitar o seu nome: ");
        salarioUsuario.setNome(scanner.nextLine());
        
        System.out.println("Favor digitar o seu salário: ");
        salarioUsuario.setSalario(scanner.nextDouble());
        
        quantidadeSalarioMinimos = Math.round(salarioUsuario.getSalario() / salarioUsuario.getSalarioMinimo());
        
        System.out.println(salarioUsuario.getNome() + " recebe " + quantidadeSalarioMinimos + "SM");
    }
    
}
