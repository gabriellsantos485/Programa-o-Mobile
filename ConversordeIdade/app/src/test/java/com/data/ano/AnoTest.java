package com.data.ano;

import junit.framework.TestCase;
public class AnoTest extends TestCase {
    Ano ano = new Ano();

    public void testCalcularDiferencaDeDiaDoMes(){
        System.out.print("Resultado: " + ano.calcularDiferencaDeDiaDoMes(06, 4) + "    ");
    }

    public void testSomarDiasDosMeses(){
        System.out.print("Resultado: " + ano.somarDiasDosMeses(04, 9) + "    ");
    }

}