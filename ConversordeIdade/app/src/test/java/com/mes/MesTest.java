package com.mes;

import junit.framework.TestCase;

public class MesTest extends TestCase {
    Mes JANEIRO = new Mes("Janeiro", 31, 01);

    public void testGetId(){
        System.out.print("Resultado:  "  + JANEIRO.getIdMes() + "   ");
    }
}