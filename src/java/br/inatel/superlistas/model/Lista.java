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
public class Lista {
    
    private int id;
    private String nome;

    public Lista(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Lista () {}

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
    
    
    
}
