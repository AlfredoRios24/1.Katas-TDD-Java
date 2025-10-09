package com.kata;

import java.util.*;

public class BankOcr {

    private static final Map<String, String> DIGITS = Map.ofEntries(
            Map.entry(" _ " +
                    "| |" +
                    "|_|", "0"),
            Map.entry("   " +
                    "  |" +
                    "  |", "1"),
            Map.entry(" _ " +
                    " _|" +
                    "|_ ", "2"),
            Map.entry(" _ " +
                    " _|" +
                    " _|", "3"),
            Map.entry("   " +
                    "|_|" +
                    "  |", "4"),
            Map.entry(" _ " +
                    "|_ " +
                    " _|", "5"),
            Map.entry(" _ " +
                    "|_ " +
                    "|_|", "6"),
            Map.entry(" _ " +
                    "  |" +
                    "  |", "7"),
            Map.entry(" _ " +
                    "|_|" +
                    "|_|", "8"),
            Map.entry(" _ " +
                    "|_|" +
                    " _|", "9")
    );

    /**
     * Parsea una cuenta de 3 líneas OCR en un string de dígitos.
     */
    public static String parseAccount(List<String> input) {
        if (input == null || input.size() != 3) {
            throw new IllegalArgumentException("El input debe contener exactamente 3 líneas (OCR).");
        }

        StringBuilder result = new StringBuilder();
        int length = input.get(0).length();

        for (int i = 0; i < length; i += 3) {
            if (i + 3 > length) {
                throw new IllegalArgumentException("Bloque OCR incompleto en la línea.");
            }

            String digitOCR = input.get(0).substring(i, i + 3) +
                    input.get(1).substring(i, i + 3) +
                    input.get(2).substring(i, i + 3);

            result.append(DIGITS.getOrDefault(digitOCR, "?"));
        }

        return result.toString();
    }

    /**
     * Parsea múltiples cuentas OCR. Cada cuenta ocupa 3 líneas + línea vacía.
     */
    public static List<String> parseMultipleAccounts(List<String> lines) {
        List<String> accounts = new ArrayList<>();
        int i = 0;

        while (i < lines.size()) {
            int remaining = lines.size() - i;
            if (remaining < 3) {
                throw new IllegalArgumentException("Bloque de cuenta incompleto: se requieren 3 líneas OCR.");
            }

            List<String> block = lines.subList(i, i + 3);
            for (String line : block) {
                if (line == null || line.length() % 3 != 0) {
                    throw new IllegalArgumentException("Bloque OCR con longitud inválida");
                }
            }

            accounts.add(parseAccount(block));
            i += 3;

            // Saltar línea vacía si existe
            if (i < lines.size() && lines.get(i).isEmpty()) {
                i++;
            }
        }

        return accounts;
    }

    /**
     * Valida checksum según: (d1×9 + d2×8 + ... + d9×1) % 11 == 0
     */
    public static boolean isValidChecksum(String accountNumber) {
        if (accountNumber == null || !accountNumber.matches("\\d{9}")) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(accountNumber.charAt(i));
            sum += digit * (9 - i);
        }
        return sum % 11 == 0;
    }
}
