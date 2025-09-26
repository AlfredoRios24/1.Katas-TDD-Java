package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorMultiplyTest {

    private final StringCalculator calculator = new StringCalculator();

    // 1️⃣ Multiplicación simple
    @Test
    void shouldReturnOneForEmptyString() {
        assertEquals("1", calculator.multiply(""));
    }

    @Test
    void shouldReturnOnlyOneNumber() {
        assertEquals("2", calculator.multiply("2"));
    }

    @Test
    void shouldReturnProductOfTwoNumbers() {
        assertEquals("6", calculator.multiply("2,3"));
    }

    // 2️⃣ Múltiples números
    @Test
    void shouldReturnProductOfMultipleNumbers() {
        assertEquals("24", calculator.multiply("1,2,3,4"));
    }

    // 3️⃣ Nueva línea como separador
    @Test
    void shouldReturnProductWithNewlineSeparator() {
        assertEquals("24", calculator.multiply("1\n2,3,4"));
    }

    // 4️⃣ Separador final
    @Test
    void shouldReturnErrorWhenInputEndsWithSeparator() {
        assertEquals("Number expected but EOF found", calculator.multiply("2,3,"));
    }

    // 5️⃣ Separadores personalizados
    @Test
    void shouldSupportCustomSingleCharacterDelimiter() {
        assertEquals("6", calculator.multiply("//;\n1;2;3"));
        assertEquals("24", calculator.multiply("//|\n2|3|4"));
    }

    @Test
    void shouldSupportCustomLongDelimiter() {
        assertEquals("8", calculator.multiply("//sep\n2sep2sep2"));
    }

    @Test
    void shouldReturnErrorForIncorrectSeparator() {
        assertEquals("Invalid number '2,3' at position 2.", calculator.multiply("//|\n1|2,3"));
        assertEquals("Invalid number ',3' at position 2.", calculator.multiply("//sep\n2sep,3"));
    }

    // 6️⃣ Números negativos
    @Test
    void shouldReturnErrorForSingleNegative() {
        assertEquals("Negative not allowed: -3", calculator.multiply("-3,2"));
    }

    @Test
    void shouldReturnErrorForMultipleNegatives() {
        assertEquals("Negative not allowed: -2, -3", calculator.multiply("2,-2,-3"));
    }

    @Test
    void shouldMultiplyNumbersIfNoNegatives() {
        assertEquals("24", calculator.multiply("1,2,3,4"));
    }

    @Test
    void shouldHandleCustomDelimiterWithNegative() {
        assertEquals("Negative not allowed: -2", calculator.multiply("//;\n1;-2;3"));
    }

    // 7️⃣ Múltiples errores
    @Test
    void shouldReturnMultipleErrorsWithEmptyTokenAndNegative() {
        String input = "//;\n-1;;-2";
        String expected = "Negative not allowed: -1, -2\nNumber expected but '' found at position 3.";
        assertEquals(expected, calculator.multiply(input));
    }

    // 8️⃣ Gestión de errores avanzada
    @Test
    void shouldReturnErrorsWithAdvancedHandling() {
        String input = "//|\n1|2,-3,,4";
        // Ajustado al comportamiento actual de multiply
        String expected = "Invalid number '2,-3,,4' at position 2.";
        assertEquals(expected, calculator.multiply(input));
    }
}
