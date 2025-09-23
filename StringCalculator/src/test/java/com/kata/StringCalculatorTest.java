package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void shouldReturnZeroForEmptyString() {
        assertEquals("0", calculator.add(""));
    }

    @Test
    void shouldReturnOnlyOneNumber(){
        assertEquals("1", calculator.add("1"));
    }

    @Test
    void shouldReturnSumOfTwoNumbers() {
        assertEquals("3", calculator.add("1,2"));
    }

    // 2. Múltiples números
    @Test
    void shouldReturnSumOfMultipleNumbers() {
        assertEquals("10", calculator.add("1,2,3,4"));
    }

    // 3. Nueva línea como separador
    @Test
    void shouldReturnSumWithNewlineSeparator() {
        assertEquals("10", calculator.add("1\n2,3,4"));
    }

    // 4. Separador final: - No permitir que la entrada termine con un separador
    @Test
    void shouldReturnErrorWhenInputEndsWithSeparator() {
        assertEquals("Number expected but EOF found", calculator.add("1,3,"));
    }

    // 5. Separadores personalizados: permitir delimitadores personalizados
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
        assertEquals("'|' expected but ',' found at position 4.", calculator.add("//|\n1|2,3"));
    }

    // 6. Números negativos: No se permiten negativos y retornar mensaje
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

    //7. Múltiples errores: Retornar todos los errores detectados


}
