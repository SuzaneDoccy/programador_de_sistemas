/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.matrizesescalar;

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
        int[][] matriz = new int[3][3];
        int valorEscalar;
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Favor preencher a posição [" + i + "][" + j + "] da matriz.");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Favor informar o número escalar: ");
        valorEscalar = scanner.nextInt();
        
        System.out.println("Matriz Inicial: ");
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }   
            System.out.println("\n");
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = matriz[i][j] * valorEscalar;
            }
        }
        
        System.out.println("Matriz Final: ");
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }   
            System.out.println("\n");
        }
    }
    
}
