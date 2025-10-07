package com.kata;

import java.util.*;

/**
 * Kata: Prime Factors
 * Permite generar factores primos de un número o un rango de números.
 */
public class PrimeFactors {

    /**
     * Genera los factores primos de un número entero.
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
        int candidate = 2;

        while (number > 1) {
            while (number % candidate == 0) {
                factors.add(candidate);
                number /= candidate;
            }
            candidate++;
        }

        return factors;
    }

    /**
     * Devuelve un mapa con los factores primos de todos los números en el rango [from, to].
     *
     * @param from inicio del rango (>=1)
     * @param to fin del rango (>=from)
     * @return mapa: número → lista de factores primos
     * @throws IllegalArgumentException si el rango es inválido
     */
    public Map<Integer, List<Integer>> generateRange(int from, int to) {
        if (from < 1 || to < from) {
            throw new IllegalArgumentException("Rango inválido: from=" + from + ", to=" + to);
        }

        Map<Integer, List<Integer>> result = new LinkedHashMap<>();

        for (int i = from; i <= to; i++) {
            result.put(i, generate(i));
        }

        return result;
    }

    /**
     * Interfaz de consola interactiva para probar la kata.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeFactors pf = new PrimeFactors();

        System.out.println("=== Prime Factors Kata ===\n");

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Calcular factores primos de un número");
            System.out.println("2. Calcular factores primos de un rango");
            System.out.println("3. Salir");
            System.out.print("→ Opción: ");

            int option;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada inválida. Intente de nuevo.\n");
                scanner.nextLine(); // limpiar entrada
                continue;
            }

            if (option == 1) {
                System.out.print("Ingrese un número entero: ");
                int n = scanner.nextInt();
                try {
                    System.out.printf("%d → %s%n%n", n, pf.generate(n));
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️ " + e.getMessage() + "\n");
                }

            } else if (option == 2) {
                System.out.print("Ingrese el número inicial: ");
                int from = scanner.nextInt();
                System.out.print("Ingrese el número final: ");
                int to = scanner.nextInt();

                try {
                    Map<Integer, List<Integer>> result = pf.generateRange(from, to);
                    System.out.println("\n-- Factores primos del rango --");
                    for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
                        System.out.printf("%d → %s%n", entry.getKey(), entry.getValue());
                    }
                    System.out.println();
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️ " + e.getMessage() + "\n");
                }

            } else if (option == 3) {
                System.out.println("👋 Saliendo de la aplicación. ¡Hasta pronto!");
                break;

            } else {
                System.out.println("⚠️ Opción no válida. Intente de nuevo.\n");
            }
        }

        scanner.close();
    }
}
