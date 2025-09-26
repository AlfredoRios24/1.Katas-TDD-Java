
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

