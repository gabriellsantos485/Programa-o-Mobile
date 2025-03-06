package com.example.mindcraft;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Licao extends AppCompatActivity {

    /**
     * Classe responsavel pela tela de liçoes independentes da categoria selecionada
     * Utiliza a classe auxiliar Questão para armazenar questoes e as opções
     * @author Gabriel Rodrigues dos Santos
     * @since 01/03/2025
     */
    private TextView campoDePergunta;
    private RadioButton opcaoNumero1, opcaoNumero2, opcaoNumero3, opcaoNumero4; // instanciação dos botoes de opçoes
    private Button responder;
    private Questao pergunta1= new Questao("O que é SQL ?", new String[]{"Sequencia Quadricular Lateral", "Doença", "Linguagem de Banco de dados", "Nenhuma das anteriores"}, 2);
    String[] perguntas = {"Pergunta1", "Pergunta2", "Pergunta3", "Pergunta4", "Pergunta5", "Pergunta6", "Pergunta7", "Pergunta8", "Pergunta9", "Pergunta10" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_licao);

        // todos os IDs necessarios estarão aqui (Minha convenção)
        campoDePergunta= findViewById(R.id.pergunta);
        opcaoNumero1 = findViewById(R.id.opc1);
        opcaoNumero2 =findViewById(R.id.opc2);
        opcaoNumero3 =findViewById(R.id.opc3);
        opcaoNumero4 =findViewById(R.id.opc4);

        responder = findViewById(R.id.responder);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        }
    private void carregarQuestao(String pergunta, String opcao1, String opcao2, String opcao3, String opcao4){ // methodo que tem que ser atualizado constantemente
        campoDePergunta.setText(pergunta);
        opcaoNumero1.setText(opcao1);
        opcaoNumero2.setText(opcao2);
        opcaoNumero3.setText(opcao3);
        opcaoNumero4.setText(opcao4);
    }

    private void irParaProxima(){

    }



}