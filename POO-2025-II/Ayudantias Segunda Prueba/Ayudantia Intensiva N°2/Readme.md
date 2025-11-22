# Ayudantía Intensiva - Sistema de Gestión de Torneos de eSports

**Objetivos**
- Dominar la programación orientada a objetos en Java
- Implementar patrones de diseño avanzados (Singleton, Factory, Visitor y Strategy)
- Desarrollar interfaces gráficas interactivas

<img align="right" width=280px alt="Gaming" src="https://media.tenor.com/IppXYm9PIwIAAAAi/trouble-trouble-the-cat.gif" />

## Ejercicio: Sistema de Gestión de Torneos de League of Legends
League of Legends es uno de los juegos más populares en el mundo de los eSports. Cada temporada se organizan múltiples torneos donde equipos profesionales y amateur compiten por la gloria. Se necesita un sistema completo que gestione torneos, equipos, jugadores y sus estadísticas.

Se te pide crear un programa en Java que maneje lo siguiente:

### Estructura del Sistema
- El sistema puede tener múltiples **Torneos**.
- Un **Torneo** tiene muchos **Equipos** participantes.
- Un **Equipo** tiene 5 **Jugadores** (roles: Top, Jungle, Mid, ADC, Support).
- Cada **Jugador** tiene estadísticas individuales.

---

## Archivos de Entrada
El sistema debe leer los siguientes archivos TXT al iniciar:

**Torneos.txt**
```
T001;Spring Split 2024;ACTIVO;Summoner's Rift;BO3
T002;MSI 2024;FINALIZADO;Summoner's Rift;BO5
T003;Worlds 2024;PROXIMO;Summoner's Rift;BO5
T004;Rift Rivals;ACTIVO;Summoner's Rift;BO1
T005;All-Stars;PROXIMO;Howling Abyss;BO3
```
**Formato:** `ID;Nombre;Estado;Mapa;FormatoPartidas`

**Equipos.txt**
```
T9;Coach Lee;5;T001;T002;T004
G2 Esports;Grabbz;8;T001;T002;T003;T004
Fnatic;Yamato;6;T001;T003
Cloud9;Reapered;10;T002;T004
T1;Kkoma;15;T001;T002;T003;T004;T005
DRX;Cvmax;7;T003;T005
Team Liquid;Jatt;4;T001;T004
```
**Formato:** `NombreEquipo;NombreEntrenador;ExperienciaEntrenador;TorneosParticipados...`

**Jugadores.txt**
```
Faker;T1;Mid;1250;8.5;3.2;AGRESIVO;ASESINO
Caps;G2 Esports;Mid;980;7.8;2.9;EQUILIBRADO;HIBRIDO
Showmaker;DRX;Mid;1050;8.0;3.5;AGRESIVO;MAGO
Perkz;Cloud9;Mid;890;7.5;3.0;EQUILIBRADO;HIBRIDO
Zeus;T1;Top;760;6.5;2.1;AGRESIVO;45;78
Broken Blade;G2 Esports;Top;720;6.8;2.5;EQUILIBRADO;38;72
Wunder;Fnatic;Top;650;6.2;2.8;DEFENSIVO;52;85
Impact;Team Liquid;Top;680;6.0;3.0;DEFENSIVO;48;80
Oner;T1;Jungle;620;5.2;4.8;EQUILIBRADO;67;142
Jankos;G2 Esports;Jungle;580;4.9;5.1;AGRESIVO;54;128
Inspired;Cloud9;Jungle;610;5.5;4.5;DEFENSIVO;71;135
Pyosik;DRX;Jungle;590;5.0;4.9;EQUILIBRADO;63;130
Gumayusi;T1;ADC;1340;9.8;1.5;AGRESIVO;9.2;1250
Rekkles;Fnatic;ADC;1100;9.2;1.8;DEFENSIVO;8.8;1180
Hans Sama;Team Liquid;ADC;1050;8.9;2.0;EQUILIBRADO;8.5;1150
Deft;DRX;ADC;1200;9.5;1.6;EQUILIBRADO;9.0;1220
Keria;T1;Support;380;2.5;8.9;DEFENSIVO;45;28;875.5
Mikyx;G2 Esports;Support;320;2.8;7.5;EQUILIBRADO;42;25;820.3
Hylissang;Fnatic;Support;290;2.3;8.2;AGRESIVO;38;22;790.8
CoreJJ;Team Liquid;Support;350;2.6;8.0;EQUILIBRADO;48;30;910.2
BeryL;DRX;Support;330;2.4;7.8;DEFENSIVO;44;26;850.0
```

