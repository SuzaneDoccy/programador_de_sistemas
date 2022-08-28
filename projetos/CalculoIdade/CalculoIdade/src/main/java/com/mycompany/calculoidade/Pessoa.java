/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculoidade;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Allan
 */
public class Pessoa {

    private String nome;

    private Date dataNascimento;

    private double altura;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return this.altura;
    }

    public int getIdate() throws Exception {
        GregorianCalendar dataHoje = new GregorianCalendar();
        GregorianCalendar dataNascimento = new GregorianCalendar();
        int anoAtual, anoNascimento, mesAtual, mesNascimento, diaAtual, diaNascimento;
        int idade;

        if (this.getDataNascimento() == null) {
            throw new Exception("Data de Nascimento não informada.");
        }

        dataNascimento.setTime(this.getDataNascimento());
        anoAtual = dataHoje.get(Calendar.YEAR);
        anoNascimento = dataNascimento.get(Calendar.YEAR);
        mesAtual = dataHoje.get(Calendar.MONTH);
        mesNascimento = dataNascimento.get(Calendar.MONTH);
        diaAtual = dataHoje.get(Calendar.DAY_OF_MONTH);
        diaNascimento = dataNascimento.get(Calendar.DAY_OF_MONTH);

        idade = anoAtual - anoNascimento - 1;

        if (mesAtual > mesNascimento) {
            idade++;
        } else {
            if (mesAtual == mesNascimento) {
                if (diaAtual >= diaNascimento) {
                    idade++;
                }
            }
        }

        return idade;
    }

    @Override
    public String toString() {
        return "{Pessoa: Nome = " + this.getNome() + ", Data de Nascimento = " + this.getDataNascimento() + ", Altura = " + this.getAltura() + "}";
    }

}
