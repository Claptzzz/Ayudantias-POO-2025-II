package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.*;

public class App {
	
	private static ArrayList<Dinosaurio> dinosaurios = new ArrayList<>();
	private static Scanner tecladoStr = new Scanner(System.in);
	private static Scanner tecladoInt = new Scanner(System.in);
	
	public static void leerArchivo() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("dinosaurios.txt"));
		
		while(scan.hasNextLine()) {
			String[] partes = scan.nextLine().split(",");
			int id = Integer.parseInt(partes[0]);
			String tipo = partes[1];
			String nombre = partes[2];
			String especie = partes[3];
			int edad = Integer.parseInt(partes[4]);
			
			if(tipo.equals("Herbivoro")) {
				String altura = partes[5];
				String tipoDiente = partes[6];
				Dinosaurio herviboro = new Herbivoro(id, tipo, nombre, especie, edad, altura, tipoDiente);
				dinosaurios.add(herviboro);
				
				
			} else if(tipo.equals("Carnivoro")) {
				String habilidad = partes[5];
				String tipoCaza = partes[6];
				Dinosaurio carnivoro = new Carnivoro(id, tipo, nombre, especie, edad, habilidad, tipoCaza);
				dinosaurios.add(carnivoro);
				
			} else if(tipo.equals("Volador")) {
				String envergadura = partes[5];
				String tipoVuelo = partes[6];
				Dinosaurio volador = new Volador(id, tipo, nombre, especie, edad, envergadura, tipoVuelo);
				dinosaurios.add(volador);
				
			}
		}
		
		
	}

	public static void menu() {
		int opcion = 0;
		
		do {
			System.out.println("\n----MENU GESTION PARQUE----");
			System.out.println("1. Agregar dinosaurio al parque");
			System.out.println("2. Eliminar dinosaurio del parque");
			System.out.println("3. Mostrar ficha de un dinosaurio");
			System.out.println("4. Salir");
			System.out.print("Elección: ");
			opcion = tecladoInt.nextInt();
			tecladoInt.nextLine(); // <- limpia el salto de línea
			
			if(opcion == 1) {
				System.out.println("Indique el tipo de dinosaurio:");
				System.out.println("1. Herviboro | 2. Carnivoro | 3. Volador");
				int tipo = tecladoInt.nextInt();
				tecladoInt.nextLine(); // <- limpia el salto de línea
				
				if(tipo > 0 && tipo < 4) {
					System.out.print("Indique el nombre: ");
					String nombre = tecladoStr.nextLine();
					System.out.print("Indique la especie: ");
					String especie = tecladoStr.nextLine();
					System.out.print("Indique la edad: ");
					int edad = tecladoInt.nextInt();
					tecladoInt.nextLine(); // <- limpia el salto de línea
					
					int id = 0;
					for(Dinosaurio d: dinosaurios) {
						id = d.getId();
					}
					
					if(tipo == 1) {
						System.out.print("Indique la altura: ");
						String altura = tecladoStr.nextLine();
						System.out.print("Indique el tipo de diente: ");
						String tipoDiente = tecladoStr.nextLine();
						
						Dinosaurio d = new Herbivoro(id+1, "Herviboro", nombre, especie, edad, altura, tipoDiente);
						dinosaurios.add(d);
						
					} else if(tipo == 2) {
						System.out.print("Indique la habilidad: ");
						String habilidad = tecladoStr.nextLine();
						System.out.print("Indique el tipo de caza: ");
						String tipoCaza = tecladoStr.nextLine();
						
						Dinosaurio d = new Carnivoro(id+1, "Carnivoro", nombre, especie, edad, habilidad, tipoCaza);
						dinosaurios.add(d);
						
					} else if(tipo == 3) {
						System.out.print("Indique la envergadura de las alas: ");
						String envergadura = tecladoStr.nextLine();
						System.out.print("Indique el tipo de vuelo: ");
						String tipoVuelo = tecladoStr.nextLine();
						
						Dinosaurio d = new Volador(id+1, "Volador", nombre, especie, edad, envergadura, tipoVuelo);
						dinosaurios.add(d);
						
					}
					
				} else {
					System.out.println("Tipo de dinosaurio no válido!");
				}
				
				
			} else if(opcion == 2) {
				System.out.println("IDs de dinosaurios:");
				for(Dinosaurio d: dinosaurios) {
					System.out.println(d.getId());
				}
				
				System.out.print("Indique una ID:");
				int id = tecladoInt.nextInt();
				
				Dinosaurio dinosaurio = null;
				
				for(Dinosaurio d: dinosaurios) {
					if(d.getId() == id) {
						dinosaurio = d;
						break;
					}
				}
				
				if(dinosaurio != null && dinosaurios.remove(dinosaurio)) {
					System.out.println("El dinosaurio se ha eliminado correctamente!");
				} else {
					System.out.println("El dinosaurio no ha sido encontrado o ocurrió un error al eliminarlo.");
				}
				
				
			} else if(opcion == 3) {
				System.out.println("IDs de dinosaurios:");
				for(Dinosaurio d: dinosaurios) {
					System.out.println(d.getId());
				}
				
				System.out.print("Indique una ID:");
				int id = tecladoInt.nextInt();
				
				Dinosaurio dinosaurio = null;
				
				for(Dinosaurio d: dinosaurios) {
					if(d.getId() == id) {
						dinosaurio = d;
						break;
					}
				}
				
				if(dinosaurio != null) {
					dinosaurio.mostrarFicha();
				} else {
					System.out.println("No se encontró ningún dinosaurio con esta ID.");
				}
				
			} else if(opcion == 4) {
				System.out.println("Hasta luego :D");
			}
			
			
		} while(opcion != 4);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		leerArchivo();
		menu();
	}

}
