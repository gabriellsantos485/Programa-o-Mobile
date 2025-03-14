package com.example.lotemax;

import java.util.Random;

public class MegaCena extends Loteria {

    public MegaCena(){
        super(6, "Megacena");

    }

    public int[] gerarNumero(){
        Random gerador = new Random();
        int resultado = 0;
        int[] arrayNumero= new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.println(gerador.nextInt(60));
            arrayNumero[i] = gerador.nextInt(60);
        }
        return arrayNumero;
    }
}
