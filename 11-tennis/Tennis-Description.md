
# Tennis

El módulo Tennis es una implementación de la clásica kata que consiste en **simular el marcador de un partido de tenis**.  
Este ejercicio es excelente para practicar **TDD, lógica condicional y modelado de reglas de juego**.

---

## Objetivo

Crear una clase `TennisGame` que pueda registrar puntos y devolver el marcador actual en formato de tenis.

---

## Requisitos principales

### 1. Puntuación
- Puntos por juego: 0, 15, 30, 40
- Igualdad: `Deuce` si ambos jugadores tienen 40
- Ventaja: `Advantage Player1` o `Advantage Player2`

### 2. Juegos y sets
- No se requiere manejar sets completos, solo marcador de un juego individual.

### 3. Registro de puntos
- Método `wonPoint(String player)` para sumar un punto al jugador.
- Método `score()` para devolver marcador actual en formato string.

### 4. Ejemplos
- `Player1` 1 punto, `Player2` 0 → `15-0`
- `Player1` 3 puntos, `Player2` 3 puntos → `Deuce`
- `Player1` gana punto en Deuce → `Advantage Player1`
- `Player1` gana siguiente punto → `Win for Player1`

---

## Estrategia de desarrollo

- Implementar clase `TennisGame` con:
  - `void wonPoint(String player)`
  - `String score()`

- Construcción paso a paso con TDD:
  1. Registrar puntos individuales.
  2. Mostrar marcador simple.
  3. Implementar reglas Deuce y Advantage.
  4. Determinar ganador.

---

## Enlaces de referencia

- [Coding Dojo – Tennis](https://codingdojo.org/kata/Tennis/)