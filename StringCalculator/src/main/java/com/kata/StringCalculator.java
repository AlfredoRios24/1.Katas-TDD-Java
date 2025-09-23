package com.kata;

public class StringCalculator {

    public String add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        String customDelimiter = null;
        String numbersPart = numbers;

        // Separador personalizado
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            if (newlineIndex == -1) {
                return "Number expected but EOF found";
            }
            customDelimiter = numbers.substring(2, newlineIndex);
            numbersPart = numbers.substring(newlineIndex + 1);
        }

        // Verificar si termina con separador
        if (numbersPart.isEmpty() ||
                numbersPart.endsWith(",") || numbersPart.endsWith("\n") ||
                (customDelimiter != null && numbersPart.endsWith(customDelimiter))) {
            return "Number expected but EOF found";
        }

        int sum = 0;
        int pos = 0;
        // Lista para almacenar todos los números negativos encontrados
        StringBuilder negatives = new StringBuilder();

        while (pos < numbersPart.length()) {
            int nextDelimiterPos;
            String token;

            // Determinar la posición del siguiente separador
            if (customDelimiter != null) {
                nextDelimiterPos = numbersPart.indexOf(customDelimiter, pos);
            } else {
                int commaPos = numbersPart.indexOf(",", pos);
                int newlinePos = numbersPart.indexOf("\n", pos);

                if (commaPos == -1) commaPos = numbersPart.length();
                if (newlinePos == -1) newlinePos = numbersPart.length();

                nextDelimiterPos = Math.min(commaPos, newlinePos);
            }

            if (nextDelimiterPos != -1 && nextDelimiterPos < numbersPart.length()) {
                token = numbersPart.substring(pos, nextDelimiterPos);
            } else {
                token = numbersPart.substring(pos);
                nextDelimiterPos = numbersPart.length();
            }

            // Detectar separador incorrecto
            if (customDelimiter != null) {
                if (token.contains(",") || token.contains("\n")) {
                    char found = token.contains(",") ? ',' : '\n';
                    int errorPos = pos + token.indexOf(found) + 1;
                    return "'" + customDelimiter + "' expected but '" + found + "' found at position " + errorPos + ".";
                }
            }

            int num = Integer.parseInt(token);
            // Si es negativo, lo añadimos a la lista de negativos
            if (num < 0) {
                if (negatives.length() > 0) {
                    negatives.append(", ");
                }
                negatives.append(num);
            }

            sum += num;
            pos = nextDelimiterPos + (customDelimiter != null ? customDelimiter.length() : 1);
        }

        // Si hay negativos, retornamos el mensaje de error
        if (negatives.length() > 0) {
            return "Negative not allowed: " + negatives.toString();
        }

        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();

        System.out.println(calc.add(""));                   // 0
        System.out.println(calc.add("1,2"));                // 3
        System.out.println(calc.add("//;\n1;2"));           // 3
        System.out.println(calc.add("//|\n1|2|3"));         // 6
        System.out.println(calc.add("//sep\n2sep3"));       // 5
        System.out.println(calc.add("//|\n1|2,3"));         // '|' expected but ',' found at position 3.
    }
}
