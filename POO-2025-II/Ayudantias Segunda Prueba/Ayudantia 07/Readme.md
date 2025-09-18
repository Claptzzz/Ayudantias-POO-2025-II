# Septima Ayudantía

### Objetivos

* Comprender e implementar patron ***Singleton y Factory***.
* Resolución de problematicas.
* Comprender y analizar problemas complejos.

<img align="right" width=280px alt="Unicorn" src="https://media.tenor.com/V0OhYaTPcv8AAAAi/sleeping-wingman.gif" />

## Ejercicio 1

La Biblioteca Central es una biblioteca que necesita digitalizar su sistema de préstamos. La biblioteca maneja diferentes tipos de libros, usuarios con distintos perfiles, y necesita controlar los préstamos de manera eficiente. Te han contratado para crear un sistema simple pero funcional.

Por lo cual se te entregan los siguientes archivos txt:

***Libros.txt***

```
1;El Quijote;Miguel de Cervantes;Ficcion;disponible;FISICO
2;Java Programming;James Gosling;Programacion;prestado;DIGITAL
3;Cien Años de Soledad;Gabriel Garcia Marquez;Ficcion;disponible;FISICO
4;Clean Code;Robert Martin;Programacion;disponible;DIGITAL
```
***ID;Titulo;Autor;Categoria;Estado;TipoLibro***

***Usuarios.txt***

```
1;Ana Martinez;ESTUDIANTE;1;3
2;Carlos Lopez;PROFESOR;1;2;4
3;Maria Silva;PUBLICO;3
4;Pedro Gonzalez;ESTUDIANTE;2;4
```
***ID;Nombre;TipoUsuario;LibrosPrestados***

***Prestamos.txt***
```
1;2;1;15-09-2025;22-09-2025;activo
2;4;2;10-09-2025;17-09-2025;devuelto
3;1;3;16-09-2025;23-09-2025;activo
4;3;4;12-09-2025;19-09-2025;vencido
```
***ID;IDUsuario;IDLibro;FechaPrestamo;FechaVencimiento;Estado***

Ahora se te pide crear el siguiente menu:

````
========== BIBLIOTECA DIGITAL ==========
1) Ver información de libros
2) Ver información de usuarios  
3) Ver préstamos activos
4) Calcular promedio de días de préstamo
5) Salir
````

***Aclaraciones***

- Usar ArrayList para todas las colecciones
- Lectura simple de archivos al inicio
- Implementar solo las funcionalidades del menú básico