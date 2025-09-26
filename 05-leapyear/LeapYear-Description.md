
# Leap Year

El módulo Leap Year es una implementación de la clásica kata que consiste en **determinar si un año es bisiesto o no**.  
Este ejercicio es excelente para practicar **TDD (Test-Driven Development)** y aplicar reglas de negocio simples pero con excepciones importantes.

---

## Objetivo

Crear un método `isLeapYear(int year)` que determine si un año es bisiesto siguiendo las reglas oficiales del calendario gregoriano.

---

## Requisitos principales

### 1. Reglas básicas
- Un año es bisiesto si es divisible por 4.
- Sin embargo, hay excepciones que deben cumplirse.

### 2. Regla de los siglos
- Si un año es divisible por 100, **no** es bisiesto.
  - Ejemplo: `1900 → false`.

### 3. Regla de los 400
- Si un año es divisible por 400, **sí** es bisiesto.
  - Ejemplo: `2000 → true`.

### 4. Casos estándar
- `1996 → true` (divisible por 4).
- `2001 → false` (no divisible por 4).
- `2000 → true` (divisible por 400).
- `1900 → false` (divisible por 100 pero no por 400).

### 5. Casos límite
- Se puede asumir que el año es un entero positivo.
- Opcional: definir qué ocurre si se pasa un año negativo o `0` (fuera del calendario gregoriano).

### 6. Ejemplos completos
- `1600 → true`
- `1700 → false`
- `1800 → false`
- `2000 → true`
- `2024 → true`
- `2023 → false`

### 7. Casos de error (opcional, si se quiere robustez extra)
- Lanzar excepción si el año es `<= 0`.
- Validar tipos de entrada no numéricos (si se amplía la interfaz).

---

## Estrategia de desarrollo

- Implementar una clase `LeapYear` con:
  - `boolean isLeapYear(int year)`

- Construir la solución paso a paso con TDD:
  1. Año divisible por 4 → verdadero.
  2. Año divisible por 100 → falso.
  3. Año divisible por 400 → verdadero.
  4. Combinar las tres reglas.
  5. Añadir casos límite (años negativos, 0).

### 9. Otras operaciones
- Extender para validar rangos de años (ejemplo: `1582` inicio del calendario gregoriano).
- Añadir soporte para validaciones masivas (lista de años).

---

## Enlaces de referencia

- [Coding Dojo – Leap Year](https://codingdojo.org/kata/LeapYears/)

