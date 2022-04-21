package com.example.aula3.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
    public Produto(int id_produto, String prod_nome, int prod_qtd, int id_catetogia) {
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.prod_qtd = prod_qtd;
        this.id_catetogia = id_catetogia;
    } 

    private int id_produto;
    private String prod_nome;
    private int prod_qtd;
    private int id_catetogia;
    @ManyToOne
    @JoinColumn(name = "id_catetogia")
    private Perfil perfil;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public int getProd_qtd() {
        return prod_qtd;
    }

    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
    }

    public int getId_catetogia() {
        return id_catetogia;
    }

    public void setId_catetogia(int id_catetogia) {
        this.id_catetogia = id_catetogia;
    }
}
