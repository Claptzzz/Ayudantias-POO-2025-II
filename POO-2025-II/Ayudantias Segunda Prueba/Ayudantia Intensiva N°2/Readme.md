# Ayudantía Intensiva - Sistema de Gestión de Torneos de eSports

**Objetivos**
- Dominar la programación orientada a objetos en Java
- Implementar patrones de diseño avanzados (Singleton, Factory, Visitor y Strategy)
- Desarrollar interfaces gráficas interactivas

<img align="right" width=280px alt="Gaming" src="https://media.tenor.com/IppXYm9PIwIAAAAi/trouble-trouble-the-cat.gif" />

## Ejercicio: Sistema de Gestión de Torneos de League of Legends
League of Legends es uno de los juegos más populares en el mundo de los eSports. Cada temporada se organizan múltiples torneos donde equipos profesionales y amateur compiten por la gloria. Se necesita un sistema completo que gestione torneos, equipos, jugadores y sus estadísticas.

Se te pide crear un programa en Java que maneje lo siguiente:

#### Estructura del Sistema
- El sistema puede tener múltiples Torneos.
- Un Torneo tiene muchos Equipos participantes.
- Un Equipo tiene 5 Jugadores (roles: Top, Jungle, Mid, ADC, Support).
- Cada Jugador tiene estadísticas individuales.

---

#### Archivos de Entrada
El sistema debe leer los siguientes archivos TXT al iniciar:

**Torneos.txt**
```
T001;Spring Split 2024;ACTIVO;Summoner's Rift;BO3
T002;MSI 2024;FINALIZADO;Summoner's Rift;BO5
T003;Worlds 2024;PROXIMO;Summoner's Rift;BO5
T004;Rift Rivals;ACTIVO;Summoner's Rift;BO1
T005;All-Stars;PROXIMO;Howling Abyss;BO3
```
**ID;Nombre;Estado;Mapa;FormatoPartidas**

**Equipos.txt**
```
T9;T001;T002;T004
G2 Esports;T001;T002;T003;T004
Fnatic;T001;T003
Cloud9;T002;T004
T1;T001;T002;T003;T004;T005
DRX;T003;T005
Team Liquid;T001;T004
```
**NombreEquipo;TorneosParticipados...**

**Jugadores.txt**
```
Faker;T1;Mid;1250;8.5;3.2;AGRESIVO;ASESINO
Caps;G2 Esports;Mid;980;7.8;2.9;EQUILIBRADO;HIBRIDO
Showmaker;DRX;Mid;1050;8.0;3.5;AGRESIVO;MAGO
Perkz;Cloud9;Mid;890;7.5;3.0;EQUILIBRADO;HIBRIDO
Zeus;T1;Top;760;6.5;2.1;AGRESIVO;45;78
Broken Blade;G2 Esports;Top;720;6.8;2.5;EQUILIBRADO;38;72
Wunder;Fnatic;Top;650;6.2;2.8;DEFENSIVO;52;85
Oner;T1;Jungle;620;5.2;4.8;EQUILIBRADO;67;142
Jankos;G2 Esports;Jungle;580;4.9;5.1;AGRESIVO;54;128
Inspired;Cloud9;Jungle;610;5.5;4.5;DEFENSIVO;71;135
Gumayusi;T1;ADC;1340;9.8;1.5;AGRESIVO;9.2;1250
Rekkles;Fnatic;ADC;1100;9.2;1.8;DEFENSIVO;8.8;1180
Hans Sama;Team Liquid;ADC;1050;8.9;2.0;EQUILIBRADO;8.5;1150
Keria;T1;Support;380;2.5;8.9;DEFENSIVO;45;28;875.5
Mikyx;G2 Esports;Support;320;2.8;7.5;EQUILIBRADO;42;25;820.3
Hylissang;Fnatic;Support;290;2.3;8.2;AGRESIVO;38;22;790.8
CoreJJ;Team Liquid;Support;350;2.6;8.0;EQUILIBRADO;48;30;910.2
```
- Atributos generales: **Nickname;Equipo;Rol;Kills;KDA;MuertesPorPartida;EstiloJuego**
- Atributos Específicos Top: **TeleportUsage;Resistencia**
- Atributos Específicos Jungle: **ObjetivosAsegurados;GanksExitosos**
- Atributos Específicos Mid: **TipoMid**
- Atributos Específicos ADC: **FarmPorMinuto;DañoPorSegundo**
- Atributos Específicos Support: **WardsColocados;WardsEliminados;UtilidadProporcionada**

---

#### Requerimientos del sistema
- Implementar una clases `Sistema` que gestione toda la aplicación.
- Crear una clase a la cual delegar la creación de jugadores según el rol.
- Implementar un sistema de visitantes para generar reportes estadísticos:
  - `EstadisticasVisitor`: Calcula promedios de KDA, kills, muertes por equipo.
  - `ReporteDetalladoVisitor`: Genera reportes completos de torneos/equipos/jugadores.
- Implementar diferentes estrategias de ordenamiento:
  - `OrdenarPorKDA`: Ordena jugadores por su KDA.
  - `OrdenarPorKills`: Ordena jugadores por cantidad de kills.
  - `OrdenarPorEstadisticas`: Ordena equipos por estadísticas agregadas.
- Desarrollar una interfaz gráfica completa usando Java Swing o JavaFX con las siguientes funcionalidades:
  - Ventana principal:
    - Una serie de opciones: Torneos, Equipos, Jugadores, Reportes.
  - Gestión de torneos:
    - Listar todos los torneos con su información en una tabla.
    - Ver detalles de un torneo (equipos participantes, estadísticas).
    - Eliminar torneo.
  - Gestión de Equipos:
    - Listar equipos con opción de búsqueda.
    - Ver roster completo del equipo (5 jugadores + entrenador).
  - Gestión de Jugadores:
    - Listar jugadores con tabla sorteable (aplicar Strategy aquí).
  - Sistema de Reportes (Usar Visitor):
    - Botón "Generar Reporte" que abre un diálogo.
    - Seleccionar tipo de reporte: Estadísticas Generales, Ranking de Jugadores, Reporte Detallado.
    - Aplicar visitor según selección.
    - Mostrar resultado en área de texto formateada o en nueva ventana.
  