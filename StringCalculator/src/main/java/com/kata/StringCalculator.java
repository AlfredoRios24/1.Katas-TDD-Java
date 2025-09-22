package com.kata;


import javax.print.DocFlavor;

public class StringCalculator {

    public String add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        // 1️⃣ Verificar separador al final
        if (numbers.endsWith(",") || numbers.endsWith("\n")) {
            return "Number expected but EOF found";
        }

        // 2️⃣ Separar por coma o salto de línea
        String[] parts = numbers.split(",|\n");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        // 3️⃣ Devolver resultado
        return String.valueOf(sum);
    }


    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.add(""));

    }
}