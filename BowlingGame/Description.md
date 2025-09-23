# Bowling Game

El módulo Bowling Game es una implementación de la clásica kata que consiste en simular una partida de bolos y calcular la puntuación final.
Este ejercicio es excelente para practicar TDD (Test-Driven Development), diseño incremental y trabajo con reglas de negocio más complejas.
---

## Objetivo

Crear un método score() que, a partir de los lanzamientos de una partida, 
calcule el marcador total de un juego de bolos siguiendo las reglas oficiales.
---

## Requisitos principales

### 1. Juego Básico
- Un juego completo tiene 10 frames.

- En cada frame el jugador puede lanzar la bola hasta dos veces para derribar un máximo de 10 bolos.

- La puntuación de cada frame es la suma de los bolos derribados, más posibles bonificaciones por spares y strikes.

### 2.Partida sin strikes ni spares
- Si en cada frame se derriban menos de 10 bolos en dos lanzamientos, la puntuación es simplemente la suma de todos los bolos.

    -- Ejemplo: roll(3, roll(4)) → 7 puntos en ese frame.

### 3. Spare
- Un spare ocurre cuando se derriban los 10 bolos en dos lanzamientos dentro del mismo frame.

- El frame se puntúa con 10 más los bolos del siguiente lanzamiento.

  -- Ejemplo: roll(5), roll(5) seguido de roll(3) → 10 + 3 = 13 puntos para ese frame.

### 4. Strike
- Un strike ocurre cuando se derriban los 10 bolos en el primer lanzamiento del frame.

- El frame se puntúa con 10 más los bolos de los dos siguientes lanzamientos.

  -- Ejemplo: roll(10) seguido de roll(3), roll(4) → 10 + 3 + 4 = 17 puntos para ese frame.

### 5. Frame 10 (último frame)
- Si en el décimo frame se hace spare o strike, el jugador recibe lanzamientos extra:

    - Spare → 1 lanzamiento extra.

    - Strike → 2 lanzamientos extra.

- Estos lanzamientos extra solo sirven para calcular la bonificación.

### 6. Ejemplo de partida completa
- Partida con todos lanzamientos de 1 → 20 puntos.

- Partida con todos strikes (perfect game) → 300 puntos.

- Partida: roll(5), roll(5) (spare), seguido de roll(3) → marcador inicial: 13."`

### 7. Casos de error (opcional, si se quiere robustez extra
- No se deben permitir más de 10 bolos en un frame (excepto en strikes/spares con bonificación).

- No se deben permitir más de 10 frames.

- Los lanzamientos extra en el frame 10 solo son válidos en caso de spare/strike
  ```

## Estrategia de desarroll
- Implementar una clase BowlingGame con:

  - void roll(int pins) → registrar un lanzamiento.

  - int score() → calcular el marcador total.

- Construir la solución paso a paso con TDD:

  1. Todos ceros → marcador 0.

  2. Todos unos → marcador 20.

  3. Casos simples de spare.

  4. Casos simples de strike.

  5. Partida perfecta (300).

  6. Manejo correcto del décimo fram.

### 9. Otras operaciones
- Posible extensión: implementar `multiply` siguiendo las mismas reglas.

---

## Enlaces de referencia

- [Coding Dojo – Bowling](https://codingdojo.org/kata/Bowling//)
