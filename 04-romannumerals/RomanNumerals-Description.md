# Roman Numerals

El módulo Roman Numerals es una implementación de la clásica kata que consiste en **convertir números enteros a números romanos (y opcionalmente al revés)**.  
Este ejercicio es excelente para practicar **TDD (Test-Driven Development)**, diseño incremental y validación de reglas.

---

## Objetivo

Crear un método `toRoman(int number)` que, a partir de un número entero, devuelva su representación en números romanos.  
Opcionalmente añadir el método `fromRoman(String roman)` para convertir de vuelta.

---

## Requisitos principales

### 1. Reglas básicas
- Conocer los símbolos romanos y sus valores:
  - `I = 1`, `V = 5`, `X = 10`, `L = 50`, `C = 100`, `D = 500`, `M = 1000`.
- El rango básico soportado es `1..3999`.

### 2. Casos aditivos
- Conversión sin notación sustractiva (solo sumas).
  - Ejemplos:
    - `2 → II`
    - `6 → VI`
    - `15 → XV`

### 3. Casos sustractivos
- Casos donde se utiliza notación sustractiva.
  - Ejemplos:
    - `4 → IV`
    - `9 → IX`
    - `40 → XL`
    - `90 → XC`
    - `400 → CD`
    - `900 → CM`

### 4. Reglas de repetición
- Reglas de repetición y restricciones:
  - `I`, `X`, `C`, `M` → máximo 3 veces seguidas.
  - `V`, `L`, `D` → no se repiten.
- Solo ciertas combinaciones de sustracción son válidas: (`IV`, `IX`, `XL`, `XC`, `CD`, `CM`).

### 5. Límite superior
- Definir el rango válido:
  - Valores menores a `1` o mayores a `3999` no son válidos.
- Se debe lanzar una excepción en caso de valores fuera de rango.

### 6. Ejemplos completos de conversión
- Ejemplos de conversión:
  - `1 → I`
  - `3 → III`
  - `9 → IX`
  - `58 → LVIII` (50 + 5 + 3)
  - `1994 → MCMXCIV` (1000 + 900 + 90 + 4)

### 7. Casos de error (opcional, si se quiere robustez extra)
- Errores comunes a manejar:
  - `0`, negativos, o números mayores a `3999`.
  - Romanos inválidos (`IIII`, `VV`, `IL`, `XD`, etc.).
  - Cadenas vacías o con caracteres no válidos.

---

## Estrategia de desarrollo

- Implementar una clase `RomanNumerals` con:
  - `String toRoman(int number)`
  - (Opcional) `int fromRoman(String roman)`
- Construir la solución paso a paso con TDD:

  1. Casos básicos: `1 → I`, `2 → II`, `3 → III`.
  2. Casos con notación sustractiva: `4 → IV`, `9 → IX`.
  3. Decenas, centenas y miles (`X`, `XL`, `XC`, `C`, `CD`, `CM`, `M`).
  4. Casos compuestos (`58 → LVIII`, `1994 → MCMXCIV`).
  5. Casos límite (`0`, `4000`, inválidos).

### 9. Otras operaciones
- Implementar `fromRoman` (con validación).
- Método `isValidRoman(String roman)`.
- Extensión para números mayores a `3999` con notación especial.

---

## Enlaces de referencia

- [Coding Dojo – Roman Numerals](https://codingdojo.org/kata/RomanNumerals/)
