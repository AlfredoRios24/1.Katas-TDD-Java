package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

public class BowlingGameTest {

    //Comprobar si el resultado de ningun bolo es 0
    @Test
    void shouldReturnZeroForAllGutterBalls() {
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                0, 0, // 1º
                0, 0, // 2º
                0, 0, // 3º
                0, 0, // 4º
                0, 0, // 5º
                0, 0, // 6º
                0, 0, // 7º
                0, 0, // 8º
                0, 0, // 9º
                0, 0, // 10º
        };
        int expectedScore = 0;

        for (int pins : rolls) {
            game.roll(pins);
        }

        assertEquals(expectedScore, game.score());
    }

    //Comprobar si el resultado de todos los bolos es 1, entonces sumo 20?
    @Test
    void shouldReturnOneForAllPins() {
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                1, 1, // 1º
                1, 1, // 2º
                1, 1, // 3º
                1, 1, // 4º
                1, 1, // 5º
                1, 1, // 6º
                1, 1, // 7º
                1, 1, // 8º
                1, 1, // 9º
                1, 1, // 10º
        };
        int expectedScore = 20;

        for (int pins : rolls) {
            game.roll(pins);
        }

        assertEquals(expectedScore, game.score());
    }

    //Comprobar si se aplica un spare?
    @Test
    void shouldApplyBonusForSpare(){
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                5, 5, // 1º spare + bonus
                5, 0, // 2º
                0, 0, // 3º
                0, 0, // 4º
                0, 0, // 5º
                0, 0, // 6º
                0, 0, // 7º
                0, 0, // 8º
                0, 0, // 9º
                0, 0, // 10º
        };
        int expectedScore = 20;

        for (int pins : rolls) {
            game.roll(pins);
        }

        assertEquals(expectedScore, game.score());
    }

    //Comprobar si se aplica un strike?
    @Test
    void shouldApplyBonusForSrike(){
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                10, // 1º strike
                5, 0, // 2º + bonus
                0, 0, // 3º
                0, 0, // 4º
                0, 0, // 5º
                0, 0, // 6º
                0, 0, // 7º
                0, 0, // 8º
                0, 0, // 9º
                0, 0, // 10º
        };
        int expectedScore = 20;

        for (int pins : rolls) {
            game.roll(pins);
        }

        assertEquals(expectedScore, game.score());
    }

    //Comprobar si se aplica un juego perfecto "maximos en todas las tiradas"
    @Test
    void shouldReturnPerfectGame() {
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                10,    // Frame 1 - strike
                10,   // Frame 2 - strike
                10,   // Frame 3 - strike
                10,  // Frame 4 - strike
                10,  // Frame 5 - strike
                10,   // Frame 6 - strike
                10,  // Frame 7 - strike
                10, // Frame 8 - strike
                10,   // Frame 9 - strike
                10, 10, 10 // Frame 10 - strike + bonus
        };
        int expectedScore = 300;

        for (int pins : rolls) {
            game.roll(pins);
        }

        assertEquals(expectedScore, game.score());
    }
    //Simular una partida aleatoria
    @Test
    void shouldReturnNormalGame() {
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                3, 7,    // Frame 1 - spare
                10,      // Frame 2 - strike
                5, 4,    // Frame 3
                10,      // Frame 4 - strike
                0, 8,    // Frame 5
                2, 6,    // Frame 6
                10,      // Frame 7 - strike
                10,      // Frame 8 - strike
                7, 3,    // Frame 9 - spare
                10, 10, 5 // Frame 10 - strike + bonus
        };
        int expectedScore = 174;

        for (int pins : rolls) {
            game.roll(pins);
        }

        assertEquals(expectedScore, game.score());
    }


    //Manejo de errores
    @Test
    void shouldErrorforFrame(){
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                0, 0, // 1º
                0, 0, // 2º
                0, 0, // 3º
                0, 0, // 4º
                0, 0, // 5º
                0, 0, // 6º
                0, 0, // 7º
                0, 0, // 8º
                0, 0, // 9º
                0, 0, // 10º
                5, 4  //  frame extra
        };
        assertThrows(IllegalArgumentException.class, () -> {
            for (int pins : rolls) {
                game.roll(pins);
            }
        });
    }

    @Test
    void shouldErrorForTooManyRollsAfterStrikeInLastFrame(){
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                0, 0, // 1º
                0, 0, // 2º
                0, 0, // 3º
                0, 0, // 4º
                0, 0, // 5º
                0, 0, // 6º
                0, 0, // 7º
                0, 0, // 8º
                0, 0, // 9º
                0, 0, // 10º
                10, 5, 4, 3 // strike con 3 extras
        };
        assertThrows(IllegalArgumentException.class, () -> {
            for (int pins : rolls) {
                game.roll(pins);
            }
        });
    }

    @Test
    void shouldErrorForTooManyRollsAfterSpareInLastFrame(){
        BowlingGame game = new BowlingGame();
        int[] rolls = {
                0, 0, // 1º
                0, 0, // 2º
                0, 0, // 3º
                0, 0, // 4º
                0, 0, // 5º
                0, 0, // 6º
                0, 0, // 7º
                0, 0, // 8º
                0, 0, // 9º
                0, 0, // 10º
                7, 3, 5, 2 // spare con 2 extras
        };
        assertThrows(IllegalArgumentException.class, () -> {
            for (int pins : rolls) {
                game.roll(pins);
            }
        });
    }


}

