package com.example.mindcraft;

import junit.framework.TestCase;

public class QuestaoTest extends TestCase {
    Questao questao = new Questao("Capital do Brasil", new String[] {"brasili", "belo horizonte", "vitoria", "bahia"}, 0);
    public void getOpcoes(){
        System.out.print("Opcao 1: " + questao.getOpcoes()[0]);
    }


}