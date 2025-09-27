# Ayudantia Intensiva

### Objetivos

* Volverse un maestro de la programación orientada a objetos.

<img align="right" width=280px alt="Unicorn" src="https://media.tenor.com/IppXYm9PIwIAAAAi/trouble-trouble-the-cat.gif" />

## Ejercicio 1

Valorant es un juego que ha agarrado mucho vuelo en los Esports estos ultimos años, cada cierto tiempo se desarrollan competencias llamadas Premier, donde varios equipos compiten en una llave buscando la victoria. 

Se te pide generar un programa que maneje lo siguiente:

* En el juego hay muchas ***Premier***.
* Una ***Premier*** tiene muchos ***Equipos***.
* Un ***Equipo*** tiene 5 ***Jugadores***.

Para lo cual tienes los siguientes txt:

***Premier.txt***

````
W1;Haven
W2;Corrode
W3;Lotus
W4;Ascent
W5;Sunset
W6;Bind
W7;Abyss
PLAYOFFS;IceBox
````
***ID;Mapa***

***Equipos.txt***

````
Chungungos;W1;W2;W3;W5;W7;PLAYOFFS
DeportesVallenar;W2;W3;W5;W7;PLAYOFFS
Daniloy4Randoms;W2;W1;W5
DinoGuys;W7;W2;W1
Chimuelitos;W1
foo;W1;W2;W3;W4;W5;W6;W7;PLAYOFFFS
````
***Nombre;PremieresJugadas....***

***Jugadores.txt***

````
Luxiano;Chungungos
Josseto;DeportesVallenar
Clapt;DeportesVallenar
Tobaal;Chungungos
PerroPeludo;DeportesVallenar
````
***Nombre;Equipo***

Se necesita extraer informacion y poder modificarla, se te pide generar un menu que permita hacer lo siguiente:

````
1) Mostrar las Premier registradas
2) Mostrar todos los equipos existentes
3) Crear una Premier
4) Agregar un equipo a una Premier
5) Crear un equipo
6) Modificar un equipo
7) Añadir un jugador
8) Salir
````