package com.conversor.calculadora;

import junit.framework.TestCase;

public class ConversorTest extends TestCase {
    Conversor calculadora = new Conversor("06/04/2003", "25/02/2025");

    public void testCalcularIdadeEmDia()
    {
        System.out.print("Resultado: " + calculadora.calcularIdadeEmDia());
    }

    public void testCalcularIdadeEmMeses()
    {
        System.out.print("Resultado: " + calculadora.calcularIdadeEmMeses());
    }

    public void testCalcularIdadeEmHora()
    {
        System.out.print("Resultado: " + calculadora.calcularIdadeEmHora());
    }
}