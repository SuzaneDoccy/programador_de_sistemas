/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeiraAula;

import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class HelloWorld {
    
    // Flamengo não será campeão.
    
    /* Os boxeadores serão os campeões
    das olimpiadas
    */

    /**
     * Inicializa o nosso projeto.
     * @param args the command line arguments
     * @return void
     * @param int idade
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y, i;
        int divisor;
        int contador = 0;
        
        System.out.println("Digite o primeiro número do intervalo");
        x = scanner.nextInt();
        
        System.out.println("Digite o segundo número do intervalo");
        y = scanner.nextInt();
        
        System.out.println("Digite o divisor");
        divisor = scanner.nextInt();
        
        if (x >= y) {
            System.out.println("Erro. X menor ou igual a Y");
            return;
        }
        
        for (i = x; i <= y; i++) {
            if (i % divisor == 0) {
                contador++;
            }
        }
        
        System.out.println("Existem " + contador + " números divisiveis pelo " + divisor);
        
    }
    
}
