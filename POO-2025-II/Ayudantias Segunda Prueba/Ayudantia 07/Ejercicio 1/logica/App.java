import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dominio.Sistema;

public class App {
	public static void leerArchivo(ISistema sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("alumnos.txt"));
		
		while(scan.hasNextLine()) {
			String[] partes = scan.nextLine().split(":");
			String nombre = partes[0];
			double notaEx1 = Double.parseDouble(partes[1]);
			double notaTalleres = Double.parseDouble(partes[2]);
			int clasesAsistidas = Integer.parseInt(partes[3]);
			
			sistema.agregarAlumno(nombre, notaEx1, notaTalleres, clasesAsistidas);
		}
		scan.close();
	}
	
	public static void desplegarMenu(ISistema sistema) {
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("---SISTEMA DE ALUMNOS---");
			System.out.println("1. Calcular nota necesaria de cada alumno");
			System.out.println("2. Calcular asistencia necesaria de cada alumno");
			System.out.println("3. Predecir estatus de cada alumno");
			System.out.println("4. Calcular y comparar tasas de aprobación");
			System.out.println("5. Salir");
			System.out.println("Opcion: ");
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch(opcion) {
				case 1:
					System.out.println(sistema.calcularNotaNecesariaPorAlumno());
					break;
				case 2:
					System.out.println(sistema.calcularAsistenciaNecesariaPorAlumno());
					break;
				case 3:
					System.out.println(sistema.predecirEstatus());
					break;
				case 4:
					System.out.println(sistema.compararTasasAprobacion());
					break;
			}
			
			
		} while(opcion !=5);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ISistema sistema = Sistema.getInstancia();
		leerArchivo(sistema);
		desplegarMenu(sistema);
	}
}