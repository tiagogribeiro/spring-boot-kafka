package br.com.trainning.integracao.model;

public class Cliente {

    private String nome;
    private String cnpj;

    public Cliente(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
}
