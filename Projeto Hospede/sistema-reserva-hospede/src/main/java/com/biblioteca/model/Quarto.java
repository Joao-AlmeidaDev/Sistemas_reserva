package com.biblioteca.model;

public class Quarto {
    private int idQuarto;
    private int numQuarto;
    private String tipo;
    private double preco;
    private int idTipo;

    // Construtor completo (para uso interno, como em métodos que obtêm dados do banco)
    public Quarto(int idQuarto, int numQuarto, String tipo, double preco, int idTipo) {
        this.idQuarto = idQuarto;
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.preco = preco;
        this.idTipo = idTipo;
    }

    // Construtor sem idQuarto (para criação de novos quartos)
    public Quarto(int numQuarto, String tipo, double preco, int idTipo) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.preco = preco;
        this.idTipo = idTipo;
    }

    // Getters e setters
    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}
