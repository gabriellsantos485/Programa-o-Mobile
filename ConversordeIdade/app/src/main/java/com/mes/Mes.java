package com.mes;

public class Mes{
    private String nomeMes;
    private int idMes;
    private int qtdeDeDia;

    public Mes(String nomeMes, int qtdeDeDia, int idMes){
        this.nomeMes = nomeMes;
        this.qtdeDeDia = qtdeDeDia;
        this.idMes = idMes;

    }

    public int getQtdeDia()
    {
        return qtdeDeDia;
    }

    public String getNomeMes()
    {
        return nomeMes;
    }

    public int setQtdeDia()
    {
        return qtdeDeDia = qtdeDeDia + 1;
    }

    public int getIdMes()
    {
        return idMes;
    }

}
