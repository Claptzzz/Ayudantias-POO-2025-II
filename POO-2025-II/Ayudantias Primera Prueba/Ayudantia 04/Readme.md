# Cuarta Ayudantía

### Objetivos

* Implementar colecciones.
* Resolución de problematicas.
* Comprender y analizar problemas complejos.

<img align="right" width=280px alt="Unicorn" src="https://media.tenor.com/V0OhYaTPcv8AAAAi/sleeping-wingman.gif" />

## Ejercicio 1

<a href="https://www.twitch.tv/perr0pelud0" title="Bora PerroPeludo">perr0pelud0</a> es un emergente Streamer el cuál disfruta de hacer contenido jugando videojuegos, pero ultimamente se ha visto complicado organizando sus estadisticas. Por lo cual decides ayudarlo a recopilar informacion respecto a sus viewers y los comentarios que emiten.

Por lo cual se te entregan los siguientes archivos txt:

***Streams.txt***

```
1;Ranked Radiant LAS;15-09-2025;Valorant;165;4
2;miau;17-09-2025;Hollow Knight Silksong;134;3
3;Wof Bark;16-09-2025;Valorant;220;5
```
***ID;Titulo;Fecha;Categoría;Duración;ViewersPromedio***

***Viewers.txt***

```
1;Claptzzz;1;2;3
2;Koshao;1;2;3
3;Jooseto;1;3
4;Tobaal;2;3
5;IDregg;1;3
```
***ID;Nombre;StreamsPresentes...***

***Comentarios.txt***

```
1;1;2;top 1 de mi corazon papu
1;5;12;como pinai esa
1;1;15;remontada insana
1;2;32;lo que juega perro peludo
2;3;10;hoy puro no hit
3;5;120;me conecto altiro
3;4;198;la mentira mas grande
3;1;110;su tft mejor
2;2;78;parkour insano
```
***IDStream;IDViewer;minuto;comentario***

Ahora se te pide crear el siguiente menu:

````
1) Ver info Streams
2) Ver info Viewers
3) Mostrar comentarios por Stream
4) Agregar comentario a un Stream
5) Salir
````

***Aclaraciones***

* Debe usar ArrayList.
* En el txt Viewers cada perfil ve una cantidad X de Streams.
