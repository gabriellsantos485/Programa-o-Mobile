package com.calculadora;

import androidx.annotation.NonNull;

public class Conversor {

    int base;

    public Conversor(int base)
    {
        this.base = base;
    }
    @NonNull
    private String calcular(int num) {
        if (num < base) return Integer.toString(num);
        return calcular(num / base) + (num % base);
    }

    @NonNull
    private String calcularEmHexa(int num){
        try{
            if(num<16 && num > 0) return (validarNumero(num));
            else if(num==16) return "1";
            else if (num <0) return "Numero deve ser maior que 0";
            int cos = num%16, divisao=num/16;
            String resto=validarNumero(num%16);
        return calcularEmHexa(divisao) + resto;
        }
        catch (Exception e){
            return "Digite um numero válido";
        }
    }

    // Converte um número binário (String) para decimal
    private int binarioParaDecimal(String num) {
        return binarioParaDecimal(num, 0);  // Chama o método auxiliar com o índice inicial 0
    }

    private int binarioParaDecimal(String num, int index) {
        if (index == num.length()) {
            return 0; // Caso base: quando chegamos ao final da string, retornamos 0
        }

        int bit = num.charAt(index) - '0'; // Converte o caractere para inteiro (0 ou 1)
        return (bit << (num.length() - 1 - index)) + binarioParaDecimal(num, index + 1);
    }

    @NonNull
    private String validarNumero(int num) {
        /**
         * Esse método é responsável por traformar o determinado restante ou cosciente que esteja entre 10 e 15 em Letras
         * @param num do tipo inteiro
         * */
        if (num == 10) return "A";
        else if (num == 11) return "B";
        else if (num == 12) return "C";
        else if (num == 13) return "D";
        else if (num == 14) return "E";
        else if (num == 15) return "F";
        else return Integer.toString(num);

    }

    public String getHexa(int num){ return calcularEmHexa(num);}

    public String getCalcularDecimal(int num){return calcular(num);}

    public int getCalcularBiParaDecimal(String num, int index){return binarioParaDecimal(num, index);}
}
