package com.example.calculadoradenotas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private EditText notaP1, notaP2, notaP3, faltas;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar os componentes da interface
        notaP1 = findViewById(R.id.notaP1);
        notaP2 = findViewById(R.id.notaP2);
        notaP3 = findViewById(R.id.notaP3);
        faltas = findViewById(R.id.faltas);
        textResultado = findViewById(R.id.textResultado);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(v -> calcularMedia());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularMedia() {
        // Recuperar as notas e faltas do usuário
        double p1 = Double.parseDouble(notaP1.getText().toString());
        double p2 = Double.parseDouble(notaP2.getText().toString());
        double p3 = Double.parseDouble(notaP3.getText().toString());
        int numeroFaltas = Integer.parseInt(faltas.getText().toString());

        if (p1 < 0 || p2 < 0 || p3 < 0 || p1 > 10 || p2 > 10 || p3 > 10) {
            textResultado.setText("Notas devem ser entre 0 e 10.");
            return;
        }

        // Calcular a média final (duas maiores notas)
        double[] notas = {p1, p2, p3};
        java.util.Arrays.sort(notas); //ordenação das notas
        double mediaFinal = (notas[1] + notas[2]) / 2;

        // Determinar a situação do aluno
        String situacao = "";

        if (numeroFaltas > 5 && mediaFinal>= 6) {
            situacao = "Reprovado por faltas";
        } else if (mediaFinal < 6 && numeroFaltas <= 5) {
            situacao = "Reprovado por nota";
        } else if (numeroFaltas <= 5 && mediaFinal >= 6) {
            situacao = "Aprovado";
        } else {
            situacao = "Reprovado por nota e faltas";
        }

        String resultado = "Média final: " + mediaFinal + "\nSituação: " + situacao;
        textResultado.setText(resultado);
    }
}
