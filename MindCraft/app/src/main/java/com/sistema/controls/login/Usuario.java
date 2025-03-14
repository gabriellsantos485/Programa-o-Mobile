package com.sistema.controls.login;

public class Usuario {
    private String nomeDeUsuario;
    private String senha;

    public Usuario(String nome, String senha){
        this.nomeDeUsuario = nome;
        this.senha = senha;
    }

    public String setPassword(String senha) {
        return this.senha = senha;
    }
    public String setUsername(String nome){
        return this.nomeDeUsuario = nome;
    }

    public String getUsername(){
        return this.nomeDeUsuario;
    }

    public String getPassword(){
        return this.senha;
    }
}
