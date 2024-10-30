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

    // Método para retornar a representação do tabuleiro como string
    String printBoard(final int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                sb.append(cell).append(" "); // Adiciona cada célula à string
            }
            sb.append("\n"); // Nova linha após cada linha do tabuleiro
        }
        return sb.toString(); // Retorna a string gerada
    }

    // Método para calcular e retornar as somas das linhas e colunas como string
    String printSums(final int[][] board) {
        StringBuilder sb = new StringBuilder();
        int[] rowSums = calculateRowSums(board);
        int[] colSums = calculateColumnSums(board);

        sb.append("\nSomas das Linhas:\n");
        for (int sum : rowSums) {
            sb.append(sum).append(" "); // Adiciona cada soma de linha à string
        }

        sb.append("\nSomas das Colunas:\n");
        for (int sum : colSums) {
            sb.append(sum).append(" "); // Adiciona cada soma de coluna à string
        }

        return sb.toString(); // Retorna a string gerada
    }

    // Método para calcular a soma das linhas
    static int[] calculateRowSums(final int[][] board) {
        int[] sums = new int[board.length]; // Array para armazenar as somas das linhas

        for (int i = 0; i < board.length; i++) {
            int rowSum = 0;
            for (int cell : board[i]) {
                rowSum += cell; // Soma os elementos da linha
            }
            sums[i] = rowSum; // Armazena a soma da linha
        }

        return sums;
    }

    // Método para calcular a soma das colunas
    static int[] calculateColumnSums(final int[][] board) {
        int[] sums = new int[board[0].length]; // Array para armazenar as somas das colunas

        for (int j = 0; j < board[0].length; j++) {
            int colSum = 0;
            for (int[] row : board) {
                colSum += row[j]; // Soma os elementos da coluna
            }
            sums[j] = colSum; // Armazena a soma da coluna
        }

        return sums;
    }
}
