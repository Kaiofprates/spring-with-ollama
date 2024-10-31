package br.kaiofprates.spring_with_ollama.util;

import br.kaiofprates.spring_with_ollama.RulloBoard;

public class BoardUtils {

    // Método para calcular e retornar as somas das linhas e colunas como string
    public static String printSums(final int[][] board) {
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

    // Método para imprimir o tabuleiro atual
    public static String printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder("Board:\n");
        for (int[] row : board) {
            for (int cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
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

    public static void generateBoard(final int numberOfBoards) {
        for (int i = 0; i < numberOfBoards; i++) {
            RulloBoard rullo = new RulloBoard(8);
            System.out.println("\n\t---------------BOARD------------------- " + i);

            // Imprime o tabuleiro e as regras lado a lado
            String board = BoardUtils.printBoard(rullo.getBoard());
            String rules = BoardUtils.printSums(rullo.getSolution());
            String[] boardLines = board.split("\n");
            String[] rulesLines = rules.split("\n");

            // Verifica se o número de linhas é igual, se não, ajusta
            int maxLines = Math.max(boardLines.length, rulesLines.length);
            for (int j = 0; j < maxLines; j++) {
                String boardLine = j < boardLines.length ? boardLines[j] : "";
                String rulesLine = j < rulesLines.length ? rulesLines[j] : "";
                System.out.printf("\t | %s | %s\n", boardLine, rulesLine);
            }

            // Imprime a solução ao lado das somas
            System.out.println("\n\t-------------SOLUCAO----------------- " + i);
            String solution = BoardUtils.printBoard(rullo.getSolution());
            String[] solutionLines = solution.split("\n");
            String[] sumsLines = BoardUtils.printSums(rullo.getSolution()).split("\n");

            maxLines = Math.max(solutionLines.length, sumsLines.length);
            for (int j = 0; j < maxLines; j++) {
                String solutionLine = j < solutionLines.length ? solutionLines[j] : "";
                String sumsLine = j < sumsLines.length ? sumsLines[j] : "";
                System.out.printf("\t | %s | %s\n", solutionLine, sumsLine);
            }

            System.out.println("\n\t======================================");
        }
    }

}
