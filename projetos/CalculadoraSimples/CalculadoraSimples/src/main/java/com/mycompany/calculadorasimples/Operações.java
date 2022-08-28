
package com.mycompany.calculadorasimples;
import java.util.Scanner;
public class Operações {
    public static void main(String[] args) {
       Scanner scanner = new Scanner (System.in);
   
       int c;
       float a, b, resultado;
       
       System.out.println("Escolha um número para a operação:");
       a = scanner.nextInt();
              
       System.out.println("Escolha outro número para a operação:");
       b = scanner.nextInt();
              
       System.out.println("Agora escolha uma das operações abaixo:");
        
       System.out.println("1 para soma, 2 para subtração, 3 para multiplicação ou 4 para a divisão");
       c = scanner.nextInt();
        
            switch (c) { 
                case 1:
                resultado = a+b;
                System.out.println("Resultado igual a: "+ resultado);
                break;
                
                case 2:
                resultado = a-b;
                System.out.println("Resultado igual a: "+ resultado);
                break;
                    
                case 3:
                resultado = a*b;
                System.out.println("Resultado igual a: "+ resultado);
                break;
                
                case 4:
                resultado = a/b;
                System.out.println("Resultado igual a: "+ resultado);
                break;  
                
                default: 
                    System.out.print("Operação inválida. Escolha uma para efetuar o calculo");
                        }

    } 
}  
