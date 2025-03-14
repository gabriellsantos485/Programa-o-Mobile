package com.example.conversordeidade;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.conversor.calculadora.Conversor;

import java.time.LocalDate; //lib para capturar a data atual
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    /** Nome: Conversor de Idade
       Autor: Gabriel Rodrigues
       Faculdade: Fatec Santana de Parnaíba
       Disciplina: Programação para Dispositivos Móveis
       Descrisção: Aplicativo para calcular a idade de uma pessoa em dia, meses, horas, minutos, segundos
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public  void calcular(View v)
    {
        // Método para conversão

        TextView campoData = findViewById(R.id.data);
        TextView campoQtdeAno = findViewById(R.id.ano);
        TextView campoQtdeMes = findViewById(R.id.meses);
        TextView campoQtdeDias = findViewById(R.id.dia);
        TextView campoQtdeHoras = findViewById(R.id.hora);
        TextView campoQtdeMinutos = findViewById(R.id.minuto);
        TextView campoQtdeSegundos  = findViewById(R.id.segundo);
        TextView mensagemError = findViewById(R.id.mensagemError);
        String data = campoData.getText().toString();
        int qtdeAnos, qtdeMeses, qtdeDias, qtdeHoras ,qtdeMinutos;
        long qtdeSegundos;

        // Verifica de a data de entrada está vazia
        if (data.isEmpty()) {
            mensagemError.setText("A data não pode estar vazia.");
            mensagemError.setVisibility(VISIBLE);
            return;
        }

        try {
            Conversor conversor = new Conversor(data, capturarDataAtual()); //Classe Conversor

            qtdeAnos = conversor.calcularIdadeEmAno();
            qtdeMeses = conversor.calcularIdadeEmMeses();
            qtdeDias = conversor.calcularIdadeEmDia();
            qtdeHoras = conversor.calcularIdadeEmHora();
            qtdeMinutos = conversor.calcularIdadeEmMinuto();
            qtdeSegundos = conversor.calcularIdadeEmSegundo();

            campoQtdeAno.setText(String.valueOf(qtdeAnos));
            campoQtdeAno.setTextColor(Color.WHITE);

            campoQtdeMes.setText(String.valueOf(qtdeMeses));
            campoQtdeMes.setTextColor(Color.WHITE);

            campoQtdeDias.setText(String.valueOf(qtdeDias));
            campoQtdeDias.setTextColor(Color.WHITE);

            campoQtdeHoras.setText(String.valueOf(qtdeHoras));
            campoQtdeHoras.setTextColor(Color.WHITE);

            campoQtdeMinutos.setText(String.valueOf(qtdeMinutos));
            campoQtdeMinutos.setTextColor(Color.WHITE);

            campoQtdeSegundos.setText(String.valueOf(qtdeSegundos));
            campoQtdeSegundos.setTextColor(Color.WHITE);
            mensagemError.setVisibility(INVISIBLE);

        }catch (Exception e) {
            mensagemError.setText("Formato de data inválido. Use dd/MM/yyyy.");
            mensagemError.setVisibility(VISIBLE);

            campoQtdeAno.setText("");
            campoQtdeMes.setText("");
            campoQtdeDias.setText("");
            campoQtdeHoras.setText("");
            campoQtdeMinutos.setText("");
            campoQtdeSegundos.setText("");
        }
    }

    private String capturarDataAtual()
    {
        /**
        * Método para pegar a data atualizada do dia
        */
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formatter);

        return dataFormatada;
    }
}