package com.conversor.calculadora;

import junit.framework.TestCase;

public class ConversorTest extends TestCase {
    Conversor calculadora = new Conversor("06/02/2025", "06/03/2025");

    public void testCalcularIdadeEmDia()
    {
        System.out.println("");
        System.out.println("Dias Pecorridos: " + calculadora.calcularIdadeEmDia());
        System.out.println("");
    }

    public void testCalcularIdadeEmMeses()
    {
        System.out.print("Resultado: " + calculadora.calcularIdadeEmMeses() + "------");
    }

    public void testCalcularIdadeEmHora()
    {
        System.out.print("Resultado: " + calculadora.calcularIdadeEmHora());
    }
}