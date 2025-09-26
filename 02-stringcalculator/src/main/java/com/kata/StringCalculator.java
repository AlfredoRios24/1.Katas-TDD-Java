package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {

    public String add(String numbers) {
        // 1️⃣ Caso vacío o nulo
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        // 2️⃣ Delimitador por defecto: coma o nueva línea
        String delimiter = ",|\n";
        String numbersPart = numbers;

        // 3️⃣ Separador personalizado
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            if (newlineIndex == -1) {
                return "Number expected but EOF found";
            }
            delimiter = java.util.regex.Pattern.quote(numbers.substring(2, newlineIndex));
            numbersPart = numbers.substring(newlineIndex + 1);
        }

        // 4️⃣ Entrada vacía después de delimitador personalizado
        if (numbersPart.isEmpty()) {
            return "0";
        }

        // 5️⃣ Detectar separador final
        if (numbersPart.matches(".*(" + delimiter + ")$")) {
            return "Number expected but EOF found";
        }

        // 6️⃣ Separar tokens según delimitador
        String[] tokens = numbersPart.split(delimiter, -1);
        List<Integer> negatives = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        int sum = 0;
        int pos = 0;

        // 7️⃣ Recorrer tokens
        for (String token : tokens) {
            // 7a️⃣ Detectar token vacío
            if (token.isEmpty()) {
                errors.add("Number expected but '' found at position " + pos + ".");
            } else {
                try {
                    int num = Integer.parseInt(token);

                    // 7b️⃣ Detectar número negativo
                    if (num < 0) {
                        negatives.add(num);
                    } else {
                        // 7c️⃣ Sumar número positivo
                        sum += num;
                    }
                } catch (NumberFormatException e) {
                    // 7d️⃣ Detectar número inválido
                    errors.add("Invalid number '" + token + "' at position " + pos + ".");
                }
            }
            pos += token.length() + 1;
        }

        // 8️⃣ Construir mensaje de errores por números negativos
        if (!negatives.isEmpty()) {
            StringBuilder negMsg = new StringBuilder("Negative not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                if (i > 0) negMsg.append(", ");
                negMsg.append(negatives.get(i));
            }
            errors.add(0, negMsg.toString());
        }

        // 9️⃣ Retornar errores si existen
        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        }

        // 🔟 Retornar suma si no hay errores
        return String.valueOf(sum);
    }

    // 9️⃣ Multiplicación siguiendo la misma lógica que add
    public String multiply(String numbers) {
        // 1️⃣ Caso vacío o nulo
        if (numbers == null || numbers.isEmpty()) {
            return "1"; // Producto neutro
        }

        // 2️⃣ Delimitador por defecto
        String delimiter = ",|\n";
        String numbersPart = numbers;

        // 3️⃣ Separador personalizado
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            if (newlineIndex == -1) {
                return "Number expected but EOF found";
            }
            delimiter = java.util.regex.Pattern.quote(numbers.substring(2, newlineIndex));
            numbersPart = numbers.substring(newlineIndex + 1);
        }

        // 4️⃣ Entrada vacía después de delimitador personalizado
        if (numbersPart.isEmpty()) {
            return "1";
        }

        // 5️⃣ Detectar separador final
        if (numbersPart.matches(".*(" + delimiter + ")$")) {
            return "Number expected but EOF found";
        }

        // 6️⃣ Separar tokens según delimitador
        String[] tokens = numbersPart.split(delimiter, -1);
        List<Integer> negatives = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        int pos = 0;
        int product = 1;

        // 7️⃣ Recorrer tokens
        for (String token : tokens) {
            // 7a️⃣ Detectar token vacío
            if (token.isEmpty()) {
                errors.add("Number expected but '' found at position " + pos + ".");
            } else {
                try {
                    int num = Integer.parseInt(token);

                    // 7b️⃣ Detectar número negativo
                    if (num < 0) {
                        negatives.add(num);
                    } else {
                        // 7c️⃣ Multiplicar número positivo
                        product *= num;
                    }
                } catch (NumberFormatException e) {
                    // 7d️⃣ Detectar número inválido
                    errors.add("Invalid number '" + token + "' at position " + pos + ".");
                }
            }
            pos += token.length() + 1;
        }

        // 8️⃣ Construir mensaje de errores por números negativos
        if (!negatives.isEmpty()) {
            StringBuilder negMsg = new StringBuilder("Negative not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                if (i > 0) negMsg.append(", ");
                negMsg.append(negatives.get(i));
            }
            errors.add(0, negMsg.toString());
        }

        // 9️⃣ Retornar errores si existen
        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        }

        // 🔟 Retornar producto si no hay errores
        return String.valueOf(product);
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Calculator ===");
        System.out.println("Introduce una operación (vacío para salir):");

        while (true) {
            System.out.print("\nEntrada: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Saliendo...");
                break;
            }

            // Llamada a add
            String sumResult = calculator.add(input);
            System.out.println("Suma: " + sumResult);

            // Llamada a multiply
            String multiplyResult = calculator.multiply(input);
            System.out.println("Multiplicación: " + multiplyResult);
        }

        scanner.close();
    }

}
