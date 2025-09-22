# String Calculator

El módulo **String Calculator** es una implementación de la clásica kata que guía paso a paso en la creación de un calculador que recibe un **String como entrada**.  
Este ejercicio es ideal para practicar **TDD (Test-Driven Development)**, refactoring incremental y manejo de errores.

---

## Objetivo

Crear un método `add(String numbers)` que:

- Sume números contenidos en un string.
- Maneje distintos delimitadores.
- Detecte y reporte errores de entrada.
- Sea extensible para futuras operaciones (como `multiply`).

---

## Requisitos principales

### 1. Suma simple
- El método `add` puede recibir 0, 1 o 2 números separados por coma.
- Una cadena vacía devuelve `"0"`.
- Ejemplos:
    - `""` → `"0"`
    - `"1"` → `"1"`
    - `"1.1,2.2"` → `"3.3"`

### 2. Múltiples números
- Permitir cualquier cantidad de números separados por comas.

### 3. Nueva línea como separador
- Se permiten saltos de línea (`\n`) como separadores:
    - `"1\n2,3"` → `"6"`
- Validar errores si la nueva línea aparece en posiciones incorrectas:
    - `"175.2,\n35"` → `"Number expected but '\n' found at position 6."`

### 4. Separador final
- No permitir que la entrada termine con un separador:
    - `"1,3,"` → `"Number expected but EOF found."`

### 5. Separadores personalizados
- Permitir delimitadores personalizados usando:  
- Ejemplos:
- `"//;\n1;2"` → `"3"`
- `"//|\n1|2|3"` → `"6"`
- `"//sep\n2sep3"` → `"5"`
- Validar errores de separador incorrecto:
- `"//|\n1|2,3"` → `"'|' expected but ',' found at position 3."`

### 6. Números negativos
- No se permiten negativos.
- Retornar mensaje con todos los negativos encontrados:
- `"-1,2"` → `"Negative not allowed: -1"`
- `"2,-4,-5"` → `"Negative not allowed: -4, -5"`

### 7. Múltiples errores
- Retornar todos los errores detectados, separados por líneas:
- `"-1,,2"` →
  ```
  Negative not allowed: -1
  Number expected but ',' found at position 3.
  ```
- `"-1,,-2"` →
  ```
  Negative not allowed: -1
  Number expected but ',' found at position 3.
  Negative not allowed: -2
  ```

### 8. Gestión de errores avanzada
- Internamente se puede implementar `add` retornando un número y luego generar los mensajes de error.
- Opciones: excepciones, monads/maybe, estructuras tipo Go, códigos POSIX, etc.

### 9. Otras operaciones
- Posible extensión: implementar `multiply` siguiendo las mismas reglas.

---

## Enlaces de referencia

- [Coding Dojo – String Calculator](https://codingdojo.org/kata/StringCalculator/)
