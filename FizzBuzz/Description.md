# FizzBuzz

El módulo **FizzBuzz** es una implementación de la clásica kata que enseña los principios de **TDD (Test-Driven Development)** y desarrollo incremental.  
Es ideal para practicar:

- Refactoring paso a paso.
- Implementación guiada por tests.
- Lógica condicional y manejo de reglas combinadas.

---

## Objetivo

Crear un programa o función que imprima los números del **1 al 100** siguiendo estas reglas:

1. Si el número es múltiplo de 3, imprimir `"Fizz"`.
2. Si el número es múltiplo de 5, imprimir `"Buzz"`.
3. Si el número es múltiplo de **3 y 5**, imprimir `"FizzBuzz"`.
4. Si no cumple ninguna de las anteriores, imprimir el número.

---

## Ejemplo de salida


- 1
- 2
- Fizz
- 4
- Buzz
- Fizz
- 7
- 8
- Fizz
- Buzz
- 11
- Fizz
- 13
- 14
- FizzBuzz
- 16
- 17
- Fizz
- 19
- Buzz
- ... hasta 100


---

## Reglas avanzadas (Etapa 2)

Se agregan nuevas reglas para números “efervescentes”:

1. Un número es **Fizz** si:
    - Es divisible por 3 **o**
    - Contiene el dígito 3.

2. Un número es **Buzz** si:
    - Es divisible por 5 **o**
    - Contiene el dígito 5.

3. Combinaciones:
    - `"FizzBuzz"` si cumple reglas de Fizz y Buzz simultáneamente.
    - `"FizzBuzzBuzz"` si hay concatenaciones de reglas múltiples.

**Ejemplos:**

- `53` → `"FizzBuzz"` (contiene 5 y 3)
- `35` → `"FizzBuzzBuzz"` (contiene 3 y 5 y es divisible por 5)

---

## Enlaces de referencia

- [Coding Dojo – FizzBuzz](https://codingdojo.org/kata/FizzBuzz/)

