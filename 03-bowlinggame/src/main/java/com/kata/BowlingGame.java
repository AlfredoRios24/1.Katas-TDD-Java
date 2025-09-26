package com.kata;

public class BowlingGame {

    private final int[] rolls = new int[21]; // hasta 21 rollos posibles
    private int currentRoll = 0;

    // Para controlar el frame actual y la primera/segunda bola
    private int currentFrame = 1;
    private boolean firstBallInFrame = true;
    private int lastFirstRollPins = 0;

    // Datos del décimo frame (para validar extras)
    private int tenthRollsCount = 0;
    private int tenthFirst = -1;
    private int tenthSecond = -1;

    public void roll(int pins) {
        // Validación básica de pins
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException("Pins must be between 0 and 10");
        }

        // No permitir más rolls que el array reservado
        if (currentRoll >= rolls.length) {
            throw new IllegalArgumentException("No se pueden registrar más de 21 lanzamientos en una partida");
        }

        // Si estamos en frames 1..9
        if (currentFrame <= 9) {
            if (firstBallInFrame) {
                // Primera bola del frame
                if (pins == 10) {
                    // Strike: se consume 1 lanzamiento en el array
                    rolls[currentRoll++] = pins;
                    // avanzar de frame
                    currentFrame++;
                    // firstBallInFrame queda true para el siguiente frame
                } else {
                    // Bola normal (no strike): guardamos y esperamos segunda bola
                    rolls[currentRoll++] = pins;
                    lastFirstRollPins = pins;
                    firstBallInFrame = false;
                }
            } else {
                // Segunda bola del frame: validar suma <= 10
                if (lastFirstRollPins + pins > 10) {
                    throw new IllegalArgumentException("Un frame no puede sumar más de 10 pines");
                }
                rolls[currentRoll++] = pins;
                // Avanzamos de frame y volvemos a primera bola
                currentFrame++;
                firstBallInFrame = true;
            }
            return;
        }

        // ---- Frame 10 (último frame) ----
        // Aquí permitimos hasta 3 lanzamientos, pero validamos según reglas:
        // - Si primera bola < 10:
        //      segunda bola válida si first+second <= 10.
        //      si first+second < 10 -> no se permite tercera.
        //      si first+second == 10 -> spare -> se permite tercera (0..10)
        // - Si primera bola == 10 (strike):
        //      segunda bola se lanza con rack completo (0..10).
        //      si segunda bola == 10 -> tercera puede ser 0..10.
        //      si segunda bola < 10 -> tercera no puede hacer second+third > 10 (pues pins no se resetean).
        //
        // Implementación que registra rolls en el mismo array lineal:
        if (tenthRollsCount == 0) {
            // primer lanzamiento del décimo
            tenthFirst = pins;
            rolls[currentRoll++] = pins;
            tenthRollsCount++;
            return;
        }

        if (tenthRollsCount == 1) {
            // segundo lanzamiento del décimo
            tenthSecond = pins;

            // Si la primera bola no fue strike, la suma de primera+segunda <= 10
            if (tenthFirst < 10 && (tenthFirst + tenthSecond > 10)) {
                throw new IllegalArgumentException("En el décimo frame, primera+segunda tirada no puede exceder 10 salvo que la primera sea strike");
            }

            rolls[currentRoll++] = pins;
            tenthRollsCount++;
            return;
        }

        if (tenthRollsCount == 2) {
            // posible tercer lanzamiento del décimo:
            // solo permitido si:
            //  - hubo spare (first+second == 10)
            //  - ó hubo strike en primera (first == 10)
            if (tenthFirst == 10) {
                // primera fue strike: si segunda < 10, entonces segunda+tercera <= 10
                if (tenthSecond < 10 && (tenthSecond + pins > 10)) {
                    throw new IllegalArgumentException("En el décimo frame, tras strike la suma de segunda+tercera no puede exceder 10 si la segunda no fue strike");
                }
                // si tenthSecond == 10 entonces pins puede ser 0..10
            } else if (tenthFirst + tenthSecond == 10) {
                // spare en las dos primeras -> el tercer lanzamiento puede ser 0..10
            } else {
                // no hubo spare ni strike -> no se permite tercera tirada
                throw new IllegalArgumentException("No se permite una tercera tirada en el décimo frame si no hubo spare o strike");
            }

            rolls[currentRoll++] = pins;
            tenthRollsCount++;
            return;
        }

        // si ya llegamos acá, se intenta añadir una cuarta tirada en el décimo -> error
        throw new IllegalArgumentException("No se pueden registrar más de 3 lanzamientos en el décimo frame");
    }

    // ---- score() y auxiliares (tu implementación previa puede permanecer) ----
    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) { // Strike
                score += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) { // Spare
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

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
