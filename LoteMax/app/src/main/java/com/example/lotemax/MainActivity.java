package com.example.lotemax;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RadioButton btnGerarUmaSequencia, btnDuasSequencias, btnTresSequencias, btnQuatroSequencias;
    MegaCena mega = new MegaCena();
    LinearLayout numeroDoContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGerarUmaSequencia = findViewById(R.id.umaSequencia);
        numeroDoContainer = findViewById(R.id.areaDeNumeros);
        btnDuasSequencias = findViewById(R.id.duasSequencia);
        btnTresSequencias = findViewById(R.id.tresSequencia);
        btnQuatroSequencias = findViewById(R.id.quatroSequencia);

        btnGerarUmaSequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numeroDoContainer.removeAllViews();
                gerarOsNumeros();
        }});

        btnDuasSequencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numeroDoContainer.removeAllViews();
                gerarOsNumeros();
                gerarOsNumeros();
            }});

        btnTresSequencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numeroDoContainer.removeAllViews();
                gerarOsNumeros();
                gerarOsNumeros();
                gerarOsNumeros();
            }});

        btnQuatroSequencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numeroDoContainer.removeAllViews();
                gerarOsNumeros();
                gerarOsNumeros();
                gerarOsNumeros();
                gerarOsNumeros();
            }});



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    private void gerarOsNumeros() {
        LinearLayout linha = new LinearLayout(this);
        linha.setOrientation(LinearLayout.HORIZONTAL);
        linha.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams linhaParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linhaParam.setMargins(0, 16, 0, 0);
        linha.setLayoutParams(linhaParam);
        int[] numeros = mega.gerarNumero(); // Gera os números antes do loop
        Arrays.sort(numeros);
        for (int i = 0; i < 6; i++) {
            TextView areaDeNumeros = new TextView(this);
            areaDeNumeros.setText(String.valueOf(numeros[i]));
            areaDeNumeros.setTextSize(24);
            areaDeNumeros.setTextColor(ContextCompat.getColor(this, android.R.color.black));
            areaDeNumeros.setGravity(Gravity.CENTER);
            areaDeNumeros.setBackground(ContextCompat.getDrawable(this, R.drawable.circulo));
            areaDeNumeros.setPadding(30, 30, 30, 30);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 150);
            params.setMargins(16, 0, 16, 0);
            areaDeNumeros.setLayoutParams(params);
            linha.addView(areaDeNumeros);
        }
        numeroDoContainer.addView(linha);
    }

}