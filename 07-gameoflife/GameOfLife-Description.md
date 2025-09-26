
# Game of Life

El módulo Game of Life es una implementación de la kata basada en el autómata celular creado por John Conway.  
El ejercicio consiste en simular la evolución de una cuadrícula de celdas vivas y muertas siguiendo un conjunto de reglas simples.  
Es excelente para practicar **TDD (Test-Driven Development)**, diseño basado en reglas, y simulaciones iterativas.

---

## Objetivo

Crear un método que, dado un estado inicial de la cuadrícula, calcule el siguiente estado aplicando las reglas del juego de la vida.

---

## Requisitos principales

### 1. Reglas básicas
El universo del juego es una cuadrícula de celdas, cada una puede estar **viva** o **muerta**.  
La evolución ocurre en pasos discretos ("generaciones") aplicando simultáneamente las siguientes reglas a todas las celdas:

### 2. Subpoblación
- Una celda viva con **menos de 2 vecinos vivos** muere en la siguiente generación (por soledad).

### 3. Superpoblación
- Una celda viva con **más de 3 vecinos vivos** muere en la siguiente generación (por sobrepoblación).

### 4. Supervivencia
- Una celda viva con **2 o 3 vecinos vivos** permanece viva en la siguiente generación.

### 5. Reproducción
- Una celda muerta con **exactamente 3 vecinos vivos** se convierte en celda viva en la siguiente generación.

### 6. Ejemplo de evolución
Estado inicial (glider):

. # .
. . #

#

Estado siguiente:


. . .

.

. # #

. # .
. . #

#


### 7. Casos de error (opcional, si se quiere robustez extra)
- No se debe permitir cuadrícula nula.
- No se deben aceptar valores distintos a "viva" o "muerta".
- Los bordes pueden tratarse de diferentes formas:
  - Infinitos (espacio abierto).
  - Limitados (bordes mueren siempre).
  - Toroidal (la cuadrícula envuelve sobre sí misma).

---

## Estrategia de desarrollo

- Implementar una clase `GameOfLife` con:
  - `boolean[][] nextGeneration(boolean[][] grid)`

- Construir la solución paso a paso con TDD:
  1. Celda viva con 0 o 1 vecino muere.
  2. Celda viva con 2 o 3 vecinos sobrevive.
  3. Celda viva con más de 3 vecinos muere.
  4. Celda muerta con 3 vecinos vivos revive.
  5. Generalizar para cuadrículas completas.

### 9. Otras operaciones
- Extender para visualizar el juego en consola o interfaz gráfica.
- Implementar patrones clásicos como **glider**, **oscillator**, **block**.
- Soportar cuadrículas infinitas o de topología toroidal.

---

## Enlaces de referencia

- [Coding Dojo – Game of Life](https://codingdojo.org/kata/GameOfLife/)


