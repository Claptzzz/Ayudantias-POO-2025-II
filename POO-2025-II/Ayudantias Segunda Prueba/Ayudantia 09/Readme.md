# Novena Ayudantía

### Objetivos

* Implementar interfaces gráficas de usuario (GUI) en Java Swing.
  
<img align="right" width=280px alt="GUI" src="https://media.tenor.com/V0OhYaTPcv8AAAAi/computer-typing.gif" />

## Ejercicio 1: Sistema de Gestión de Estudiantes - GUI

Crear una aplicación de escritorio con interfaz gráfica para gestionar información de estudiantes universitarios. La aplicación debe permitir registrar estudiantes, consultar información y generar reportes básicos, todo a través de una interfaz visual intuitiva.

Por lo cual se te entregan los siguientes archivos txt:

***Estudiantes.txt***

```
12345678;Juan Pérez;Ingeniería Informática;3;7.5
87654321;María González;Psicología;2;8.2
11223344;Carlos López;Administración;4;6.8
55667788;Ana Torres;Derecho;1;9.1
```
***RUT;Nombre;Carrera;Semestre;PromedioNotas***


Ahora se te pide que el sistema pueda hacer lo siguiente:

````
========== TIENDA ONLINE - CALCULADORA DE PRECIOS ==========
* Cargar datos desde archivo al iniciar
* Agregar nuevo estudiante
* Filtrar estudiantes por nombre
* Generar estadísticas básicas
* Limpiar formulario
````

Ejemplo de pestaña de registor:
```
┌─────────────────────────────────┐
│ RUT:        [_______________]   │
│ Nombre:     [_______________]   │
│ Carrera:    [_______________]   │
│ Semestre:   [_______________]   │  
│ Promedio:   [_______________]   │
│                                 │
│     [Agregar]  [Limpiar]        │
└─────────────────────────────────┘
```