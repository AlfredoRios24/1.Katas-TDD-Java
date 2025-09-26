package com.kata;

import java.util.Scanner;

public class LeapYear {

    /**
     * Determina si un año es bisiesto.
     *
     * @param year año a evaluar
     * @return true si es bisiesto, false si no
     * @throws IllegalArgumentException si el año es menor o igual a 0
     */
    public static boolean isLeapYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("El año debe ser mayor que 0: " + year);
        }

        // Regla del calendario gregoriano
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Leap Year Kata ===");

        // Algunos ejemplos fijos
        int[] ejemplos = {1600, 1700, 1800, 1900, 2000, 2004, 2019, 2020, 2100};

        System.out.println("\n-- Ejemplos de años bisiestos --");
        for (int year : ejemplos) {
            boolean esBisiesto = LeapYear.isLeapYear(year);
            System.out.printf("%d -> %b%n", year, esBisiesto);
        }

        // Permite al usuario probar su propio año
        System.out.println("\nIngrese un año para verificar si es bisiesto:");
        int inputYear = scanner.nextInt();

        try {
            boolean resultado = LeapYear.isLeapYear(inputYear);
            if (resultado) {
                System.out.printf("%d es un año bisiesto%n", inputYear);
            } else {
                System.out.printf("%d NO es un año bisiesto%n", inputYear);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }


}
