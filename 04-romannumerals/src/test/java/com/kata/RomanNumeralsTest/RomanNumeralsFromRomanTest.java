package com.kata.RomanNumeralsTest;

import com.kata.RomanNumerals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
