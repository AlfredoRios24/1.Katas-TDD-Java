package com.kata;

public class GameOfLife {
    private int[][] grid;
    private final int rows;
    private final int cols;

    public GameOfLife(int[][] initialGrid) {
        this.grid = initialGrid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public int[][] nextGeneration() {
        int[][] next = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int aliveNeighbors = countAliveNeighbors(r, c);

                if (grid[r][c] == 1) {
                    // reglas de muerte o supervivencia
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        next[r][c] = 0; // muere
                    } else {
                        next[r][c] = 1; // sobrevive
                    }
                } else {
                    // nacimiento
                    if (aliveNeighbors == 3) {
                        next[r][c] = 1;
                    }
                }
            }
        }

        this.grid = next;
        return next;
    }

    private int countAliveNeighbors(int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
