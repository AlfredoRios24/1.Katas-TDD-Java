package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

    @Test
    void shouldDieByUnderpopulation() {
        int[][] grid = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        GameOfLife game = new GameOfLife(grid);
        int[][] nextGen = game.nextGeneration();

        assertEquals(0, nextGen[0][1], "La célula debe morir por soledad");
    }

    @Test
    void shouldSurviveWithTwoOrThreeNeighbors() {
        int[][] grid = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 0, 0}
        };

        GameOfLife game = new GameOfLife(grid);
        int[][] nextGen = game.nextGeneration();

        assertEquals(1, nextGen[1][1], "La célula central debe sobrevivir");
    }

    @Test
    void shouldDieByOverpopulation() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        GameOfLife game = new GameOfLife(grid);
        int[][] nextGen = game.nextGeneration();

        assertEquals(0, nextGen[1][1], "La célula muere por sobrepoblación");
    }

    @Test
    void shouldBecomeAliveByReproduction() {
        int[][] grid = {
                {1, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };

        GameOfLife game = new GameOfLife(grid);
        int[][] nextGen = game.nextGeneration();

        assertEquals(1, nextGen[1][1], "La célula muerta revive por reproducción");
    }
}
