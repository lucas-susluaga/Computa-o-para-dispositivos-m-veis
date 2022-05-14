package com.example.appcartao;

public class Carteira {

    public int id;
    public String nome, limite, banco;
    public Bandeira bandeira;

    public Carteira() {
    }

    @Override
    public String toString() {
        return nome +'\n'+ limite +'\n'+ banco;
    }

    public Carteira(String nome, String limite, String banco, Bandeira bandeira) {
        this.nome = nome;
        this.limite = limite;
        this.banco = banco;
        this.bandeira = bandeira;

    }

    public Carteira(int id, String nome, String limite, String banco, Bandeira bandeira) {
        this.id = id;
        this.nome = nome;
        this.limite = limite;
        this.bandeira = bandeira;
        this.banco = banco;
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

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
}
