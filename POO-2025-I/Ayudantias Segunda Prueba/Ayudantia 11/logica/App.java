package logica;

import java.util.Scanner;

import dominio.SistemaImpl;

import java.io.File;
import java.io.FileNotFoundException;

public class App {
	public static void leerArchivo(Sistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("misiones.txt"));
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			System.out.println(sistema.crearYAgregarMisiones(linea));
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Sistema sistema = SistemaImpl.getInstancia();
		
		leerArchivo(sistema);
		sistema.iniciarSistema();
		
	}
}
