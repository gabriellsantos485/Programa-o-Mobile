package com.sistema.controls.login;

public class Autenticador {
    private String username;
    private String password;

    public Autenticador(){
        this.password = "123456";
        this.username = "Admin";
    }

    public String setPassword(String password) {
        return this.password = password;
    }
    public String setUsername(String username){
        return this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean validarUsuario(Usuario usuario){
        if (usuario.getUsername() == this.username && usuario.getPassword() == this.password){
            return true;
        }
        return false;
    }



}
