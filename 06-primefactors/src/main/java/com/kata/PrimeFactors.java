package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {

    /**
     * Calcula los factores primos de un número entero.
     *
     * @param number número a factorizar (mayor que 0)
     * @return lista de factores primos
     * @throws IllegalArgumentException si el número es menor que 1
     */
    public static List<Integer> of(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a 1: " + number);
        }

        List<Integer> factors = new ArrayList<>();
        int n = number;

        // Factoriza dividiendo por los primos más pequeños
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Si queda un número mayor que 1, es primo
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Prime Factors Kata ===");

        // Algunos ejemplos fijos
        int[] ejemplos = {1, 2, 3, 4, 6, 12, 17, 60, 100};

        System.out.println("\n-- Factores primos de ejemplos --");
        for (int num : ejemplos) {
            List<Integer> factors = PrimeFactors.of(num);
            System.out.printf("%d -> %s%n", num, factors);
        }

        // Permite al usuario probar su propio número
        System.out.println("\nIngrese un número entero para factorizar en primos:");
        int inputNumber = scanner.nextInt();

        try {
            List<Integer> resultado = PrimeFactors.of(inputNumber);
            System.out.printf("%d -> %s%n", inputNumber, resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
