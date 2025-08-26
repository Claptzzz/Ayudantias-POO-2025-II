package rawr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Dinosaurio[] dinos = new Dinosaurio[200];
		
		File arch = new File("Dinosaurios.txt");
		Scanner s = new Scanner (arch);
		
		int menorAmenaza = 0;
		int mayorAmenaza = 0;
		int aux = 0;
		
		while (s.hasNextLine()) {
			
			String linea = s.nextLine();
			String[] partes = linea.split(",");
			
			if (aux == 0) { menorAmenaza=Integer.parseInt(partes[5]); mayorAmenaza=Integer.parseInt(partes[5]); }
			
			if (menorAmenaza > Integer.parseInt(partes[5])) { menorAmenaza =  Integer.parseInt(partes[5]); }
			if (mayorAmenaza < Integer.parseInt(partes[5])) { mayorAmenaza =  Integer.parseInt(partes[5]); }
			
			dinos[aux] = new Dinosaurio(partes[0], partes[1], partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
			
			aux++;	
		}
		
		int opcion = 0;
		s = new Scanner(System.in);
		
		do {
			System.out.println("Bienvenido al DinoMenu");
			System.out.println("1) Imprimir información.");
			System.out.println("2) Filtrar por dieta.");
			System.out.println("3) Agregar nuevo dinosaurio.");
			System.out.println("4) Imprimir menor y mayor amenaza.");
			System.out.println("5) Simular Dieta dominante.");
			System.out.println("6) Salir.");
			System.out.print("Ingrese DinoOpcion: ");
			opcion = s.nextInt();
			s.nextLine();		
			
			if (opcion == 1) {
				imprimirInfo(dinos);
			} else if (opcion == 2) {
				filtarDieta(dinos, s);	
			} else if (opcion == 3) {
				dinos = agregarDino(dinos, s);			
			} else if (opcion == 4) {
				mayorYMenor(dinos);			
			} else if (opcion == 5) {
				simular(dinos);
			}
			
		} while (opcion != 6);
		
		System.out.println("Cerrando...");
		s.close();
		
	}

	private static void simular(Dinosaurio[] dinos) {
		int amenazaC = 0;
		int amenazaH = 0;
		int amenazaO = 0;
		
		for (int i=0; i<dinos.length; i++) {
			if (dinos[i] != null) {
				if (dinos[i].getDieta().equals("Carnivoro")) {amenazaC += dinos[i].getNivelAmenaza();}
				if (dinos[i].getDieta().equals("Herviboro")) {amenazaH += dinos[i].getNivelAmenaza();}
				if (dinos[i].getDieta().equals("Omnivoro")) {amenazaO += dinos[i].getNivelAmenaza();}
			}
		}
		System.out.println("Los niveles de amenaza por dieta son: ");
		System.out.printf("%nCarnivoros: %d", amenazaC);
		System.out.printf("%nHerviboros: %d", amenazaH);
		System.out.printf("%nOmnivoros: %d%n", amenazaO);
		
		System.out.print("Los dominantes son: ");
		if (amenazaC > amenazaH && amenazaC > amenazaO) {
			System.out.println("Los Carnivoros");
		}
		if (amenazaH > amenazaC && amenazaH > amenazaO) {
			System.out.println("Los Herviboros");
		}
		if (amenazaO > amenazaH && amenazaO > amenazaC) {
			System.out.println("Los Omnivoros");
		}
		
	}

	private static void mayorYMenor(Dinosaurio[] dinos) {
		Dinosaurio mayor = null;
		Dinosaurio menor = null;
		for (int i=0; i<dinos.length; i++) {
			if (dinos[i]!= null) {
				if(i==0) {
					mayor = dinos[i];
					menor = dinos[i];
				}
				if (dinos[i].getNivelAmenaza() < menor.getNivelAmenaza()) {
					menor = dinos[i];
				}
				if (dinos[i].getNivelAmenaza() > mayor.getNivelAmenaza()) {
					mayor = dinos[i];
				}
			}
		}
		System.out.printf("%nEl dinosaurio con mayor amenaza es: %s, ID: %s, con: %d de nivel de amenaza%n", mayor.getNombre(), mayor.getId(), mayor.getNivelAmenaza());
		System.out.printf("%nEl dinosaurio con menor amenaza es: %s, ID: %s, con: %d de nivel de amenaza%n", menor.getNombre(), menor.getId(), menor.getNivelAmenaza());
		
	}

	private static Dinosaurio[] agregarDino(Dinosaurio[] dinos, Scanner s) {
		
		int id = 0;

		System.out.println("Ingrese datos");
		System.out.println("Nombre: ");
		String nombre = s.next();
		System.out.println("Edad: ");
		String edad = s.next();
		System.out.println("Dieta: ");
		String dieta = s.next();
		System.out.println("Especie: ");
		String especie = s.next();
		System.out.println("Nivel de Amenaza: ");
		int nivelAmenaza = s.nextInt();
		s.nextLine();
		
		for (int i=0; i<dinos.length; i++) {
			if (dinos[i]!=null) {
				id++;
			}
			if (dinos[i] == null) {
				dinos[i] = new Dinosaurio(String.valueOf(id+1), nombre, edad, dieta, especie, nivelAmenaza);
				break;
			}
		}
		return dinos;
	}

	public static void filtarDieta(Dinosaurio[] dinos, Scanner s) {
		int opcion = 0;
		do {
			System.out.println("Cual dieta quiere buscar: ");
			System.out.println("1) Carnivoros");
			System.out.println("2) Herviboros");
			System.out.println("3) Omnivoros");
			System.out.println("4) Salir");
			System.out.print("Ingrese opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			
			if (opcion == 1) {
				for (int i = 0; i < dinos.length; i++) {
					if (dinos[i] != null && dinos[i].getDieta().equals("Carnivoro")) {
						System.out.printf("%nID: %s, Nombre: %s, Edad: %s, Dieta: %s, Especie: %s, Nivel de amenaza: %d%n", dinos[i].getId(), dinos[i].getNombre(), dinos[i].getEdad(), dinos[i].getDieta(), dinos[i].getEspecie(), dinos[i].getNivelAmenaza());
					}
				}
			} else if (opcion == 2) {
				for (int i = 0; i < dinos.length; i++) {
					if (dinos[i] != null && dinos[i].getDieta().equals("Herviboro")) {
						System.out.printf("%nID: %s, Nombre: %s, Edad: %s, Dieta: %s, Especie: %s, Nivel de amenaza: %d%n", dinos[i].getId(), dinos[i].getNombre(), dinos[i].getEdad(), dinos[i].getDieta(), dinos[i].getEspecie(), dinos[i].getNivelAmenaza());
					}
				}		
			} else if (opcion == 3) {
				for (int i = 0; i < dinos.length; i++) {
					if (dinos[i] != null && dinos[i].getDieta().equals("Omnivoro")) {
						System.out.printf("%nID: %s, Nombre: %s, Edad: %s, Dieta: %s, Especie: %s, Nivel de amenaza: %d%n", dinos[i].getId(), dinos[i].getNombre(), dinos[i].getEdad(), dinos[i].getDieta(), dinos[i].getEspecie(), dinos[i].getNivelAmenaza());
					}
				}
			}
		}while (opcion != 4);

	}

	public static void imprimirInfo(Dinosaurio[] dinos) {
		
		for (int i = 0; i < dinos.length; i++) {
			if (dinos[i] != null) {
				System.out.printf("%nID: %s, Nombre: %s, Edad: %s, Dieta: %s, Especie: %s, Nivel de amenaza: %d%n", dinos[i].getId(), dinos[i].getNombre(), dinos[i].getEdad(), dinos[i].getDieta(), dinos[i].getEspecie(), dinos[i].getNivelAmenaza());
			}
		}	
	}

}
