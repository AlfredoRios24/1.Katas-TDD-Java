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

    @Test
    void shouldReturnSumOfMultipleNumbers() {
        assertEquals("10", calculator.add("1,2,3,4"));
    }

    @Test
    void shouldReturnSumWithNewlineSeparator() {
        assertEquals("10", calculator.add("1\n2,3,4"));
    }

    @Test
    void shouldReturnErrorWhenInputEndsWithSeparator() {
        assertEquals("Number expected but EOF found", calculator.add("1,3,"));
    }

}
