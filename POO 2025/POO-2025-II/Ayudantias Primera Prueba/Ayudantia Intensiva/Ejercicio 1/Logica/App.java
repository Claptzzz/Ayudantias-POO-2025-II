package Logica;

import Dominio.Equipo;
import Dominio.Jugador;
import Dominio.Premier;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class App {
    private static Scanner s;
    private static ArrayList<Premier> premiers = new ArrayList<>();
    private static ArrayList<Equipo> equipos = new ArrayList<>();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        
        leerPremier();
        leerEquipos();
        leerJugadores();

        int opcion = 0;
        s = new Scanner(System.in);
        do {
            System.out.println("1) Mostrar las Premier registradas");
            System.out.println("2) Mostrar todos los equipos existentes");
            System.out.println("3) Crear una Premier");
            System.out.println("4) Agregar un equipo a una Premier");
            System.out.println("5) Crear un equipo");
            System.out.println("6) Modificar un equipo");
            System.out.println("7) Añadir un jugador");
            System.out.println("8) Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = s.nextInt();
            s.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    showPremiers();
                    break;
                case 2:
                    showTeams();
                    break;
                case 3:
                    crearPremier();
                    break;
                case 4:
                    addEquipoAPremier();
                    break;
                case 5:
                    crearEquipo();
                    break;
                case 6:
                    modificarEquipo();
                    break;
                case 7:
                    addPlayer();
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

        } while (opcion != 8);
    }

    public static void showPremiers() {
        for (Premier p : premiers) {
            System.out.println("ID: " + p);
            for (Equipo e : p.getEquipos()) {
                System.out.println("  Equipo: " + e.getNombre());
            }
        }
    }

    public static void showTeams() {
        for (Equipo e : equipos) {
            System.out.println("Equipo: " + e.getNombre());
        }
    }

    public static void crearPremier() {
        System.out.println("Ingrese el ID de la Premier: ");
        String id = s.nextLine();
        System.out.println("Ingrese el mapa de la Premier: ");
        String mapa = s.nextLine();
        Premier p = new Premier(id, mapa);
        premiers.add(p);
        System.out.println("Premier creada exitosamente.");
    }

    public static void addEquipoAPremier() {
        System.out.println("Ingrese el ID de la Premier a la que desea agregar un equipo: ");
        String id = s.nextLine();
        Premier premierSeleccionada = null;
        for (Premier p : premiers) {
            if (p.getId().equals(id)) {
                premierSeleccionada = p;
                break;
            }
        }
        if (premierSeleccionada == null) {
            System.out.println("Premier no encontrada.");
            return;
        }
        System.out.println("Ingrese el nombre del equipo a agregar: ");
        String nombreEquipo = s.nextLine();
        Equipo equipoSeleccionado = null;
        for (Equipo e : equipos) {
            if (e.getNombre().equals(nombreEquipo)) {
                equipoSeleccionado = e;
                break;
            }
        }
        if (equipoSeleccionado == null) {
            System.out.println("Equipo no encontrado.");
            return;
        }
        premierSeleccionada.addEquipo(equipoSeleccionado);
        System.out.println("Equipo agregado exitosamente a la Premier.");
    }

    public static void crearEquipo() {
        System.out.println("Ingrese el nombre del equipo: ");
        String nombre = s.nextLine();
        Equipo e = new Equipo(nombre);
        equipos.add(e);
        System.out.println("Equipo creado exitosamente.");
    }

    public static void modificarEquipo() {
        System.out.println("Ingrese el nombre del equipo a modificar: ");
        String nombre = s.nextLine();
        Equipo equipoSeleccionado = null;
        for (Equipo e : equipos) {
            if (e.getNombre().equals(nombre)) {
                equipoSeleccionado = e;
                break;
            }
        }
        if (equipoSeleccionado == null) {
            System.out.println("Equipo no encontrado.");
            return;
        }
        int opcion = 0;
        do {
            System.out.println("1) Cambiar nombre del equipo");
            System.out.println("2) Aregar Jugador al equipo");
            System.out.println("3) Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = s.nextInt();
            s.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre del equipo: ");
                    String nuevoNombre = s.nextLine();
                    equipoSeleccionado.setNombre(nuevoNombre);
                    System.out.println("Nombre del equipo cambiado exitosamente.");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del jugador a agregar: ");
                    String nombreJugador = s.nextLine();
                    Jugador jugadorSeleccionado = null;
                    for (Jugador j : jugadores) {
                        if (j.getNombre().equals(nombreJugador)) {
                            jugadorSeleccionado = j;
                            break;
                        }
                    }
                    if (jugadorSeleccionado == null) {
                        System.out.println("Jugador no encontrado.");
                        break;
                    }
                    equipoSeleccionado.addJugador(jugadorSeleccionado);
                    System.out.println("Jugador agregado exitosamente al equipo.");
                    break;
                case 3:
                    System.out.println("Saliendo de la modificación del equipo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while(opcion != 3);
    }

    public static void addPlayer() {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = s.nextLine();
        Jugador j = new Jugador(nombre);
        jugadores.add(j);
        System.out.println("Jugador creado exitosamente.");
    }

    private static void leerPremier() throws FileNotFoundException {
        File arch = new File("Premier.txt");
        s = new Scanner(arch);
        
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            Premier p = new Premier(partes[0], partes[1]);
            premiers.add(p);
        }
    }

    private static void leerEquipos() throws FileNotFoundException {
        File arch = new File("Equipos.txt");
        s = new Scanner(arch);
        
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            Equipo e = new Equipo(partes[0]);
            equipos.add(e);

            //Relacionar equipos con premier
            int length = partes.length;
            for (int i = 1; i < length; i++) {
                for (Premier p : premiers) {
                    if (p.getId().equals(partes[i])) {
                        p.addEquipo(e);
                    }
                }
            }
        }
    }

    private static void leerJugadores() throws FileNotFoundException {
        File arch = new File("Jugadores.txt");
        s = new Scanner(arch);
        
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            Jugador j = new Jugador(partes[0]);
            jugadores.add(j);
            //Relacionar jugadores con equipos
            for (Equipo e : equipos) {
                if (e.getNombre().equals(partes[1])) {
                    e.addJugador(j);
                }
            }
        }
    }
}