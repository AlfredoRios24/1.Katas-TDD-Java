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
        StringBuilder negatives = new StringBuilder();
        StringBuilder errors = new StringBuilder();

        while (pos < numbersPart.length()) {
            int nextDelimiterPos;
            String token;

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
                    if (errors.length() > 0) errors.append("\n");
                    errors.append("'").append(customDelimiter).append("' expected but '")
                            .append(found).append("' found at position ").append(errorPos).append(".");
                    break; // Después de encontrar separador incorrecto no seguimos sumando
                }
            }

            if (token.isEmpty()) {
                if (errors.length() > 0) errors.append("\n");
                errors.append("Number expected but '' found at position ").append(pos + 1).append(".");
            } else {
                try {
                    int num = Integer.parseInt(token);
                    if (num < 0) {
                        if (negatives.length() > 0) negatives.append(", ");
                        negatives.append(num);
                    } else {
                        sum += num;
                    }
                } catch (NumberFormatException e) {
                    if (errors.length() > 0) errors.append("\n");
                    errors.append("Invalid number '").append(token).append("' at position ").append(pos + 1).append(".");
                }
            }

            pos = nextDelimiterPos + (customDelimiter != null ? customDelimiter.length() : 1);
        }

        StringBuilder result = new StringBuilder();
        if (negatives.length() > 0) {
            result.append("Negative not allowed: ").append(negatives);
        }
        if (errors.length() > 0) {
            if (result.length() > 0) result.append("\n");
            result.append(errors);
        }

        return result.length() > 0 ? result.toString() : String.valueOf(sum);
    }
}

