/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.superlistas.model;

/**
 *
 * @author MatheusdeOliveiraCam
 */
public class Produto {
    
    private int id;
    private String nome;
    private int qnt;
    private float price;

    public Produto (int id, String nome, int qnt, float price) {
        this.id = id;
        this.nome = nome;
        this.qnt = qnt;
        this.price = price;
    }
    
    public Produto () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    
}
