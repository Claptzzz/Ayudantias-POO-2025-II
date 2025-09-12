package logica;

import dominio.Equipo;
import dominio.Jugador;
import dominio.Torneo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solve {
    public static void leerArchivo(Torneo t) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("equipos.txt"));
        while(scan.hasNextLine()) {
            String[] partes = scan.nextLine().split(";");
            String nombreEquipo = partes[0];
            int numeroJugadores = Integer.parseInt(partes[1]);
            String region = partes[2];
            int anioFundacion = Integer.parseInt(partes[3]);
            t.cargarEquipo(new Equipo(nombreEquipo, numeroJugadores, region, anioFundacion));
        }
        scan.close();

        scan = new Scanner(new File("jugadores.txt"));
        while(scan.hasNextLine()) {
            String[] partes = scan.nextLine().split(";");
            String equipo = partes[0];
            String nick = partes[1];
            String posicion = partes[2];
            String campeonFavorito = partes[3];
            int killsPromedio = Integer.parseInt(partes[4]);

            for(int i = 0; i < t.getTotalEquipos(); i++) {
                if(t.getEquipos()[i].getNombreEquipo().equalsIgnoreCase(equipo)) {
                    t.getEquipos()[i].agregarJugador(new Jugador(nick, posicion, campeonFavorito, killsPromedio));
                    break;
                }
            }
        }
        scan.close();
    }
    
    public static void mostrarMenu(Torneo t) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("Menu principal\n");
			System.out.println("1. Cargar Datos");
			System.out.println("2. Mostrar Equipos");
			System.out.println("3. Buscar Jugador");
			System.out.println("4. Generar Torneo");
			System.out.println("5. Mostrar Tabla");
			System.out.println("6. Estadísticas");
			System.out.println("7. Filtrar por Región");
			System.out.println("8. Salir");
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch(opcion) {
				case 1:
					leerArchivo(t);
					break;
				case 2:
					t.mostrarEquipos();
					break;
				case 3:
					System.out.print("Indique el jugador a buscar: ");
					String nick = scan.nextLine();
					t.buscarJugador(nick);
					break;
				case 4:
					t.generarEnfrentamientos();
					break;
				case 5:
					t.mostrarTabla();
					break;
				case 6:
					System.out.println(t.equipoMasExperimentado());
					break;
				case 7:
					System.out.print("Indique la region a filtrar: ");
					String region = scan.nextLine();
					t.filtrarPorRegion(region);
					break;
			}
			
		} while(opcion != 8);
	}

    public static void main(String[] args) throws FileNotFoundException {
    	Torneo t = new Torneo();
        mostrarMenu(t);
    }
}
