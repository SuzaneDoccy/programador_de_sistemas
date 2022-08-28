package com.mycompany.lojavirtual;

import java.util.ArrayList;

public class Caixa {

    private ArrayList<Itens> nota_fiscal, vendas;

    public Caixa() {

        this.vendas = new ArrayList();

    }

    public boolean isItensEmpty() {
        return this.vendas.isEmpty();
    }

    public boolean isVendaEmpty() {
        return this.vendas.isEmpty();
    }

    public void armazenaProduto(Livro livro, int quantidade) {
        Itens itens = new Itens(livro, quantidade);
        this.vendas.add(itens);
        System.out.println("Livro adicionado ao Caixa com sucesso.");
    }

    public void removeProduto(String nomep) {
        boolean achou = false;

        if (this.isItensEmpty()) {
            System.out.println("O caixa está vazio.");
            return;
        }
        for (int i = 0; i < this.vendas.size(); i++) {

            Itens itens = this.vendas.get(i);

            if (itens.getLivro().getNomeP().equals(nomep)) {
                this.vendas.remove(i);
                achou = true;
                break;
            }
        }
        if (achou == false) {
            System.out.println(nomep + " não foi encontrado no caixa.");
            return;
        }
        System.out.println(nomep + " foi removido do caixa.");
    }

    public void imprimeCaixa() {
        if (this.isItensEmpty()) {
            System.out.println("O caixa está vazio.");
            return;
        }
        int posicao;
        Itens itens;

        double valorTotal = 0;
        for (int i = 0; i < this.vendas.size(); i++) {
            posicao = i + 1;
            itens = this.vendas.get(i);
            valorTotal = valorTotal + itens.calculePrecoTotal();

            System.out.println("Na posição " + posicao + " está " + vendas.toString() + " Preço do Item:" + itens.calculePrecoTotal());
        }

        System.out.println("Valor total da compra: R$ " + valorTotal);
    }

}