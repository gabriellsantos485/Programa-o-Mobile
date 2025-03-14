package com.data.ano;
import com.mes.Mes;

public class Ano{
    /*
     * Classe responsável pelo ano
     * Possui metodos para retornar quantidade de dias e para alterar a quantidade de dias em fevereiro de acordo com ano bissexto
     * */

    public Mes JANEIRO = new Mes("Janeiro", 31, 1 );
    public Mes FEVEREIRO = new Mes("Fevereiro", 28, 2 );
    public Mes MARCO = new Mes("Marco", 31, 3);
    public Mes ABRIL = new Mes("Abril", 30, 4);
    public Mes MAIO = new Mes("Maio", 31, 5);
    public Mes JUNHO = new Mes("Junho", 30, 6);
    public Mes JULHO = new Mes("Julho", 31, 7);
    public Mes AGOSTO = new Mes("Agosto", 31, 8 );
    public Mes SETEMBRO = new Mes("Setembro", 30, 9);
    public Mes OUTUBRO = new Mes("Outubro", 31, 10);
    public Mes NOVEMBRO = new Mes("Novembro", 30, 11);
    public Mes DEZEMBRO = new Mes("Dezembro", 31, 12);



    public int qtdeDiasFer()
    {
        return FEVEREIRO.getQtdeDia();
    }

    public int qtdeDeDiaNoAno()
    {
        int res;
        res = JANEIRO.getQtdeDia() + FEVEREIRO.getQtdeDia() + MARCO.getQtdeDia() +
                ABRIL.getQtdeDia()+ MAIO.getQtdeDia() + JUNHO.getQtdeDia() +
                JULHO.getQtdeDia() + AGOSTO.getQtdeDia() + SETEMBRO.getQtdeDia()
                + OUTUBRO.getQtdeDia() + NOVEMBRO.getQtdeDia() + DEZEMBRO.getQtdeDia();
        return res;
    }

    public int calcularDiferencaDeDiaDoMes(int dia, int idMes)
    {
        Mes[] vetor = { JANEIRO, FEVEREIRO, MARCO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO };

        for (int i = 0; i < 12; i++)
        {

            if (vetor[i].getIdMes() == idMes)
            {
                return vetor[i].getQtdeDia() - dia;
            }
        }
        return -1;
    }

    public int somarDiasDosMeses(int partida, int rodada)
    {
        Mes[] vetor = { JANEIRO, FEVEREIRO, MARCO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO };
        int somaDias = 0;
        int i = 0;

        while (i < rodada)
        {
            int indice = (partida + i) % 12;


            somaDias += vetor[indice].getQtdeDia();

            i++;
        }

        return somaDias;
    }



}