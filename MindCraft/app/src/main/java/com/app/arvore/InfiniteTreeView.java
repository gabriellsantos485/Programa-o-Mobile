package com.app.arvore; // Substitua "seuapp" pelo nome do seu projeto

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class InfiniteTreeView extends View {
    private Paint paintBranch, paintFruit;
    private int treeHeight = 50; // Altura inicial da árvore
    private int screenHeight;
    private Random random = new Random();

    // Lista para armazenar os galhos
    private ArrayList<Branch> branches = new ArrayList<>();

    public InfiniteTreeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Configura a pintura dos galhos
        paintBranch = new Paint();
        paintBranch.setColor(Color.parseColor("#8B4513")); // Marrom
        paintBranch.setStrokeWidth(10);
        paintBranch.setStyle(Paint.Style.STROKE);

        // Configura a pintura dos frutos
        paintFruit = new Paint();
        paintFruit.setColor(Color.RED);
        paintFruit.setStyle(Paint.Style.FILL);

        // Adiciona o primeiro galho (tronco principal)
        branches.add(new Branch(getWidth() / 2, getHeight(), getWidth() / 2, getHeight() - 200));

        // Altura da tela
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Atualiza a altura da árvore conforme o usuário sobe
        treeHeight += 5;

        // Adiciona novos galhos quando necessário
        if (branches.size() < 20) { // Número máximo de galhos na tela
            addNewBranch();
        }

        // Desenha os galhos
        for (Branch branch : branches) {
            canvas.drawLine(branch.xStart, branch.yStart + treeHeight,
                    branch.xEnd, branch.yEnd + treeHeight, paintBranch);

            // Desenha o fruto no final do galho
            canvas.drawCircle(branch.xEnd, branch.yEnd + treeHeight, 20, paintFruit);
        }

        // Remove galhos antigos para evitar sobrecarga
        if (branches.size() > 50) {
            branches.remove(0);
        }

        // Redesenha continuamente
        invalidate();
    }

    // Método para adicionar novos galhos dinamicamente
    private void addNewBranch() {
        int lastIndex = branches.size() - 1;
        Branch lastBranch = branches.get(lastIndex);

        // Cria um novo galho aleatório
        int newX = lastBranch.xEnd + random.nextInt(200) - 100; // Movimento aleatório
        int newY = lastBranch.yEnd - random.nextInt(150) - 50; // Sempre para cima

        branches.add(new Branch(lastBranch.xEnd, lastBranch.yEnd, newX, newY));
    }

    // Classe interna para representar os galhos
    private static class Branch {
        int xStart, yStart, xEnd, yEnd;

        Branch(int xStart, int yStart, int xEnd, int yEnd) {
            this.xStart = xStart;
            this.yStart = yStart;
            this.xEnd = xEnd;
            this.yEnd = yEnd;
        }
    }
}
