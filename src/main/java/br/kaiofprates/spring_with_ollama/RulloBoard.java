package br.kaiofprates.spring_with_ollama;

import java.util.Random;

public class RulloBoard {
    private final int size; // Tamanho do tabuleiro
    private final int[][] board; // Tabuleiro original
    private final int[][] solution; // Solução gerada

    public RulloBoard(int size) {
        this.size = size;
        this.board = generateBoard(size);
        this.solution = generateSolution(board);
    }

    public int[][] getBoard() {
        return this.board; 
    }

    public int[][] getSolution() {
        return this.solution; 
    }

    // Gera um tabuleiro com valores aleatórios de 1 a 9
    private int[][] generateBoard(final int columns) {
        int[][] matrix = new int[columns][columns];
        Random random = new Random(); // Cria uma instância de Random

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                // Atribui um valor aleatório entre 1 e 9
                matrix[i][j] = random.nextInt(9) + 1; // Simplifica a geração do número
            }
        }

        return matrix;
    }

    // Gera a solução a partir do tabuleiro original
    private int[][] generateSolution(final int[][] origin) {
        int column = origin.length;
        int[][] matrix = new int[column][column];
        Random random = new Random(); // Cria uma instância de Random

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextBoolean() ? origin[i][j] : 0; // Usa nextBoolean() para simplificar
            }
        }

        return matrix;
    }

}
