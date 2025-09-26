
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