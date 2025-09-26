package com.kata;

import java.util.Arrays;

public class GameOfLife {

    /**
     * Genera la siguiente generación del tablero según las reglas del Juego de la Vida.
     *
     * @param board tablero actual (0 = muerto, 1 = vivo)
     * @return nueva generación
     */
    public static int[][] nextGeneration(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] next = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbors = countLiveNeighbors(board, r, c);
                if (board[r][c] == 1) {
                    next[r][c] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
                } else {
                    next[r][c] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        return next;
    }

    private static int countLiveNeighbors(int[][] board, int r, int c) {
        int count = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i == r && j == c) continue;
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    count += board[i][j];
                }
            }
        }
        return count;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "O" : ".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Game of Life Kata ===");

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Generación inicial:");
        printBoard(board);

        int[][] next = nextGeneration(board);
        System.out.println("\nSiguiente generación:");
        printBoard(next);
    }
}