**Formatos por Rol:**
- **Atributos generales:** `Nickname;Equipo;Rol;Kills;KDA;MuertesPorPartida;EstiloJuego`
- **Top:** `...;TeleportUsage;Resistencia`
- **Jungle:** `...;ObjetivosAsegurados;GanksExitosos`
- **Mid:** `...;TipoMid`
- **ADC:** `...;FarmPorMinuto;DañoPorSegundo`
- **Support:** `...;WardsColocados;WardsEliminados;UtilidadProporcionada`

---

## Requerimientos del Sistema

### 1. Arquitectura y Patrones de Diseño

#### **Patrón Singleton**
- Implementar la clase `Sistema` como Singleton que gestione:
  - torneos
  - equipos
  - jugadores
  - Métodos para obtener y filtrar datos

#### **Patrón Factory**
- Crear una clase que cree jugadores según el rol:
  - `crearJugador(String rol, String[] datos)` → Retorna instancia correcta (Top, Jungle, Mid, ADC, Support)

#### **Herencia e Interfaces**
```
Jugador (Clase Abstracta) implements Visitable
├── TopLaner
├── Jungler
├── MidLaner
├── ADC
└── Support
```

**Interfaces requeridas:**
- `Visitable`: Define método `aceptar(Visitor visitor)`
- `Visitor`: Define métodos `visitarJugador(Jugador j)`, `obtenerResultado()`

---

### 2. Patrón Visitor

**Todos los visitors operan ÚNICAMENTE sobre objetos `Jugador`**

#### **RankingVisitor**
- **Visita:** Jugadores individualmente
- **Acumula:** Lista de todos los jugadores visitados
- **Genera:** Top 10 jugadores según una métrica (KDA, Kills, o Estadística Específica)

```
=== RANKING DE JUGADORES ===
Métrica: KDA

1. Gumayusi (T1 - ADC) - KDA: 9.80
2. Rekkles (Fnatic - ADC) - KDA: 9.20
3. Hans Sama (Team Liquid - ADC) - KDA: 8.90
...
```

#### **ReporteDetalladoVisitor**
- **Visita:** Jugadores individualmente
- **Genera:** Reporte detallado de cada jugador con todas sus estadísticas (incluidas las específicas de su rol)

```
=== REPORTE DETALLADO DE JUGADORES ===

Jugador: Faker
  Equipo: T1
  Rol: Mid
  Kills: 1250 | KDA: 8.50 | Muertes/Partida: 3.20
  Estilo de Juego: AGRESIVO
  Tipo Mid: ASESINO

Jugador: Zeus
  Equipo: T1
  Rol: Top
  Kills: 760 | KDA: 6.50 | Muertes/Partida: 2.10
  Estilo de Juego: AGRESIVO
  Teleport Usage: 45 | Resistencia: 78
...
```

**Cómo usar los Visitors:**
```java
// Ejemplo de uso
EstadisticasVisitor statsVisitor = new EstadisticasVisitor();
for (Jugador jugador : sistema.getJugadores()) {
    jugador.aceptar(statsVisitor);
}
String reporte = statsVisitor.obtenerResultado();
```

---

### 3. Patrón Strategy

**Todas las strategies operan sobre `ArrayList<Jugador>`**

#### **OrdenarPorKDA**
- Ordena jugadores de mayor a menor KDA

#### **OrdenarPorKills**
- Ordena jugadores de mayor a menor cantidad de Kills

