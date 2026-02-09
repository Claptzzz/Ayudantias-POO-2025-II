package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dominio.Soldado;

public class App {
	
	private static Soldado[][] mz = new Soldado[10][10];

	public static void main(String[] args) throws FileNotFoundException {
		
		int opcion = 0;
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println("1) Cargar Soldados");
			System.out.println("2) Mostrar Todos");
			System.out.println("3) Buscar Especialidad");
			System.out.println("4) Generar Formacion");
			System.out.println("5) Estadisticas");
			System.out.println("6) Salir");
			System.out.print("Ingrese Opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			System.out.println();
			
			switch(opcion) {
			case 1:
				leerArch(s);
				break;
			case 2:
				mostrarTodos();
				break;
			case 3:
				buscarEspecialidad(s);
				break;
			case 4:
				imprimirMatriz();
				break;
			case 5:
				promedios();
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Valor incorrecto, reingrese...");
				break;
			}
			
			
			
			
		} while(opcion!=6);
		
		s.close();
		
		
	}

	private static void promedios() {

		int cantSoldados = 0;
		int totalExp = 0;
		int totalEdad = 0;
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (mz[i][j] != null) {
					cantSoldados++;
					totalExp += mz[i][j].getExp();
					totalEdad += mz[i][j].getEdad();
				}
			}
		}
		float promedioE = totalEdad/cantSoldados;
		float promedioExp = totalExp/cantSoldados;
		
		System.out.printf("Promedio Edad = %.2f %nPromedio Experiencia = %.2f %n", promedioE, promedioExp);
		
	}

	private static void imprimirMatriz() {

		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (mz[i][j] != null) {
					System.out.print(mz[i][j].getNombre() + " ");
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
	}

	private static void buscarEspecialidad(Scanner s) {
		
		int opcion = 0;
		do {
			System.out.println("Seleccione que especialidad desea filtrar");
			System.out.println("1) Artilleria");
			System.out.println("2) Infanteria");
			System.out.println("3) Volver al menu principal");
			System.out.print("Ingrese opcion: ");
			System.out.println();
			opcion = s.nextInt();
			s.nextLine();
			
			switch(opcion) {
			case 1:
				buscar("Artilleria");
				break;
			case 2:
				buscar("Infanteria");
				break;
			case 3:
				System.out.println("Volviendo...");
				break;
			default:
				System.out.println("No valido, reingrese");
				break;
			}
			
		} while(opcion != 3);
	}

	private static void buscar(String especialidad) {

		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (mz[i][j] != null && mz[i][j].getEspecialidad().equals(especialidad)) {
					System.out.println(mz[i][j]);
				}
			}
		}
		
	}

	private static void mostrarTodos() {

		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (mz[i][j] != null) {
					System.out.println(mz[i][j]);
				}
			}
		}
	}

	private static void leerArch(Scanner s) throws FileNotFoundException {
		
		File arch = new File("soldados.txt");
		s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String[] partes = s.nextLine().split(" ");
			String nombre = partes[0];
			String esp = partes[1];
			int edad = Integer.parseInt(partes[2]);
			int exp = Integer.parseInt(partes[3]);
			String ciudad = partes[4];
			int posx = Integer.parseInt(partes[5]);
			int posy = Integer.parseInt(partes[6]);
			
			Soldado sold = new Soldado(nombre, esp, edad, exp, ciudad, posx, posy);
			mz[posx-1][posy-1] = sold;
		}
		System.out.println("Datos Cargados!");
	}

}
