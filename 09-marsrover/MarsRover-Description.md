
# Mars Rover

El módulo Mars Rover es una implementación de la clásica kata que consiste en **simular el movimiento de un rover sobre una cuadrícula con instrucciones de giro y avance**.  
Este ejercicio es excelente para practicar **TDD, control de dirección y manejo de coordenadas**.

---

## Objetivo

Crear una clase `MarsRover` que pueda interpretar comandos de movimiento (`L`, `R`, `M`) y devolver la posición final del rover en una cuadrícula.

---

## Requisitos principales

### 1. Cuadrícula
- La superficie es un tablero de dimensiones definidas (por ejemplo, 5x5).
- Coordenadas `(x, y)` comienzan en `(0,0)`.

### 2. Posición inicial
- El rover comienza en una posición `(x, y)` y orientación (`N`, `E`, `S`, `W`).

### 3. Comandos
- `L` → girar 90° a la izquierda.
- `R` → girar 90° a la derecha.
- `M` → avanzar una unidad en la dirección actual.

### 4. Ejemplo
- Posición inicial: `(1,2,N)`
- Comandos: `"LMLMLMLMM"`
- Posición final: `(1,3,N)`

### 5. Restricciones
- No salirse de los límites de la cuadrícula.
- Ignorar o lanzar error si se da un comando inválido.

---

## Estrategia de desarrollo

- Implementar clase `MarsRover` con:
  - `void execute(String commands)`
  - `String getPosition()`

- Construcción paso a paso con TDD:
  1. Mover hacia adelante en dirección `N`.
  2. Girar izquierda y derecha.
  3. Combinar secuencias de comandos.
  4. Validar límites de la cuadrícula.

---

## Enlaces de referencia

- [Coding Dojo – Mars Rover](https://codingdojo.org/kata/MarsRover/)