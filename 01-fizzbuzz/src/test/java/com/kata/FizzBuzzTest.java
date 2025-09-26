package com.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    // 1️⃣ Validación de los límites
    @Test
    void shouldNotChangeMinNumber() {
        assertEquals(1, FizzBuzz.MIN_NUMBER);
    }

    @Test
    void shouldNotChangeMaxNumber() {
        assertEquals(100, FizzBuzz.MAX_NUMBER);
    }

    // 2️⃣ Números normales (no múltiplos de 3 ni 5)
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19})
    void shouldReturnNumberWhenNotMultipleOf3Or5(int number) {
        assertEquals(String.valueOf(number), fizzBuzz.getFizzBuzz(number));
    }

    // 3️⃣ Múltiplos de 3
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21, 24, 27})
    void shouldReturnFizzWhenMultipleOf3(int number) {
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(number));
    }

    // 4️⃣ Múltiplos de 5
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 35, 40})
    void shouldReturnBuzzWhenMultipleOf5(int number) {
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(number));
    }

    // 5️⃣ Múltiplos de 3 y 5
    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75, 90})
    void shouldReturnFizzBuzzWhenMultipleOf3And5(int number) {
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(number));
    }

    // 6️⃣ Casos extremos
    @Test
    void shouldReturn1ForFirstNumber() {
        assertEquals("1", fizzBuzz.getFizzBuzz(FizzBuzz.MIN_NUMBER));
    }

    @Test
    void shouldReturnBuzzForHundred() {
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(FizzBuzz.MAX_NUMBER));
    }
}
