package com.kata.RomanNumeralsTest;
import com.kata.RomanNumerals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralsValidationTest {

    @Test
    public void testValidRomans(){
        String[] validRomans = {
                "I", "II", "III", "IV", "V", "IX", "X", "XL",
                "L", "XC", "C", "CD", "D", "CM", "MCMXCIV", "MMMCMXCIX"
        };
        for (String roman : validRomans){
            assertDoesNotThrow(()-> RomanNumerals.fromRoman(roman),
                    ()-> String.format("El número romano válido '%s' no debería lanzar excepción", roman));
        }
    }

    @Test
    public void testInvalidRomans() {
        String[] invalidRomans = {
                "IIII", "VV", "LL", "DD",
                "IL", "IC", "XD", "VX",
                "ABC", "123", "", "MMMM"
        };
        for (String roman : invalidRomans) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumerals.fromRoman(roman),
                    () -> String.format("El número romano inválido '%s' debería lanzar excepción", roman));
        }

    }

}
