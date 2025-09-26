package com.kata;

public class BankOcr {

    /**
     * Método de ejemplo: convierte una cadena OCR en número (simplificado)
     */
    public static String parseOcr(String ocr) {
        // Aquí solo devolvemos el mismo string para testing; la lógica completa puede implementarse después
        return ocr;
    }

    public static void main(String[] args) {
        System.out.println("=== Bank OCR Kata ===");

        String[] ejemplos = {
                "123456789",
                "000000051",
                "490067715"
        };

        for (String ocr : ejemplos) {
            String parsed = parseOcr(ocr);
            System.out.printf("OCR: %s -> Número: %s%n", ocr, parsed);
        }
    }
}
