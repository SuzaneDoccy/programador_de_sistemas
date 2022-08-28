/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculosalariominimo;

/**
 *
 * @author Allan
 */
public class SalarioUsuario {
    
    // Atributos
    private String nome;
    
    private Double salario;
    
    private Double salarioMinimo = 1100.00;    
    
    // Métodos
    public String getNome()
    {
        return this.nome;
    }
    
    public Double getSalario()
    {
        return this.salario;
    }
    
    public Double getSalarioMinimo()
    {
        return this.salarioMinimo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSalario(Double salario){
        this.salario = salario;
    }
}
