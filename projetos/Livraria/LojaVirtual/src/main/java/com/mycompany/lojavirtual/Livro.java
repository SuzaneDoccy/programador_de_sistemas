package com.mycompany.lojavirtual;

public class Livro {

    private String nomep;
    private double precoUnitario;

    public Livro(String nomep, double precoUnitario) {
        this.nomep = nomep;
        this.precoUnitario = precoUnitario;
    }

    public String getNomeP() {
        return nomep;
    }

    public void setNomeP(String nomep) {
        this.nomep = nomep;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUni(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String toString() {
        return "{Produto: " + this.getNomeP() + ", Preço Unitário: " + this.getPrecoUnitario() + "}";

    }
}
