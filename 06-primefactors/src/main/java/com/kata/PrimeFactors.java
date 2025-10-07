package com.kata;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    /**
     * Calcula los factores primos de un número entero.
     *
     * @param number número a factorizar (mayor que 0)
     * @return lista de factores primos
     * @throws IllegalArgumentException si el número es menor que 1
     */
    public List<Integer> generate(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a 1: " + number);
        }

        List<Integer> factors = new ArrayList<>();
        int n = number;

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }
}
