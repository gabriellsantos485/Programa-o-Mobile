package com.conversor.calculadora;

import com.data.ano.Ano;

public class Conversor {

    String dataDeHoje, dataNascimento; //   22/02/2025   06/04/2003
    Ano ano = new Ano();

    public Conversor(String dataNascimento, String dataDeHoje){
        this.dataNascimento = dataNascimento;
        this.dataDeHoje = dataDeHoje;
    }

    public int[] separarElementos(String data) //   22/06/2003
    {
        int[] resultado = new int[3]; // Um array de 3 elementos para armazenar dia, mês e ano

        // Separando o dia, mês e ano
        String[] partes = data.split("/");

        resultado[0] = Integer.parseInt(partes[0]); // Dia
        resultado[1] = Integer.parseInt(partes[1]); // Mês
        resultado[2] = Integer.parseInt(partes[2]); // Ano

        return resultado;
    }

    public int calcularIdadeEmAno() // 06/04/2003  22/02/2025   21 10 16
    {
        int resultado, anoNascimento, mesNascimento, mesAtual, anoAtual;

        anoNascimento = separarElementos(dataNascimento)[2];
        anoAtual = separarElementos(dataDeHoje)[2];
        mesNascimento = separarElementos(dataNascimento)[1];
        mesAtual = separarElementos(dataDeHoje)[1];

        if (mesAtual < mesNascimento)
            resultado = (anoAtual - anoNascimento) - 1;

        else if (mesAtual == mesNascimento)
        {
            int diaAtual, diaNas;
            diaAtual = separarElementos(dataDeHoje)[0];
            diaNas = separarElementos(dataNascimento)[0];
            if (diaNas <= diaAtual)
                resultado = (anoAtual - anoNascimento) ;
            else
                resultado = (anoAtual - anoNascimento) - 1;
        }
        else
            resultado = anoAtual - anoNascimento;

        return resultado;

    }

    public int calcularIdadeEmMeses()
    {
        int resultado=0, mesAtual, mesNasc, anoAtual, anoNas;
        mesNasc = separarElementos(dataNascimento)[1];
        mesAtual = separarElementos(dataDeHoje)[1]; //2
        anoAtual =separarElementos(dataDeHoje)[2];
        anoNas = separarElementos(dataNascimento)[2];
        if (mesAtual > mesNasc)
            resultado = (calcularIdadeEmAno() * 12) + (12 - (mesAtual - mesNasc)) ;
        else if (mesAtual == mesNasc &&  anoNas != anoAtual){return 12;}
        else if (mesAtual == mesNasc && anoNas == anoAtual){return 0;}
        else
            resultado = (calcularIdadeEmAno() * 12) + (12 - (mesNasc - mesAtual)) ;

        return resultado;
    }

    public int calcularIdadeEmDia() {
        int mesAtual = separarElementos(dataDeHoje)[1], diaAtual = separarElementos(dataDeHoje)[0];
        int mesNas = separarElementos(dataNascimento)[1], diaNiver = separarElementos(dataNascimento)[0];
        int mesesVividosAnos, diasCertos, mesNiverDiaAtualSomadosDias, totalMeses, resultadoFinal;
        int anoNas = separarElementos(dataNascimento)[2];
        int anoAtual = separarElementos(dataDeHoje)[2];

        diasCertos = calcularIdadeEmAno() * 365;
        if (mesNasMaior() == 2)
        {
            mesesVividosAnos = 12 - (mesNas - mesAtual); // 12 - Mes do nascimento - mes atual -> meses vividos até o momento
            mesNiverDiaAtualSomadosDias = ano.calcularDiferencaDeDiaDoMes(diaNiver, mesNas) + diaAtual; // calcula os dias dos meses do aniversario e do dia atual vividos ate o momento e soma os dois
            totalMeses = ano.somarDiasDosMeses(mesNas, mesesVividosAnos - 1);
            resultadoFinal = totalMeses + diasCertos + mesNiverDiaAtualSomadosDias + calcularAnosBissestos(2024);
            return resultadoFinal;
        }
        else if (mesNasMaior() == 1 && diaAtual == diaNiver && anoAtual == anoNas){
            return 0;
        }
        else if (mesNasMaior() == 1 && diaAtual == diaNiver && anoNas == (anoAtual - 1)){
            return 365;
        }
        else if (mesNasMaior() ==1 && diaAtual == diaNiver && anoNas != (anoAtual -1)){
            int resultado = ((anoAtual - anoNas) * 365) + calcularAnosBissestos(2024);
            return resultado;
        }
        else {
            mesesVividosAnos = (mesAtual - mesNas); // mes vivido apos o aniversario
            mesNiverDiaAtualSomadosDias = ano.calcularDiferencaDeDiaDoMes(diaNiver, mesNas) + diaAtual; // calcula os dias dos meses do aniversario e do dia atual vividos ate o momento e soma os dois
            totalMeses = ano.somarDiasDosMeses(mesNas, mesesVividosAnos - 1);
            resultadoFinal = totalMeses + diasCertos + mesNiverDiaAtualSomadosDias + calcularAnosBissestos(2024);
            return resultadoFinal;
        }
    }

    public int calcularAnosBissestos(int ultimoAnoBissesto)
    {
        int i, anoNascimento;
        anoNascimento = separarElementos(dataNascimento)[2];
        for (i =0; ultimoAnoBissesto >= anoNascimento; i++)
        {
            ultimoAnoBissesto -=4;
        }
        return i;
    }

    public int calcularIdadeEmHora()
    {
        int resultado;
        resultado= calcularIdadeEmDia() * 24;
        return resultado;
    }

    public int calcularIdadeEmMinuto()
    {
        int resultado;
        resultado = calcularIdadeEmHora() * 60;
        return resultado;
    }

    public long calcularIdadeEmSegundo()
    {
        long resultado;
        resultado = calcularIdadeEmMinuto() * 60;
        return resultado;
    }

    private int mesNasMaior()
    {
        int mesAtual = separarElementos(dataDeHoje)[1];
        int mesNas = separarElementos(dataNascimento)[1];

        if (mesNas > mesAtual) return 2;
        else if (mesAtual == mesNas) return 1;
        else return 0;
    }


}
