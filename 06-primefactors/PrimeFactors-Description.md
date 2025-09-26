
# Prime Factors

El módulo Prime Factors es una implementación de la clásica kata que consiste en **descomponer un número en sus factores primos**.  
Este ejercicio es excelente para practicar **TDD (Test-Driven Development)**, algoritmos simples e iterativos y la descomposición en problemas más pequeños.

---

## Objetivo

Crear un método `generate(int n)` que, dado un número entero `n`, devuelva una lista con sus factores primos ordenados.

---

## Requisitos principales

### 1. Reglas básicas
- Un número entero mayor que 1 puede descomponerse en el producto de números primos.
- El resultado debe expresarse como una lista ordenada de primos.

### 2. Caso base
- `1 → []` (el 1 no tiene factores primos).

### 3. Factor primo más pequeño
- Si el número es primo, la lista debe contener solo ese número.
  - Ejemplo: `2 → [2]`, `3 → [3]`.

### 4. Factores repetidos
- Si un número tiene varios factores iguales, deben repetirse en la lista.
  - Ejemplo: `4 → [2, 2]`, `9 → [3, 3]`.

### 5. Casos estándar
- `6 → [2, 3]`
- `8 → [2, 2, 2]`
- `12 → [2, 2, 3]`

### 6. Ejemplos completos
- `1 → []`
- `2 → [2]`
- `3 → [3]`
- `4 → [2, 2]`
- `5 → [5]`
- `6 → [2, 3]`
- `7 → [7]`
- `8 → [2, 2, 2]`
- `9 → [3, 3]`
- `10 → [2, 5]`

### 7. Casos de error (opcional, si se quiere robustez extra)
- No se deben aceptar números negativos.
- No se deben aceptar `0`.
- Se puede lanzar excepción en estos casos o devolver lista vacía según la implementación.

---

## Estrategia de desarrollo

- Implementar una clase `PrimeFactors` con:
  - `List<Integer> generate(int n)`

- Construir la solución paso a paso con TDD:
  1. Caso base → `1` devuelve `[]`.
  2. Descomposición de números primos simples.
  3. Manejar factores repetidos.
  4. Iterar hasta que el número sea 1.
  5. Validar casos límite.

### 9. Otras operaciones
- Optimizar el algoritmo usando división hasta la raíz cuadrada del número.
- Extender para descomponer listas completas de números.

---

## Enlaces de referencia

- [Coding Dojo – Prime Factors](https://codingdojo.org/kata/PrimeFactors/)
