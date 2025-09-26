package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    // 1️⃣ Suma simple
    @Test
    void shouldReturnZeroForEmptyString() {
        assertEquals("0", calculator.add(""));
    }

    @Test
    void shouldReturnOnlyOneNumber() {
        assertEquals("1", calculator.add("1"));
    }

    @Test
    void shouldReturnSumOfTwoNumbers() {
        assertEquals("3", calculator.add("1,2"));
    }

    // 2️⃣ Múltiples números
    @Test
    void shouldReturnSumOfMultipleNumbers() {
        assertEquals("10", calculator.add("1,2,3,4"));
    }

    // 3️⃣ Nueva línea como separador
    @Test
    void shouldReturnSumWithNewlineSeparator() {
        assertEquals("10", calculator.add("1\n2,3,4"));
    }

    // 4️⃣ Separador final
    @Test
    void shouldReturnErrorWhenInputEndsWithSeparator() {
        assertEquals("Number expected but EOF found", calculator.add("1,3,"));
    }

    // 5️⃣ Separadores personalizados
    @Test
    void shouldSupportCustomSingleCharacterDelimiter() {
        assertEquals("3", calculator.add("//;\n1;2"));
        assertEquals("6", calculator.add("//|\n1|2|3"));
    }

    @Test
    void shouldSupportCustomLongDelimiter() {
        assertEquals("5", calculator.add("//sep\n2sep3"));
    }

    @Test
    void shouldReturnErrorForIncorrectSeparator() {
        // Comprobar errores de separador incorrecto según la implementación actual
        assertEquals("Invalid number '2,3' at position 2.", calculator.add("//|\n1|2,3"));
        assertEquals("Invalid number ',3' at position 2.", calculator.add("//sep\n2sep,3"));
    }

    // 6️⃣ Números negativos
    @Test
    void shouldReturnErrorForSingleNegative() {
        assertEquals("Negative not allowed: -1", calculator.add("-1,2"));
    }

    @Test
    void shouldReturnErrorForMultipleNegatives() {
        assertEquals("Negative not allowed: -4, -5", calculator.add("2,-4,-5"));
    }

    @Test
    void shouldSumNumbersIfNoNegatives() {
        assertEquals("6", calculator.add("1,2,3"));
    }

    @Test
    void shouldHandleCustomDelimiterWithNegative() {
        assertEquals("Negative not allowed: -2", calculator.add("//;\n1;-2;3"));
    }

    // 7️⃣ Múltiples errores
    @Test
    void shouldReturnMultipleErrorsWithEmptyTokenAndNegative() {
        String input = "//;\n-1;;-2";
        String expected = "Negative not allowed: -1, -2\nNumber expected but '' found at position 3.";
        assertEquals(expected, calculator.add(input));
    }

    // 8️⃣ Gestión de errores avanzada

    @Test
    void shouldReturnErrorsWithAdvancedHandling() {
        String input = "//|\n1|2,-3,,4";
        String expected = "Invalid number '2,-3,,4' at position 2.";
        assertEquals(expected, calculator.add(input));
    }
}
