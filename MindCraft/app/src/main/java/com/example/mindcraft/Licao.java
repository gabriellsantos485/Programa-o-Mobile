package com.example.mindcraft;

import android.os.Bundle;
import android.view.View;
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
    private Button responder, btnProximo;

    private String[][] perguntas = {
            {"Qual comando é usado para recuperar dados de uma tabela no SQL?",
                    "SELECT", "INSERT", "DELETE", "UPDATE", "1"},

            {"Qual comando adiciona uma nova linha em uma tabela?",
                    "ADD", "INSERT", "MODIFY", "UPDATE", "2"},

            {"Qual cláusula é usada para filtrar resultados em uma consulta SQL?",
                    "WHERE", "ORDER BY", "GROUP BY", "HAVING", "1"},

            {"Qual palavra-chave SQL é usada para ordenar os resultados de uma consulta?",
                    "GROUP BY", "ORDER BY", "SORT", "ARRANGE", "2"},

            {"Qual comando é usado para remover todas as linhas de uma tabela sem apagar sua estrutura?",
                    "DELETE", "DROP", "TRUNCATE", "CLEAR", "3"},

            {"Qual operador SQL é usado para buscar um padrão em uma coluna de texto?",
                    "LIKE", "MATCH", "FIND", "SEARCH", "1"},

            {"Qual comando SQL é usado para modificar dados existentes em uma tabela?",
                    "CHANGE", "MODIFY", "UPDATE", "ALTER", "3"},

            {"O que a cláusula GROUP BY faz?",
                    "Agrupa registros com valores iguais em colunas específicas",
                    "Ordena os registros da tabela",
                    "Exclui valores duplicados",
                    "Seleciona os primeiros registros", "1"},

            {"Qual comando é usado para remover uma tabela do banco de dados?",
                    "REMOVE", "DELETE", "DROP", "CLEAR", "3"},

            {"Qual dos seguintes comandos cria uma nova tabela?",
                    "CREATE TABLE", "NEW TABLE", "MAKE TABLE", "ADD TABLE", "1"}
    };

    private int indiceAtual = 0;


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

        btnProximo = findViewById(R.id.proxima);

        responder = findViewById(R.id.responder);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indiceAtual < perguntas.length -1){
                    indiceAtual++;
                    carregarPergunta();
                }else{
                    campoDePergunta.setText("Fim do quiz");
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarPergunta(){
        campoDePergunta.setText(perguntas[indiceAtual][0]);
        opcaoNumero1.setText(perguntas[indiceAtual][1]);
        opcaoNumero2.setText(perguntas[indiceAtual][2]);
        opcaoNumero3.setText(perguntas[indiceAtual][3]);
        opcaoNumero4.setText(perguntas[indiceAtual][4]);
    }




}