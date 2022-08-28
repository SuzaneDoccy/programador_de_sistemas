package com.mycompany.lojavirtual;

public class Cliente {

    private String nomeC;
    private int idade;
    private String telefone;
    private String email;

    public Cliente(String nomeC, int idade, String telefone, String email) {
        this.nomeC = nomeC;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNome(String nomeC) {
        this.nomeC = nomeC;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{Cliente: " + this.getNomeC() + ", idade: " + this.getIdade() + ", telefone: " + this.getTelefone() + ", e-mail:" + this.getEmail() + "}";

    }
}
