# Tercera Ayudantía

### Objetivos
- Repasar Clases y Objetos básicos.
- Comprender la manipulación de Objetos con referencias.
- Implementar Vectores estáticos y Matrices.
- Aplicar lectura de archivos de texto.

<img align="right" width=260px alt="Unicorn" src="https://media.tenor.com/CI7msUZXbooAAAAj/computer-pressing.gif" />

## Ejercicio 1
Carlos, Andrea y Felipe son estudiantes que están desarrollando un sistema de gestión militar para su proyecto de programación. El sistema debe manejar información de soldados y simular formaciones tácticas en un campo de batalla.

**Para esto cuentan con el siguiente archivo .txt**
```
Juan_Perez Infanteria 25 1500 Madrid 2 3
Ana_Garcia Artilleria 30 2300 Barcelona 5 7
Pedro_Lopez Infanteria 22 800 Valencia 1 8
```
Nombre;Especialidad;Edad;Experiencia;CiudadOrigen;PosicionX;PosicionY

**Se te pide crear un sistema que cumpla los siguientes requisitos:**

```
Menú Principal:

1. Cargar Soldados - Leer archivo soldados.txt
2. Mostrar Todos - Listar soldados con su información completa
3. Buscar por Especialidad - Filtrar soldados por tipo
4. Generar Formación - Mostrar mapa táctico 10x10
5. Estadísticas - Mostrar promedios de edad y experiencia
6. Salir
```

---

## Ejercicio 2
Sofia y Matías son organizadores de esports que necesitan un sistema para gestionar torneos de League of Legends. Deben manejar equipos, jugadores y resultados de partidas en una matriz de enfrentamientos.

**Para esto cuentan con los siguientee archivos .txt**
- equipos.txt
```
TeamSpirit;5;Europa;2019
G2Esports;5;Europa;2013  
SKT_T1;5;Asia;2012
```
NombreEquipo;NumJugadores;Region;AñoFundacion

- jugadores.txt
```
TeamSpirit;Collapse;Top;Gnar;150
TeamSpirit;TORONTOTOKYO;Jungle;Graves;220
G2Esports;Caps;Mid;Azir;180
SKT_T1;Faker;Mid;LeBlanc;320
```
Equipo;NickJugador;Posicion;CampeonFavorito;KillsPromedio

**Se te pide crear un sistema que cumpla los siguientes requisitos:**

```
Menú Principal:

1. Cargar Datos - Lee equipos.txt y jugadores.txt
2. Mostrar Equipos - Lista completa con jugadores
3. Buscar Jugador - Encuentra jugador por nickname
4. Generar Torneo - Crea matriz de enfrentamientos 8x8
5. Mostrar Tabla - Visualiza resultados del torneo
6. Estadísticas - Equipo más fuerte y promedios generales
7. Filtrar por Región - Muestra equipos de una región específica
8. Salir

```
