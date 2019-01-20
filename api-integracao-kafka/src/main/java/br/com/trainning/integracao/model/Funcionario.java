package br.com.trainning.integracao.model;

public class Funcionario {

    private String nome;
    private String cpf;
    private String idade;

    private Funcionario(String nome, String cpf, String idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public static Funcionario create(String nome, String cpf, String idade) {
        return new Funcionario(nome, cpf, idade);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }
}
