package com.kata.RomanNumeralsTest;
import com.kata.RomanNumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsToRomanTest {

    @Test
    public void testBasicNumber() {
        assertEquals("I", RomanNumerals.toRoman(1));
        assertEquals("II", RomanNumerals.toRoman(2));
        assertEquals("III", RomanNumerals.toRoman(3));
        assertEquals("V", RomanNumerals.toRoman(5));
        assertEquals("X", RomanNumerals.toRoman(10));
        assertEquals("L", RomanNumerals.toRoman(50));
        assertEquals("C", RomanNumerals.toRoman(100));
        assertEquals("D", RomanNumerals.toRoman(500));
        assertEquals("M", RomanNumerals.toRoman(1000));
    }

    @Test
    public void testSubtractiveNumbers() {
        assertEquals("IV", RomanNumerals.toRoman(4));
        assertEquals("IX", RomanNumerals.toRoman(9));
        assertEquals("XL", RomanNumerals.toRoman(40));
        assertEquals("XC", RomanNumerals.toRoman(90));
        assertEquals("CD", RomanNumerals.toRoman(400));
        assertEquals("CM", RomanNumerals.toRoman(900));
    }

    @Test
    public void testCombineNumbers() {
        assertEquals("VI", RomanNumerals.toRoman(6));
        assertEquals("XIV", RomanNumerals.toRoman(14));
        assertEquals("LVIII", RomanNumerals.toRoman(58));
        assertEquals("MCMXCIV", RomanNumerals.toRoman(1994));
    }

    @Test
    public void testRangeInfo() {
        int[] valores = {-5, 0, 1, 3, 3999, 3000, 4000, 5000};

        for (int val : valores) {
            try {
                String roman = RomanNumerals.toRoman(val);
                System.out.printf("Valor %d -> %s (dentro del rango)%n", val, roman);
            } catch (IllegalArgumentException e) {
                System.out.printf("Valor %d -> fuera del rango: %s%n", val, e.getMessage());
            }
        }
    }

    @Test
    public void testValidLimits() {
        assertEquals("I", RomanNumerals.toRoman(1));
        assertEquals("MMMCMXCIX", RomanNumerals.toRoman(3999));
    }

    @Test
    public void testBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.toRoman(-5));
    }

    @Test
    public void testAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.toRoman(4000));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.toRoman(5000));
    }

}
