package com.kata;

import org.junit.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeFactorsTest {



    @Test
    public void shouldReturnEmptyListForOne(){
        PrimeFactors primeFactors = new PrimeFactors();

        assertEquals(List.of(), primeFactors.generate(1));
        assertEquals(List.of(), primeFactors.generate(2));
        assertEquals(List.of(), primeFactors.generate(3));
        assertEquals(List.of(), primeFactors.generate(5));
    }

    @Test
    public void shouldThrowExceptionForInvalidInput(){
        PrimeFactors primeFactors = new PrimeFactors();

        assertThrows(IllegalArgumentException.class, () -> primeFactors.generate(0));
        assertThrows(IllegalArgumentException.class, () -> primeFactors.generate(-5));
    }



}
