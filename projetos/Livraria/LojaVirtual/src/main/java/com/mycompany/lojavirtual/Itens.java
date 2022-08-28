package com.mycompany.lojavirtual;

public class Itens {

    private Livro livro;
    private double quantidade;

    public Itens(Livro livro, double quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;

    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double calculePrecoTotal() {
        return this.livro.getPrecoUnitario() * this.quantidade;
    }

    public String toString() {
        return "Itens{ Livro =" + livro.toString() + ", quantidade =" + quantidade + '}';
    }

}
