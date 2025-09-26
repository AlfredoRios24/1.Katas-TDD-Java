# 1.Katas-TDD-Java
Este proyecto contiene una colección de Katas de programación implementadas en Java utilizando TDD (Test-Driven Development) como práctica principal.
El objetivo es reforzar los conceptos de desarrollo guiado por pruebas, adquirir bases sólidas en testing y mejorar como desarrollador mediante ejercicios iterativos y enfocados en la calidad del código.

🚀 Estructura del proyecto

Este repositorio está organizado como un proyecto multimódulo con Maven.
Cada Kata se encuentra en un módulo independiente con su propia implementación y pruebas unitarias.

📂 Katas incluidas

- FizzBuzz

- String Calculator

- Bowling Game

- Roman Numerals

- Leap Year

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



- Prime Factors

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


- Game of Life

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




- Bank OCR

# Bank OCR

El módulo Bank OCR es una implementación de la kata clásica que consiste en leer números escritos en una representación de caracteres de 7 segmentos (similar a un display digital).  
El reto está en interpretar correctamente los dígitos y validar la integridad de los números.  
Es excelente para practicar **TDD (Test-Driven Development)**, parsing de cadenas y validaciones de reglas de negocio.

---

## Objetivo

Crear un programa que lea números de una cuenta bancaria escritos en formato OCR (3 líneas por número)  
y los traduzca a un valor numérico, validando si el número es legible y correcto.

---

## Requisitos principales

### 1. Lectura básica
- Los números se representan en un grid de **3 líneas x 27 caracteres** (cada dígito ocupa una matriz de 3x3).
- Cada bloque de 9 dígitos representa un número de cuenta de 9 cifras.

### 2. Reconocimiento de dígitos
- Implementar el reconocimiento de los 10 dígitos (0–9) según sus patrones en 3x3.
- Ejemplo:

| | | | |||| |_ |||||
|| || | | ||| ||| _|

Se traduce en: `123456789`

### 3. Validación de cuenta
- Cada número de cuenta debe ser validado mediante **checksum**:  
  `(d1*9 + d2*8 + ... + d9*1) % 11 == 0`
- Si no pasa la validación, se considera **inválido**.

### 4. Errores de lectura
- Si un dígito no puede ser reconocido, se sustituye por `?`.
- Una cuenta con dígitos ilegibles debe marcarse como **ILL**.

### 5. Errores de validación
- Si todos los dígitos son reconocidos pero el checksum falla, la cuenta se marca como **ERR**.

### 6. Ejemplo de ejecución
Entrada OCR:

_  _     _  _  _  _  _
| | |||| |_ |||||
||_ | | ||| ||| _|

Salida:
123456789


### 7. Casos de error (opcional, si se quiere robustez extra)
- No se debe aceptar input con formato inválido (menos de 3 líneas o ancho incorrecto).
- Posibilidad de sugerir correcciones si hay un dígito ilegible (ejemplo: heurísticas).

---

## Estrategia de desarrollo

- Implementar una clase `BankOCR` con:
    - `String parseEntry(String[] entry)` → interpreta un número en OCR.
    - `boolean isValidAccount(String account)` → valida con checksum.

- Construir la solución paso a paso con TDD:
    1. Reconocer un único dígito.
    2. Reconocer todos los dígitos del 0 al 9.
    3. Leer un número completo de 9 dígitos.
    4. Validar con checksum.
    5. Manejar casos `ILL` y `ERR`.

### 9. Otras operaciones
- Implementar autocorrección de cuentas ambiguas (opcional).
- Permitir lectura de múltiples cuentas desde un fichero.
- Exportar resultados en un formato estándar.

---

## Enlaces de referencia

- [Coding Dojo – Bank OCR](https://codingdojo.org/kata/BankOCR/)


- Mars Rover

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

- Kata Log

# Kata Log

El módulo Kata Log es una implementación de la clásica kata que consiste en **registrar y filtrar eventos o mensajes en un sistema de log**.  
Este ejercicio es excelente para practicar **TDD, estructuras de datos y filtrado de información**.

---

## Objetivo

Crear una clase `KataLog` que pueda almacenar mensajes, filtrar por nivel y devolver logs en formato ordenado.

---

## Requisitos principales

### 1. Niveles de log
- INFO, WARNING, ERROR

### 2. Registro
- Añadir un mensaje con un nivel determinado.
- Ejemplo: `log.add("ERROR", "Archivo no encontrado")`

### 3. Filtrado
- Obtener mensajes de un nivel específico.
- Ejemplo: `log.getLogs("ERROR") → ["Archivo no encontrado"]`

### 4. Orden
- Los logs se deben devolver en orden de inserción.

### 5. Ejemplos
- `add("INFO","Inicio")`
- `add("WARNING","Espacio bajo")`
- `getLogs("WARNING") → ["Espacio bajo"]`

---

## Estrategia de desarrollo

- Implementar clase `KataLog` con:
  - `void add(String level, String message)`
  - `List<String> getLogs(String level)`

- Construcción paso a paso con TDD:
  1. Registrar un mensaje.
  2. Recuperar logs por nivel.
  3. Mantener orden de inserción.
  4. Validar niveles inválidos.

---

## Enlaces de referencia

- [Coding Dojo – Kata Log](https://codingdojo.org/kata/KataLog/)

- Tennis

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

🧪 Enfoque de desarrollo

Cada módulo se desarrolla siguiendo los principios de TDD:

- Escribir una prueba que falle (Red)

- Escribir el código mínimo para que la prueba pase (Green)

- Refactorizar el código manteniendo las pruebas en verde (Refactor)

- Esto asegura un código simple, limpio y bien probado.


▶️ Ejecución de tests

Para ejecutar todas las pruebas de los módulos:

    -- mvn test


Para ejecutar los tests de un módulo específico:

    -- mvn test -pl nombreDelModulo

📚 Objetivo

Este repositorio está pensado como una herramienta de aprendizaje.
La meta no es solo resolver las Katas, sino también:

- Practicar TDD de manera disciplinada

- Mejorar la capacidad de refactorización

- Comprender patrones de diseño simples aplicados en ejercicios prácticos


