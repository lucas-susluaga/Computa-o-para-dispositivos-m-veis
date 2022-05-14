package com.example.appcartao;

public class Bandeira {

    private int id;
    private String nome;

    public Bandeira() {
    }

    public Bandeira(String nome) {
        this.nome = nome;
    }

    public Bandeira(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

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
