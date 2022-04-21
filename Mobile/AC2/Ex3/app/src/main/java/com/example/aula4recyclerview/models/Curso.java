package com.example.aula4recyclerview.models;

import java.util.ArrayList;

public class Curso {
    private String nome;
    private String nivel;
    private String preco;
    private String dias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Curso(String nome, String nivel, String preco, String dias) {
        this.nome = nome;
        this.nivel = nivel;
        this.preco = preco;
        this.dias = dias;
    }
}
