/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vetorposicao;

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
        int vetor[] = new int[10];
        int x;
        int quantidadeMaior = 0, quantidadeMenor = 0, quantidadeIgual = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++)  {
            System.out.println("Favor informar " + (i+1) + "º valor pro vetor: ");
            vetor[i] = scanner.nextInt();
        }
        
        System.out.println("Favor informar o valor de x: ");
        x = scanner.nextInt();
        
        // vetor.length = retorna a quantidade de posições do vetor
        
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < x) {
                quantidadeMenor++;
                continue;
            } else {
                if (vetor[i] == x) {
                    quantidadeIgual++;
                    continue;
                }
            }         
            
            quantidadeMaior++;
        }
        
        System.out.println("Quantidade de números menores que " + x + " é: " + quantidadeMenor);
        System.out.println("Quantidade de números iguais a " + x + " é: " + quantidadeIgual);
        System.out.println("Quantidade de números maiores que " + x + " é: " + quantidadeMaior);
    }
    
}
