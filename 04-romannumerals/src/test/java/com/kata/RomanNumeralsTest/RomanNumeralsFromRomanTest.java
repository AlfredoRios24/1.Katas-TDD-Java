package com.kata.RomanNumeralsTest;

import com.kata.RomanNumerals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsFromRomanTest {

    @Test
    public void testBasicNumber() {
        assertEquals(1, RomanNumerals.fromRoman("I"));
        assertEquals(2, RomanNumerals.fromRoman("II"));
        assertEquals(3, RomanNumerals.fromRoman("III"));
        assertEquals(5, RomanNumerals.fromRoman("V"));
        assertEquals(10, RomanNumerals.fromRoman("X"));
        assertEquals(50, RomanNumerals.fromRoman("L"));
        assertEquals(100, RomanNumerals.fromRoman("C"));
        assertEquals(500, RomanNumerals.fromRoman("D"));
        assertEquals(1000, RomanNumerals.fromRoman("M"));
    }

    @Test
    public void testSubtractiveNumbers() {
        assertEquals(4, RomanNumerals.fromRoman("IV"));
        assertEquals(9, RomanNumerals.fromRoman("IX"));
        assertEquals(40, RomanNumerals.fromRoman("XL"));
        assertEquals(90, RomanNumerals.fromRoman("XC"));
        assertEquals(400, RomanNumerals.fromRoman("CD"));
        assertEquals(900, RomanNumerals.fromRoman("CM"));
    }

    @Test
    public void testCombineNumbers() {
        assertEquals(6, RomanNumerals.fromRoman("VI"));
        assertEquals(14, RomanNumerals.fromRoman("XIV"));
        assertEquals(58, RomanNumerals.fromRoman("LVIII"));
        assertEquals(1994, RomanNumerals.fromRoman("MCMXCIV"));
    }

    @Test
    public void testRangeInfo() {
        String[] valores = {"-V", "0", "I", "III", "MCMXCIX", "MMM", "MMMM", "MMMMM"};

        for (String val : valores) {
            try {
                String roman = String.valueOf(RomanNumerals.fromRoman(val));
                System.out.printf("Valor %s -> %s (dentro del rango)%n", val, roman);
            } catch (IllegalArgumentException e) {
                System.out.printf("Valor %s -> fuera del rango: %s%n", val, e.getMessage());
            }
        }
    }


    @Test
    public void testValidLimits() {
        assertEquals(1, RomanNumerals.fromRoman("I"));
        assertEquals(3999, RomanNumerals.fromRoman("MMMCMXCIX"));
    }

    @Test
    public void testBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.fromRoman("0"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.fromRoman("-V"));
    }

    @Test
    public void testAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.fromRoman("MMMM"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.fromRoman("MMMMM"));
    }





}
