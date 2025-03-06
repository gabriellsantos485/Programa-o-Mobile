package com.example.conversordenumeros;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.TextView;

import com.calculadora.Conversor;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button botaoDecParaBin = findViewById(R.id.decParaBi);
        Button botaoDecParaOctal = findViewById(R.id.decParaOctal);
        Button botaoDecParaHexa = findViewById(R.id.decParaHex);
        Button botaoBiParaDec = findViewById(R.id.biParaDec);

        botaoDecParaHexa.setOnClickListener(v -> fazerDecimalParaHexa());
        botaoDecParaBin.setOnClickListener(v -> fazerDecimalParaBinario());
        botaoDecParaOctal.setOnClickListener(v -> fazerDecimalParaOctal());
        botaoBiParaDec.setOnClickListener(v -> fazerBiParaDec());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void fazerDecimalParaBinario(){
        TextView campoParaImpressao = findViewById(R.id.impressao);
        TextView numeroDigitado = findViewById(R.id.numero);
        Conversor conversor = new Conversor(2);
        int valorNumeroEmInteiro = Integer.parseInt(numeroDigitado.getText().toString());
        campoParaImpressao.setText(conversor.getCalcularDecimal(valorNumeroEmInteiro));
    }

    public void fazerDecimalParaOctal(){
        TextView campoParaImpressao = findViewById(R.id.impressao);
        TextView numeroDigitado = findViewById(R.id.numero);
        Conversor conversor = new Conversor(8);
        int valorNumeroEmInteiro = Integer.parseInt(numeroDigitado.getText().toString());
        campoParaImpressao.setText(conversor.getCalcularDecimal(valorNumeroEmInteiro));
    }

    public void fazerDecimalParaHexa(){
        TextView campoParaImpressao = findViewById(R.id.impressao);
        TextView numeroDigitado = findViewById(R.id.numero);
        Conversor conversor = new Conversor(16);
        int valorNumeroEmInteiro = Integer.parseInt(numeroDigitado.getText().toString());
        campoParaImpressao.setText(conversor.getHexa(valorNumeroEmInteiro));
    }

    public void fazerBiParaDec(){
        TextView campoParaImpressao = findViewById(R.id.impressao);
        TextView numeroDigitado = findViewById(R.id.numero);
        Conversor conversor = new Conversor(2);
        String valorNumeroEmInteiro = (numeroDigitado.getText().toString());
        campoParaImpressao.setText(conversor.getCalcularBiParaDecimal("1010101010", 0));
    }


}