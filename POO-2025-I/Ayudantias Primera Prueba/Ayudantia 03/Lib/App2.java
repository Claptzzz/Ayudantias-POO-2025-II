package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dominio.Libro;
import dominio.Mascota;

public class App2 {
	
	public static Libro[] cargarArchivo(String nombreArch) {
		Libro[] libros = new Libro[100];
		
		try {
			Scanner scan = new Scanner(new File(nombreArch));
			int cantLineas = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(";");
				int id = Integer.parseInt(partes[0]);
				String titulo = partes[1];
				String autor = partes[2];
				int anio = Integer.parseInt(partes[3]);
				String estado = partes[4];
				
				Libro libro = new Libro(id, titulo, autor, anio, estado);
				libros[cantLineas++] = libro;
			}	
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libros;
		
	}
	
	public static void menu() {
		Libro[] libros = cargarArchivo("libros.txt");
		
		Scanner tecladoStr = new Scanner(System.in);
		Scanner tecladoInt = new Scanner(System.in);
		
		int eleccion = 0;
		
		do {
			System.out.println("---Sistema digital Lectura Ilimitada---\n");
			System.out.println("1. Agregar libro a la biblioteca.");
			System.out.println("2. Listar libros disponibles.");
			System.out.println("3. Prestar un libro.");
			System.out.println("4. Devolver un libro.");
			System.out.println("5. Salir.");
			eleccion = tecladoInt.nextInt();
			
			if(eleccion == 1) {
				System.out.println("Ingrese los datos del libro.");
				System.out.print("Nombre: ");
				String nombre = tecladoStr.nextLine();
				System.out.print("Autor: ");
				String autor = tecladoStr.nextLine();
				System.out.print("Año de publicación: ");
				int anio = tecladoInt.nextInt();

				int id = 1;
				
				for(int i = 0; i < libros.length; i++) {
					if(libros[i] != null) {
						id = libros[i].getId() +1 ;
					} else {
						Libro libro = new Libro(id, nombre, autor, anio, "Disponible");
						libros[id] = libro;
						break;
					}
				}
				
			} else if(eleccion == 2) {
				
				for(int i = 0; i < libros.length; i++) {
					if(libros[i] != null) {
						if(libros[i].getEstado().equalsIgnoreCase("Disponible")) {
							System.out.println(libros[i].toString());
						}
					}
				}
				
			} else if(eleccion == 3) {
				
				System.out.println("Ingrese el id del libro a prestar.");
				int id = tecladoInt.nextInt();
				
				for(int i = 0; i < libros.length; i++) {
					if(libros[i] != null && libros[i].getId() == id) {
						if(libros[i].getEstado().equalsIgnoreCase("Disponible")) {
							libros[i].setEstado("Prestado");
							System.out.println("Libro prestado exitosamente.");
						} else {
							System.out.println("El libro está prestado.");
						}
					}
				}
				
			} else if(eleccion == 4) {
				
				System.out.println("Ingrese el id del libro a devolver.");
				int id = tecladoInt.nextInt();
				
				for(int i = 0; i < libros.length; i++) {
					if(libros[i] != null && libros[i].getId() == id) {
						if(libros[i].getEstado().equalsIgnoreCase("Prestado")) {
							libros[i].setEstado("Disponible");
							System.out.println("Libro devuelto exitosamente.");
						} else {
							System.out.println("El libro está disponible.");
						}
					}
				}
				
			} else if(eleccion == 5) {
				System.out.println("Hasta luego :D");
				tecladoStr.close();
				tecladoInt.close();
			}
			
		} while(eleccion != 5);
	}
		
		
	
	public static void main(String[] args) {
		menu();
	}

}
