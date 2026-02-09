package partidas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	
	private static Sistema sistema = new SistemaImpl();
		
	public static void main (String[] args) throws FileNotFoundException {
		

		try {
            cargarPartidas("Ayudantia 08/txt/partidas.txt");
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return;
        }
		
		imprimirMenu();
	}

	public static void cargarPartidas(String url) throws FileNotFoundException {
		
		File arch = new File(url);
		Scanner s = new Scanner(arch);
		while (s.hasNextLine()) {
			String[] partes = s.nextLine().split(",");
			String jugador = partes[0];
			String tipo = partes[1];
			double tiempoPartida = Double.valueOf(partes[2]);
			double danioGenerado = Double.valueOf(partes[3]);
			
			sistema.addJugador(jugador);

			switch (tipo) {
			case "Huntress":
				double cantF = Double.valueOf(partes[4]);
				double velMax = Double.valueOf(partes[5]);
				sistema.addHuntress(jugador, tipo, tiempoPartida, danioGenerado, cantF, velMax);
				break;
			case "Engineer":
				double cantT = Double.valueOf(partes[4]);
				sistema.addEngineer(jugador, tipo, tiempoPartida, danioGenerado, cantT);
				break;
			case "Loader":
				double escudoG = Double.valueOf(partes[4]);
				double mayorDR = Double.valueOf(partes[5]);
				double cantOS = Double.valueOf(partes[6]);
				sistema.addLoader(jugador, tipo, tiempoPartida, danioGenerado, escudoG, mayorDR, cantOS);
				break;
			}
		}
		s.close();
		
	}


	private static void imprimirMenu() {
		
		int opcion = 0;
		Scanner ss = new Scanner(System.in);
		
		do {
			System.out.println("--------------------------------------");
			System.out.println("PapuMenu");
			System.out.println("--------------------------------------");
			System.out.println("1)Resumen Jugador.");
			System.out.println("2)Resumen Partidas.");
			System.out.println("3)Salir.\n");
			System.out.print("Ingrese: ");
			opcion = ss.nextInt();
			ss.nextLine();
			System.out.println();
			if (opcion == 1) {
				
				System.out.println("Jugadores:");
				System.out.println();
				int aux = 1;
				for (int i=0; i<sistema.getCantJugadores(); i++) {
					System.out.printf("%d)", aux);
					System.out.println(sistema.getJugador(i));
					aux++;
				}
				System.out.println();
				System.out.print("Ingrese jugador: ");
				int opcionJ = ss.nextInt();
				ss.nextLine();
				System.out.println(sistema.resumenJugador(opcionJ));
				
			} else if (opcion == 2) {
				
				for (int i=0; i<sistema.getPartidasSize(); i++) {
					if (sistema.getTipo(i).equals("Huntress")) {
						System.out.println("--------------------------------------");
						System.out.println("Partida con Huntress:");
						System.out.println(sistema.resumenPartidas(i));
						System.out.println("--------------------------------------");
					} else if (sistema.getTipo(i).equals("Engineer")) {
						System.out.println("--------------------------------------");
						System.out.println("Partida con Engineer:");
						System.out.println(sistema.resumenPartidas(i));
						System.out.println("--------------------------------------");
					} else if (sistema.getTipo(i).equals("Loader")) {
						System.out.println("--------------------------------------");
						System.out.println("Partida con Loader:");
						System.out.println(sistema.resumenPartidas(i));
						System.out.println("--------------------------------------");
					}
				}
				
			}
			if (opcion != 1 && opcion != 2 && opcion != 3) {
				System.out.println("opcion invalida, reingrese.");
			}
		}while (opcion != 3);
		System.out.println("xau");
		ss.close();
	}

	
}
