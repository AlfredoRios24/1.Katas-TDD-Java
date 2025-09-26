package com.kata;


import java.util.Scanner;

public class RomanNumerals {
    // Arrays de símbolos romanos y sus valores correspondientes
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Convierte un número entero a su representación en números romanos.
     *
     * @param number número entero (1..3999)
     * @return cadena con el número romano
     * @throws IllegalArgumentException si el número está fuera del rango válido
     */
    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Número fuera de rango (1..3999): " + number);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                number -= VALUES[i];
            }
        }

        return result.toString();
    }

    /**
     * Método opcional: valida si una cadena es un número romano correcto.
     *
     * @param roman cadena a validar
     * @return true si es un número romano válido, false en caso contrario
     */
    public static boolean isValidRoman(String roman) {
        if (roman == null || roman.isEmpty()) {
            return false;
        }
        return roman.matches(
                "^M{0,3}(CM|CD|D?C{0,3})"
                        + "(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"
        );
    }

    // Método opcional para convertir de romano a entero (más avanzado)
    public static int fromRoman(String roman) {
        if (!isValidRoman(roman)) {
            throw new IllegalArgumentException("Número romano inválido: " + roman);
        }

        int index = 0;
        int result = 0;

        for (int i = 0; i < SYMBOLS.length; i++) {
            while (roman.startsWith(SYMBOLS[i], index)) {
                result += VALUES[i];
                index += SYMBOLS[i].length();
            }
        }

        return result;
    }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Roman Numerals Kata ===");

            // Ejemplos de conversión de enteros a romanos
            int[] ejemplos = {1, 3, 4, 9, 15, 58, 1994, 3999};

            System.out.println("\n-- Enteros a Romanos --");
            for (int num : ejemplos) {
                String roman = RomanNumerals.toRoman(num);
                System.out.printf("%d -> %s%n", num, roman);
            }

            // Validación de números romanos
            String[] romanos = {"I", "III", "IV", "IX", "LVIII", "MCMXCIV", "MMMM", "IIII", ""};

            System.out.println("\n-- Validación de Romanos --");
            for (String roman : romanos) {
                boolean valido = RomanNumerals.isValidRoman(roman);
                System.out.printf("%s -> %b%n", roman, valido);
            }

            // Prueba de conversión de romano a entero (opcional)
            System.out.println("\n-- Romanos a Enteros --");
            for (String roman : romanos) {
                if (RomanNumerals.isValidRoman(roman)) {
                    int entero = RomanNumerals.fromRoman(roman);
                    System.out.printf("%s -> %d%n", roman, entero);
                } else {
                    System.out.printf("%s -> inválido%n", roman);
                }
            }

            // Permite al usuario probar su propio número
            System.out.println("\nIngrese un número entero (1..3999) para convertir a romano:");
            int numero = scanner.nextInt();
            try {
                String resultado = RomanNumerals.toRoman(numero);
                System.out.printf("%d -> %s%n", numero, resultado);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Permite al usuario probar su propio número romano
            System.out.println("\nIngrese un número romano para convertir a entero:");
            String romanInput = scanner.next();
            if (RomanNumerals.isValidRoman(romanInput)) {
                int valor = RomanNumerals.fromRoman(romanInput);
                System.out.printf("%s -> %d%n", romanInput, valor);
            } else {
                System.out.println("Número romano inválido");
            }

            scanner.close();
        }

}
