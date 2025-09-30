package com.kata.RomanNumeralsTest;

import com.kata.RomanNumerals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsConsistencyTest {

    @Test
    public void testToRomanAndBackConsistency() {
        int[] numeros = {
                1, 2, 3, 4, 9, 14, 58, 90, 400, 944, 1994, 3999
        };

        for (int n : numeros) {
            String roman = RomanNumerals.toRoman(n);
            int result = RomanNumerals.fromRoman(roman);

            assertEquals(n, result,
                    () -> String.format("Fallo en consistencia: %d -> %s -> %d", n, roman, result));
        }
    }

    @Test
    public void testFromRomanAndBackConsistency() {
        String[] romanos = {
                "I", "II", "III", "IV", "IX", "XIV", "LVIII",
                "XC", "CD", "CM", "MCMXCIV", "MMMCMXCIX"
        };

        for (String roman : romanos) {
            int number = RomanNumerals.fromRoman(roman);
            String result = RomanNumerals.toRoman(number);

            assertEquals(roman, result,
                    () -> String.format("Fallo en consistencia: %s -> %d -> %s", roman, number, result));
        }
    }

}
