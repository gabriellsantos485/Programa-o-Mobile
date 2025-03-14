package com.calculadora;

import junit.framework.TestCase;
public class ConversorTest extends TestCase {
    Conversor conversor = new Conversor(16);

    public void testCalcular()
    {
        System.out.print(conversor.getCalcularDecimal(100));
    }

    public void testGetHexa(){System.out.print("O numero eh: " + conversor.getHexa(20) + "-------");}

    public void testBinarioParaDecimal(){System.out.print("O numero em decima eh: " + conversor.getCalcularBiParaDecimal("1010", 0));}

}