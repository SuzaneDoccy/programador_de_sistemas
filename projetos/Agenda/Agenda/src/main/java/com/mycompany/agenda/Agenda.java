package com.mycompany.agenda;
import java.util.ArrayList;
public class Agenda {
    
    private ArrayList<Pessoa> pessoas;
    
    public Agenda()
    {
        this.pessoas = new ArrayList();
    }
    
    public boolean isPessoasEmpty()
    {
        return this.pessoas.isEmpty();
    }
    
    public void armazenaPessoa(String nome, int idade, double altura)
    {
        if (this.pessoas.size() == 10) {
            System.out.println("Não há espaço na agenda. Favor excluir uma pessoa.");
            return;
        }
        
        Pessoa pessoa = new Pessoa(nome, idade, altura);
        this.pessoas.add(pessoa);
        System.out.println("Pessoa adicionada na agenda.");
        
    }
    
    public void removePessoa(String nome)
    {
        boolean achou = false;
        
        if (this.isPessoasEmpty()) {
            System.out.println("Sua agenda está vazia.");
            return;
        }
        
        for (int i = 0; i  < this.pessoas.size(); i++) {
            
            Pessoa pessoa = this.pessoas.get(i);
            
            if (pessoa.getNome().equals(nome))  {
                this.pessoas.remove(i);
                achou = true;
                break;
            }
            
        }
        
        if (achou == false) {
            System.out.println(nome + " não foi encontrado na agenda.");
            return;
        }
        
        System.out.println(nome + " foi removido da agenda.");
    }
    
    public void imprimePessoa(int index) throws IndexOutOfBoundsException
    {
        if (index <= 0) {
            System.out.println("Posição informada inválida. Que a nossa lista começa da posição 1.");
            return;
        }
        
        if (index > 10) {
            System.out.println("Posiçao informada inválida. Nossa lista só tem 10 registros.");
            return;
        }
        
        if (this.pessoas.isEmpty()) {
            System.out.println("Sua agenda está vazia.");
            return;
        }
        
        int posicao = index;
        index--;
        System.out.println(posicao + ", Informação: " + this.pessoas.get(index).toString());        
    }
    
    public int buscaPosicaoPessoa(String nome)
    {
        if (this.isPessoasEmpty()) {
            return -1;
        }
        
        int posicaoEncontrada = 0;
        
        for (int i = 0; i < this.pessoas.size(); i++) {
            
            Pessoa pessoa = this.pessoas.get(i);
            
            if (pessoa.getNome().equals(nome)) {
                i++;
                posicaoEncontrada = i;
                break;
            }
        }
        
        return posicaoEncontrada;
    }
    
    public void imprimeAgenda()
    {
        if (this.isPessoasEmpty()) {
            System.out.println("Agenda está vazia.");
            return;
        }
        
        int posicao;
        Pessoa pessoa;
        
        for (int i = 0; i < this.pessoas.size(); i++) {
            posicao = i + 1;
            pessoa = this.pessoas.get(i);
            
            System.out.println("Na posição " + posicao + " está " + pessoa.toString());
        }
    }
    
    
}