**Interfaz Strategy:**
```java
public interface OrdenamientoStrategy {
    void ordenar(ArrayList<Jugador> jugadores);
    String obtenerNombreEstrategia();
}
```

**Cómo usar Strategy:**
```java
// Ejemplo de uso
OrdenamientoStrategy estrategia = new OrdenarPorKDA();
estrategia.ordenar(jugadores);
// La lista 'jugadores' ahora está ordenada
```

---

## Interfaz Gráfica

Desarrollar una interfaz usando **Java Swing** con las siguientes funcionalidades:

### **Ventana Principal**

Usar `JTabbedPane` con 4 pestañas:

#### **1. Pestaña Torneos**
- **JTable** mostrando: ID, Nombre, Estado, Mapa, Formato
- **JButton "Ver Detalles"**: Abre diálogo mostrando:
  - Información del torneo
  - Lista de equipos participantes
  - Conteo de jugadores totales

#### **2. Pestaña Equipos**
- **JTable** mostrando: Nombre, Nombre Entrenador, Experiencia Entrenador, Cantidad Jugadores, Torneos Jugados
- **JTextField** para búsqueda por nombre (filtro en tiempo real)
- **JButton "Ver Roster"**: Abre diálogo mostrando:
  - Los 5 jugadores del equipo (tabla con todas sus stats)

#### **3. Pestaña Jugadores (Aplicar Strategy)**
- **JTable** mostrando: Nickname, Equipo, Rol, Kills, KDA, Muertes/Partida, Estilo
- **Panel de Ordenamiento:**
  - **JLabel** "Ordenar por:"
  - **JComboBox** con opciones:
    - "KDA (Mayor a Menor)"
    - "Kills (Mayor a Menor)"
  - **JButton "Aplicar"**: Aplica el Strategy seleccionado y actualiza la tabla
- **JButton "Restablecer"**: Vuelve al orden original (por aparición en archivo)

#### **4. Pestaña Reportes (Aplicar Visitor)**
- **Panel de Selección:**
  - **JRadioButton** (ButtonGroup):
    - ( ) Ranking de Jugadores
    - ( ) Reporte Detallado de Jugadores
- **JButton "Generar Reporte"**: 
  - Aplica el Visitor correspondiente
  - Muestra resultado en **JTextArea** con scroll
- **JButton "Limpiar"**: Limpia el área de texto

---

## Requisitos Técnicos

### **Obligatorio:**
1. Uso de `ArrayList` para todas las colecciones
2. Lectura completa de los 3 archivos TXT al iniciar
3. Implementación correcta de:
   - Patrón Singleton (Sistema)
   - Patrón Factory (JugadorFactory)
   - Patrón Visitor (2 visitantes que operan sobre Jugador)
   - Patrón Strategy (2 estrategias que ordenan ArrayList\<Jugador\>)
4. Herencia
5. Interfaz gráfica completamente funcional
6. Manejo básico de excepciones en lectura de archivos

### **Detalles de Implementación:**

**Sistema (Singleton):**
```java
public class Sistema {
    private static Sistema instancia;
    private ArrayList<Torneo> torneos;
    private ArrayList<Equipo> equipos;
    private ArrayList<Jugador> jugadores;
    
    private Sistema() { }
    
    public static Sistema obtenerInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }
    
    public void cargarDatos() {
        // Leer archivos TXT
    }
}
```

**Visitor Pattern:**
- Cada jugador puede aceptar un visitor: `jugador.aceptar(visitor)`
- El visitor procesa cada jugador y acumula información
- Al final, genera un reporte con `visitor.obtenerResultado()`

**Strategy Pattern:**
- Se selecciona una estrategia desde la GUI
- Se aplica sobre el ArrayList de jugadores: `estrategia.ordenar(jugadores)`
- La tabla se actualiza para reflejar el nuevo orden

---

- **Link a Videos:**  
  [Ver carpeta de videos](https://drive.google.com/drive/folders/1oVZZu9ZXrJPhl7pwLtQ3EIQwDp2_sa4q?usp=sharing)

