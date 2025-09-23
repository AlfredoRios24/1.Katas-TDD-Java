package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    // 1️⃣ Suma simple: cadena vacía, un número o dos números separados por coma
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

    // 2️⃣ Múltiples números: cualquier cantidad de números separados por coma
    @Test
    void shouldReturnSumOfMultipleNumbers() {
        assertEquals("10", calculator.add("1,2,3,4"));
    }

    // 3️⃣ Nueva línea como separador: \n se permite como delimitador
    @Test
    void shouldReturnSumWithNewlineSeparator() {
        assertEquals("10", calculator.add("1\n2,3,4"));
    }

    // 4️⃣ Separador final: no se permite que la cadena termine con un separador
    @Test
    void shouldReturnErrorWhenInputEndsWithSeparator() {
        assertEquals("Number expected but EOF found", calculator.add("1,3,"));
    }

    // 5️⃣ Separadores personalizados: delimitadores de un caracter o largos
    @Test
    void shouldSupportCustomSingleCharacterDelimiter() {
        assertEquals("3", calculator.add("//;\n1;2"));
        assertEquals("6", calculator.add("//|\n1|2|3"));
    }

    @Test
    void shouldSupportCustomLongDelimiter() {
        assertEquals("5", calculator.add("//sep\n2sep3"));
    }

    // 5️⃣ Validación de separador incorrecto
    @Test
    void shouldReturnErrorForIncorrectSeparator() {
        assertEquals("'|' expected but ',' found at position 4.", calculator.add("//|\n1|2,3"));
        assertEquals("'sep' expected but ',' found at position 5.", calculator.add("//sep\n2sep,3"));
    }

    // 6️⃣ Números negativos: no permitidos, retornar mensaje con todos los negativos
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

    // 7️⃣ Múltiples errores: combinar errores de número vacío y negativos
    @Test
    void shouldReturnMultipleErrorsWithEmptyTokenAndNegative() {
        String input = "//;\n-1;;-2";
        String expected = "Negative not allowed: -1, -2\nNumber expected but '' found at position 4.";
        assertEquals(expected, calculator.add(input));
    }
}
