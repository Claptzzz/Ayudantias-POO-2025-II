package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dominio.Mascota;

public class App {
	
	public static Mascota[] cargarArchivo(String nombreArch) {
		Mascota[] mascotas = new Mascota[100];
		try {
			Scanner scan = new Scanner(new File(nombreArch));
			int cantLineas = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				int id = Integer.parseInt(partes[0]);
				String nombre = partes[1];
				String especie = partes[2];
				int edad = Integer.parseInt(partes[3]);
				float peso = Float.parseFloat(partes[4]);
				
				Mascota mascota = new Mascota(id, nombre, especie, edad, peso);
				
				mascotas[cantLineas] = mascota;
				cantLineas++;
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mascotas;
	}
		
	public static void menu() {
		Mascota[] mascotas = cargarArchivo("mascotas.txt");
		Scanner tecladoStr = new Scanner(System.in);
		Scanner tecladoInt = new Scanner(System.in);
		Scanner tecladoFloat = new Scanner(System.in);
		
		int eleccion = 0;
		
		do {
			System.out.println("---Sistema digital AnimalCare---\n");
			System.out.println("1. Registrar una nueva mascota.");
			System.out.println("2. Actualizar datos de una mascota.");
			System.out.println("3. Ver listado de mascotas registradas.");
			System.out.println("4. Salir.");
			eleccion = tecladoInt.nextInt();
			
			if(eleccion == 1) {
				System.out.println("Ingrese los datos de la mascota:\n");
				System.out.print("Nombre: ");
				String nombre = tecladoStr.nextLine();
				System.out.print("Especie: ");
				String especie = tecladoStr.nextLine();
				System.out.print("Edad: ");
				int edad = tecladoInt.nextInt();
				System.out.print("Peso: ");
				float peso = tecladoFloat.nextFloat();
				
				int id = 1;
				
				for(int i = 0; i < mascotas.length; i++) {
					if(mascotas[i] != null) {
						id = mascotas[i].getId() + 1;
					} else {
						Mascota mascota = new Mascota(id+1, nombre, especie, edad, peso);
						mascotas[id] = mascota;
						break;
					}
				}
				
				
				
				
			} else if(eleccion == 2) {
				System.out.println("Ingrese el ID de la mascota a actualizar sus nombre:");
				int id = tecladoInt.nextInt();
				
				for(int i = 0; i < mascotas.length; i++) {
					if(mascotas[i] != null && mascotas[i].getId() == id) {
						System.out.println("Ingrese el nuevo nombre de la mascota: ");
						String nombre = tecladoStr.nextLine();
						mascotas[i].setNombre(nombre);
						break;
					}
				}
				
				
			} else if(eleccion == 3) {
				for(int i = 0; i < mascotas.length; i++) {
					if(mascotas[i] != null) {
						System.out.println(mascotas[i].toString());
					}
				}
				
			} else if(eleccion == 4) {
				System.out.println("Hasta luego :D");
			}
			
			
			
		} while(eleccion != 4);
	}
	
	public static void main(String[] args) {
		
		menu();
		
	}

}
