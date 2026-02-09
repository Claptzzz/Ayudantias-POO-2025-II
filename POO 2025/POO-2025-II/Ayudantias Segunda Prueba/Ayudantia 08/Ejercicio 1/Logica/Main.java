package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static Scanner s;
	private static Sistema sistema = SistemaImpl.getInstance();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		cargarDatos();
		seleccionarJugador();
		menu();
	}

	private static void seleccionarJugador() {
		s = new Scanner(System.in);
		System.out.println("Creando jugador:");
		System.out.println("Nombre: ");
		String nombre = s.next();
		
		System.out.println("Tipo de cuenta:");
		System.out.println("1) Free");
		System.out.println("2) Premium (+50% de recursos)");
		System.out.println("opcion: ");
		int opcion = s.nextInt();
		s.nextLine();
		boolean premium = (opcion ==2);
		sistema.addJugador(nombre, premium);
		System.out.printf("Bienvenido %s\n", nombre);
		
		
	}

	private static void menu() {
		int opcion = 0;
		s = new Scanner(System.in);
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("                    Sistema Albion Online                   ");
			System.out.println("------------------------------------------------------------");
			System.out.printf("Jugador %s  [%s]\n", sistema.getNameJugador(), sistema.getCuentaJugador());
			System.out.printf("Estrategia actual: %s\n", sistema.getEstrategiaActual());
			System.out.println("1) Gestion de recusos");
			System.out.println("2) Analisis con visitor");
			System.out.println("3) Salir");
			System.out.println("Opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			
			switch(opcion) {
				case 1:
					menuGestion();
					break;
				case 2:
					menuAnalisis();
					break;
				case 3:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Input Incorrecto!!");
					break;
			}
		} while (opcion!=3);
		
	}

	private static void menuAnalisis() {
		int opcion = 0;
		s = new Scanner(System.in);
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("                       Menu Analisis                        ");
			System.out.println("------------------------------------------------------------");
			System.out.println("1) Calcular valor total en plata");
			System.out.println("2) Aplicar bonificacion premium");
			System.out.println("3) Volver");
			System.out.println("Ingrese opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			
			switch(opcion) {
				case 1:
					System.out.println(sistema.calcularPlata());
					break;
				case 2:
					System.out.println(sistema.aplicarBonoPremium());
					break;
				case 3:
					System.out.println("Volviendo...");
					break;
				default:
					System.out.println("Input Incorrecto!!");
					break;	
			}
		} while(opcion!=3);
	}

	private static void menuGestion() {
		int opcion = 0;
		s = new Scanner(System.in);
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("                       Menu Gestion                         ");
			System.out.println("------------------------------------------------------------");
			System.out.println("1) Ver recursos");
			System.out.println("2) Recolectar con estrategia actual");
			System.out.println("3) Cambiar estrategia");
			System.out.println("4) Volver");
			System.out.println("Ingrese opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			
			switch(opcion) {
				case 1:
					System.out.println(sistema.verRecursos());
					break;
				case 2:
					System.out.println(sistema.verRecursos());
					System.out.println("Elige recurso a recolectar");
					int recurso = s.nextInt();
					s.nextLine();
					System.out.println(sistema.recolectar(recurso));
					break;
				case 3:
					System.out.println("Estrategias:");
					System.out.println("1) Arriesgada");
					System.out.println(sistema.descripcionEstrategiaArriesgada());
					System.out.println("2) Segura");
					System.out.println(sistema.descripcionEstrategiaSegura());
					int estrategia = s.nextInt();
					s.nextLine();
					System.out.println(sistema.cambiarEstrategia(estrategia));
					break;
				case 4:
					System.out.println("Volviendo...");
					break;
				default:
					System.out.println("Input Incorrecto!!");
					break;	
			}
		} while(opcion!=4);
		
	}

	private static void cargarDatos() throws FileNotFoundException {
		File arch = new File("Recursos.txt");
		s = new Scanner(arch);
		
		while(s.hasNextLine()) {
			String[] partes = s.nextLine().split(";");
			int id = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String tipo = partes[2];
			int cantidad = Integer.parseInt(partes[3]);
			String zona = partes[4];
			int tier = Integer.parseInt(partes[5]);
			sistema.crearRecurso(id, nombre, tipo, cantidad, zona, tier);
		}	
		
	}
}
