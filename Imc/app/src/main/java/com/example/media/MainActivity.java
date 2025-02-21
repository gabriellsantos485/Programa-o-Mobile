package com.example.media;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    public void calcularImc(View v){
        TextView altura = findViewById(R.id.altura);
        TextView peso = findViewById(R.id.peso);
        TextView campoImc = findViewById(R.id.campoImc);

        double alturaEmDouble, pesoEmDouble, resultado=0;

        alturaEmDouble = Double.parseDouble(altura.getText().toString());
        pesoEmDouble = Double.parseDouble(peso.getText().toString());

        resultado =pesoEmDouble / (alturaEmDouble * 2);
        campoImc.setText(Double.toString(resultado));

    }
}