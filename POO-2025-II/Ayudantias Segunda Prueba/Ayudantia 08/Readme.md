# Octava Ayudantía

### Objetivos

* Comprender e implementar patrones ***Visitor y Strategy***.

<img align="right" width=280px alt="Library" src="https://media.tenor.com/V0OhYaTPcv8AAAAi/reading-books.gif" />

## Ejercicio 1

Una tienda online necesita un sistema flexible para calcular precios con diferentes descuentos y generar reportes variados. El sistema debe permitir cambiar estrategias de descuento dinámicamente y aplicar diferentes operaciones sobre los productos sin modificar sus clases.

Por lo cual se te entregan los siguientes archivos txt:

***Productos.txt***

```
1;Laptop Gaming;1200000;ELECTRONICO;5
2;Camisa Polo;35000;ROPA;15
3;Cafetera Express;180000;HOGAR;8
4;Libro Java;25000;LIBRO;20
```
***ID;Nombre;PrecioBase;Categoria;Stock***

***Clientes.txt***

```
1;Juan Perez;REGULAR;1;3
2;Maria Lopez;VIP;2;4
3;Carlos Silva;ESTUDIANTE;1;2;4
```
***ID;Nombre;TipoCliente;ProductosComprados...***

Ahora se te pide crear el siguiente menu:

````
========== TIENDA ONLINE - CALCULADORA DE PRECIOS ==========
1) Gestión de Productos
   a) Ver todos los productos
   b) Calcular precio con descuento
   c) Cambiar estrategia de descuento
   
2) Operaciones con Visitor
   a) Calcular impuestos de todos los productos
   b) Generar reporte por categorías
   c) Validar stock disponible
   
3) Simulación de Compra
   a) Seleccionar productos
   b) Aplicar descuento según cliente
   c) Mostrar total con impuestos
   
4) Salir
````

***Aclaraciones***

- El sistema debe permitir cambiar estrategias de descuento sin reiniciar
- Los visitors deben poder aplicarse a todos los productos de forma iterativa
- Usar ArrayList para manejar colecciones
- Implementar al menos 3 estrategias diferentes y 3 visitors
- Demostrar el polimorfismo en ambos patrones