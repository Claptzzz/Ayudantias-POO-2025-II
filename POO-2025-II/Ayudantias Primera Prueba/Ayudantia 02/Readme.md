# Segunda Ayudantía

### Objetivos

* Repasar Clases y Objetos.
* Comprender la manipulación de Objetos.
* Implementar Vectores.

<img align="right" width=260px alt="Unicorn" src="https://media.tenor.com/CI7msUZXbooAAAAj/computer-pressing.gif" />

## Ejercicio 0

Teamfight Tactics es un juego dinamico de estrategia que ha revolucionado el estilo de juego. Este consiste en un tablero tamaño NxM en los cuales se pueden posicionar de manera estrategica nuestros personajes para que luchen contra el tablero enemigo.

En esta ocasión nuestra tarea es simple, leer un archivo `Campeones.txt` que contiene el siguiente formato:

***Primera Linea*** `N;M;S`

***S lineas siguientes*** `ID;Nombre;X;Y;Vida;Damage;Defensa`

***N corresponde a las filas de la matriz, M a las columnas, y S correponde a la cantidad de campeones que se deben leer en el txt.***

***Donde X corresponde a su pocisión en el eje X del tablero e Y en su posición en el eje Y del tablero.***

Se te pide generar un programa con el siguiente menu:

```
1. Imprimir Matriz
2. Info Campeon
3. Salir
```

Donde debemos ser capaces de imprimir la matriz con el nombre de los campeones para ser capaces de acceder a la información de estos, ya sea por su nombre o ID.

## Ejercicio 1

Catalina, Francisco y Martin son grandes amigos los cuales disfrutan mucho de programar juntos, pero tambien suelen jugar "Risk of Rain 2" en su tiempo libre, el cual es un juego donde existen diferentes personajes y tanto Catalina como Francisco y Martin se especializan en un personaje. Por lo cual se te pide generar un codigo capaz de leer un txt `Personajes.txt` que contiene el siguiente formato:

`NombreJugador;Personaje;TiempoDeJuego;DañoRealizado`

Debes almacenar la información en una clase e imprimirla en un formato legible utilizando sus metodos get o toString.

## Ejercicio 2 (Desafio Mayor!!)

Tobal es un gran fan de Monster Hunter, por lo cuál le gusta utilizar la mayor parte de su tiempo realizando cacerías, pero en cada una debe pensar estrategicamente que arma utilizar dependiendo del mounstruo que cazara, por lo cuál decide contratar a los estudiantes de POO para que puedan realizar un programa que evalue que arma utilizar. Debes leer dos archivos txt `Monster.txt` `Armas.txt` que contienen los siguientes formatos:

* Monster.txt

`NombreMonster;Debilidad`
* Armas.txt

`NombreDelArma;Tipo`

Debes crear un Menu con dos opciones:
```
1. Evaluar
2. Salir
```

En caso de evaluar se deben imprimir los mounstruos disponibles y permitir seleccionar uno para cazar, luego se deben imprimir todas las armas que tengan ventaja contra el objetivo seleccionado.

***Aclaración***
* El programa solo debe cerrarse cuando el usuario decida salir.
* La debilidad de un mounstruo es dependiendo del tipo de arma.
* Debe almacenar la información en vectores.