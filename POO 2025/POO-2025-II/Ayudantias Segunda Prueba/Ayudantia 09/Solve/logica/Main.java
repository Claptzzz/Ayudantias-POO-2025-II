package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Estudiante;
import gui.Menu;

public class Main {
	
	private static List<Estudiante> estudiantes = new ArrayList<>();
	
	public static void leerArchivo() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("Estudiantes.txt"));
		
		while(scan.hasNextLine()) {
			String[] partes = scan.nextLine().split(";");
			String rut = partes[0];
			String nombre = partes[1];
			String carrera = partes[2];
			int semestre = Integer.parseInt(partes[3]);
			double promedio = Double.parseDouble(partes[4]);
			
			estudiantes.add(new Estudiante(rut, nombre, carrera, semestre, promedio));
		}
		scan.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		leerArchivo();
		Menu menu = new Menu(estudiantes);
		menu.iniciar();
	}

}
