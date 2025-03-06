package com.example.mindcraft;

public class Questao {
    /**
     * Classe reponsável pelas perguntas*/
    private  String pergunta;
    private String[] opcoes;
    private int indexRespostaCorreta;

    Questao(String pergunta, String[] opcoes, int indexRespostaCorreta){
        /**
         * @param pergunta: responsável pelas perguntas
         * @param opcoes é um vetor responsavel pelas opções que devem ser mostradas ao usuario
         * @param indexRespostaCorreta é um index do veto de qual das resposta está correta*/

        this.pergunta=pergunta;
        this.opcoes = opcoes;
        this.indexRespostaCorreta=indexRespostaCorreta;
    }

    public String getTextoPergunta(){return pergunta;}
        /*
        * Methodo que retorna pergunta*/
    public String[] getOpcoes(){return opcoes;} // methodo que retorna o vetor de opcoes

    public int getIndexRespostaCorreta(){return indexRespostaCorreta;} // methodo que que retornao index da resposta correta

    private boolean checarResposta(int indexResposta){boolean valor = indexResposta == indexRespostaCorreta ? true : false; return valor;}
}
