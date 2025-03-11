package com.biblioteca.model;

public class Funcionario {
    private int idFuncionario;
    private String nomeCompleto;
    private String cargo;
    private String telefone;

    // Construtor completo (para uso interno, como em métodos que obtêm dados do banco)
    public Funcionario(int idFuncionario, String nomeCompleto, String cargo, String telefone) {
        this.idFuncionario = idFuncionario;
        this.nomeCompleto = nomeCompleto;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    // Construtor sem idFuncionario (para criação de novos funcionários)
    public Funcionario(String nomeCompleto, String cargo, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    // Getters e setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
