package com.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzEfervescenteTest {

    private final FizzBuzzEfervescente fizzBuzz = new FizzBuzzEfervescente();

    // 1️⃣ Validación de límites
    @Test
    void shouldNotChangeMinNumber() {
        assertEquals(1, FizzBuzzEfervescente.MIN_NUMBER, "El valor mínimo no debe cambiar");
    }

    @Test
    void shouldNotChangeMaxNumber() {
        assertEquals(100, FizzBuzzEfervescente.MAX_NUMBER, "El valor máximo no debe cambiar");
    }

    // 2️⃣ Números normales (no Fizz ni Buzz)
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 16, 19, 22})
    void shouldReturnNumberWhenNotFizzNorBuzz(int number) {
        assertEquals(String.valueOf(number), fizzBuzz.getFizzBuzz(number));
    }

    // 3️⃣ Números Fizz (múltiplos de 3 o contienen 3)
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 13, 23, 31, 32, 36, 39})
    void shouldReturnFizzWhenDivisibleBy3OrContains3(int number) {
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(number));
    }

    // 4️⃣ Números Buzz (múltiplos de 5 o contienen 5)
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 50, 52})
    void shouldReturnBuzzWhenDivisibleBy5OrContains5(int number) {
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(number));
    }

    // 5️⃣ Números FizzBuzz (combinación de reglas, incluyendo concatenaciones múltiples)
    @ParameterizedTest
    @ValueSource(ints = {15, 30, 33, 35, 53, 51})
    void shouldReturnFizzBuzzWhenMultipleRulesApply(int number) {
        String expected = "";
        String numStr = String.valueOf(number);

        if (number % 3 == 0 || numStr.contains("3")) expected += "Fizz";
        if (number % 5 == 0 || numStr.contains("5")) expected += "Buzz";

        assertEquals(expected, fizzBuzz.getFizzBuzz(number));
    }

    // 6️⃣ Casos extremos
    @Test
    void shouldReturnFirstNumberCorrectly() {
        assertEquals("1", fizzBuzz.getFizzBuzz(FizzBuzzEfervescente.MIN_NUMBER));
    }

    @Test
    void shouldReturnLastNumberCorrectly() {
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(FizzBuzzEfervescente.MAX_NUMBER));
    }

    // 7️⃣ Robustez: todos los números 1–100 devuelven algo no nulo y no vacío
    @Test
    void shouldReturnNonEmptyStringForAllNumbersUpToMax() {
        for (int i = FizzBuzzEfervescente.MIN_NUMBER; i <= FizzBuzzEfervescente.MAX_NUMBER; i++) {
            String result = fizzBuzz.getFizzBuzz(i);
            assertNotNull(result, "Resultado no debe ser null para " + i);
            assertFalse(result.isEmpty(), "Resultado no debe ser vacío para " + i);
        }
    }
}
