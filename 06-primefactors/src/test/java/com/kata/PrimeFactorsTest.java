package com.kata;

import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeFactorsTest {

    @Test
    public void shouldReturnEmptyListForOne() {
        PrimeFactors primeFactors = new PrimeFactors();
        assertEquals(List.of(), primeFactors.generate(1));
    }

    @Test
    public void shouldReturnListWithNumberItselfForPrimes() {
        PrimeFactors primeFactors = new PrimeFactors();
        assertEquals(List.of(2), primeFactors.generate(2));
        assertEquals(List.of(3), primeFactors.generate(3));
        assertEquals(List.of(5), primeFactors.generate(5));
        assertEquals(List.of(7), primeFactors.generate(7));
    }

    @Test
    public void shouldReturnPrimeFactorsForCompositeNumbers() {
        PrimeFactors primeFactors = new PrimeFactors();
        assertEquals(List.of(2, 2), primeFactors.generate(4));
        assertEquals(List.of(2, 3), primeFactors.generate(6));
        assertEquals(List.of(2, 2, 3), primeFactors.generate(12));
        assertEquals(List.of(3, 5), primeFactors.generate(15));
    }

    @Test
    public void shouldThrowExceptionForInvalidInput() {
        PrimeFactors primeFactors = new PrimeFactors();
        assertThrows(IllegalArgumentException.class, () -> primeFactors.generate(0));
        assertThrows(IllegalArgumentException.class, () -> primeFactors.generate(-5));
    }


    @Test
    public void shouldHandleLargeNumbersEfficiently() {
        PrimeFactors primeFactors = new PrimeFactors();

        // Número grande con muchos factores
        List<Integer> factors = primeFactors.generate(1_000_000);
        assertFalse(factors.isEmpty());
        assertEquals(List.of(2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5), factors.subList(0, 12)); // primeros factores conocidos
    }

    @Test
    public void shouldReturnSingleFactorForLargePrime() {
        PrimeFactors primeFactors = new PrimeFactors();
        assertEquals(List.of(7919), primeFactors.generate(7919)); // 7919 es primo
    }

    @Test
    public void shouldGeneratePrimeFactorsForRange() {
        PrimeFactors primeFactors = new PrimeFactors();

        Map<Integer, List<Integer>> result = primeFactors.generateRange(1, 5);

        assertEquals(List.of(), result.get(1));
        assertEquals(List.of(2), result.get(2));
        assertEquals(List.of(3), result.get(3));
        assertEquals(List.of(2, 2), result.get(4));
        assertEquals(List.of(5), result.get(5));
    }

    @Test
    public void shouldThrowExceptionForInvalidRange() {
        PrimeFactors primeFactors = new PrimeFactors();

        assertThrows(IllegalArgumentException.class, () -> primeFactors.generateRange(0, 10));
        assertThrows(IllegalArgumentException.class, () -> primeFactors.generateRange(10, 5));
    }

}
