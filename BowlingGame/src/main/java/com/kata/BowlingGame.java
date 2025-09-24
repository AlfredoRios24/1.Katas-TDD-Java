package com.kata;

public class BowlingGame {

    private final int[] rolls = new int[21]; // máximo 21 lanzamientos en un juego
    private int currentRoll = 0;

    /**
     * Registra un lanzamiento
     * @param pins número de bolos derribados en el lanzamiento
     */
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    /**
     * Calcula el score total de la partida
     * @return puntuación total
     */
    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) { // Strike
                score += 10 + strikeBonus(rollIndex);
                rollIndex++; // solo 1 lanzamiento en strike
            } else if (isSpare(rollIndex)) { // Spare
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2; // dos lanzamientos en spare
            } else { // Normal frame
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }

        return score;
    }

    // ---------- Métodos privados auxiliares ----------

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}
