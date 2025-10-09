package com.kata;

import java.util.*;


import java.util.*;

public class BankOcr {

    private static final Map<String, String> DIGITS = Map.ofEntries(
            Map.entry(" _ | ||_|", "0"),
            Map.entry("   |  |", "1"),
            Map.entry(" _  _||_ ", "2"),
            Map.entry(" _  _| _|", "3"),
            Map.entry("   |_|  |", "4"),
            Map.entry(" _ |_  _|", "5"),
            Map.entry(" _ |_ |_|", "6"),
            Map.entry(" _   |  |", "7"),
            Map.entry(" _ |_|_|", "8"),
            Map.entry(" _ |_| _|", "9")
    );

    public static String parseAccount(List<String> input) {
        if (input == null || input.size() != 3) {
            throw new IllegalArgumentException("El input debe contener exactamente 3 líneas.");
        }

        StringBuilder result = new StringBuilder();
        int length = input.get(0).length();

        if (input.get(1).length() != length || input.get(2).length() != length) {
            throw new IllegalArgumentException("Todas las líneas OCR deben tener la misma longitud.");
        }

        for (int i = 0; i < length; i += 3) {
            if (i + 3 > length) {
                throw new IllegalArgumentException("Bloque de dígito incompleto.");
            }
            String digitOCR = input.get(0).substring(i, i + 3)
                    + input.get(1).substring(i, i + 3)
                    + input.get(2).substring(i, i + 3);
            result.append(DIGITS.getOrDefault(digitOCR, "?"));
        }

        return result.toString();
    }

    public static List<String> parseMultipleAccounts(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Lista de líneas vacía.");
        }

        List<String> accounts = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 4) {
            if (i + 3 > lines.size()) {
                throw new IllegalArgumentException("Bloque de cuenta incompleto.");
            }
            List<String> block = lines.subList(i, i + 3);
            accounts.add(parseAccount(block));
        }
        return accounts;
    }

    public static boolean isValidChecksum(String accountNumber) {
        if (accountNumber == null || !accountNumber.matches("\\d{9}")) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(accountNumber.charAt(i)) * (9 - i);
        }
        return sum % 11 == 0;
    }
}
