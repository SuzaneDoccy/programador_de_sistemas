/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculoidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        
        Pessoa pessoa = new Pessoa(); //objeto
        Scanner scanner = new Scanner(System.in);//l
        String dataNascimentoDigitada;
        
        System.out.println("Digite o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());
        
        System.out.println("Informe a data de nascimento: ");
        dataNascimentoDigitada = scanner.nextLine();
        
        System.out.println("Informa sua altura: ");
        pessoa.setAltura(scanner.nextDouble());
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        
        try {
            
            Date dataNascimento = simpleDateFormat.parse(dataNascimentoDigitada);
            
            pessoa.setDataNascimento(dataNascimento);
            
            System.out.println(pessoa.toString());
            System.out.println("Qual a idade da pessoa: " + pessoa.getIdate());
            
        } catch (ParseException e) {
            System.out.println("A data está inválida.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
