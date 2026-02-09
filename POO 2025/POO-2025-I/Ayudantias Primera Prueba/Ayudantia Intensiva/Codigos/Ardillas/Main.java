package Ardillas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Tropa> tropasH = new ArrayList<Tropa>();
		ArrayList<Tropa> tropasA = new ArrayList<Tropa>();
		
		File arch = new File("GuerraDeLaBellota.txt");
		Scanner s = new Scanner(arch);
		
		int tamañoM = Integer.parseInt(s.nextLine());
		int cantH = Integer.parseInt(s.nextLine());
		int cantA = Integer.parseInt(s.nextLine());
		
		for(int i=0; i<cantH;i++) {
			String[] partes = s.nextLine().split(";");
			tropasH.add(new Tropa(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), partes[5] ));
		}
		for(int i=0; i<cantA;i++) {
			String[] partes = s.nextLine().split(";");
			tropasA.add(new Tropa(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), partes[5] ));
		}
		
		String[][] matriz = generarMatriz(tamañoM, tropasH, tropasA);
		
		menu(tropasA,tropasH,matriz, s);
		
	}

	private static void menu(ArrayList<Tropa> tropasA, ArrayList<Tropa> tropasH, String[][] matriz, Scanner s) {

		int opcion = 0;
		int turno = 0;
		s = new Scanner(System.in);
		
		do {
			
			if (turno == 0) {
				System.out.println("Turno Ardillas");
			} else if(turno == 1) {
				System.out.println("Turno Humanos");
			}
			System.out.println("---------------------------------------------------------------------");
			imprimir(matriz);
			System.out.println("---------------------------------------------------------------------");
			
			System.out.println("1) Mover tropa");
			System.out.println("2) Ver informacion tropa");
			System.out.println("3) Rendirse");
			System.out.print("Ingrese opcion: ");
			opcion = s.nextInt();
			
			if (opcion == 1) {
				moverTropa(tropasA, tropasH, matriz, s, turno);
				if (turno == 1) {turno = 0;}
				else if(turno == 0) {turno = 1;}	
				
			} else if(opcion == 2) {
				verInfo(tropasA,tropasH,turno, s);
				if (turno == 1) {turno = 0;}
				else if(turno == 0) {turno = 1;}
				
				
			}else if (opcion != 1 && opcion !=2 && opcion != 3) {
				System.out.println("Opcion invalida, reingrese.");
			}
		
		} while(opcion != 3);
		
		if (turno == 1) {
			System.out.println("Las ardillas ganan");
		} else if (turno == 0) {
			System.out.println("Los humanos ganan");
		}
		
		
		
	}

	private static void moverTropa(ArrayList<Tropa> tropasA, ArrayList<Tropa> tropasH, String[][] matriz, Scanner s, int turno) {
		
		System.out.println("Ingrese ID de tropa a mover: ");
		String id = s.next();
		boolean continuar = false;
		Tropa t = null;
		
		for (int i=0; i<tropasA.size(); i++) {
			if (tropasA.get(i).getId().equals(id) && turno == 0) {
				continuar = true;
				t = tropasA.get(i);
			}
		}
		for (int i=0; i<tropasH.size(); i++) {
			if (tropasH.get(i).getId().equals(id) && turno == 1) {
				continuar = true;
				t = tropasH.get(i);
			}
		}
		if (continuar) {
			System.out.println("Seleccione direccion (O,E,S,N): ");
			String direccion = s.next();
			if (t.canMove(direccion, matriz)) {
				int filaAnt = t.getFila();
				int columnaAnt = t.getColumna();
				t.mover(direccion, matriz);
				
				int fila = t.getFila();
				int columna = t.getColumna();
				
				if (matriz[fila][columna].equals("0")) {
					matriz[fila][columna] = t.getId();
					matriz[filaAnt][columnaAnt] = "0";
				} else {
					String idEnemy = matriz[fila][columna];
					Tropa z = null;
					for (int i = 0; i<tropasA.size(); i++) {
						if (tropasA.get(i).getId().equals(idEnemy)) {
							z = tropasA.get(i);
						}
					}
					for (int i = 0; i<tropasH.size(); i++) {
						if (tropasH.get(i).getId().equals(idEnemy)) {
							z = tropasH.get(i);
						}
					}
					if (z.getRaza().equals(t.getRaza())) {
						System.out.println("Los aliados no combaten entre si.");
					} else {
						Tropa ganadora = simulacion(t, z, tropasA, tropasH);
						matriz[fila][columna] = ganadora.getId();
						matriz[filaAnt][columnaAnt] = "0";
					}	
				}
			} else {
				System.out.println("No se puede mover en esa direccion.");
			}		
		} else {
			System.out.println("No es posible mover esa tropa.");
		}
		
	}
	
	
	private static Tropa simulacion(Tropa t, Tropa z, ArrayList<Tropa> tropasA, ArrayList<Tropa> tropasH) {

		if (t.getArmamento().equals("Ligero") && z.getArmamento().equals("Pesado")) {
			return t;
		} else if (t.getArmamento().equals("Mediano") && z.getArmamento().equals("Ligero")) {
			return t;
		} else if (t.getArmamento().equals("Pesado") && z.getArmamento().equals("Mediano")) {
			return t;
		} else {
			return z;
		}
	}

	private static void verInfo(ArrayList<Tropa> tropasA, ArrayList<Tropa> tropasH, int turno, Scanner s) {

		System.out.print("Ingrese id a revisar: ");
		String id = s.next();
		boolean encontrado = false;
		
		if (turno == 1) {
			for (int i=0; i<tropasH.size(); i++) {
				if (id.equals(tropasH.get(i).getId())) {
					System.out.printf("ID: %s, Nombre: %s, Armamento: %s%n", tropasH.get(i).getId(), tropasH.get(i).getNombre(), tropasH.get(i).getArmamento());
					encontrado = true;
				}
			}
		} else if (turno == 0) {
			for (int i=0; i<tropasA.size(); i++) {
				if (id.equals(tropasA.get(i).getId())) {
					System.out.printf("ID: %s, Nombre: %s, Armamento: %s%n", tropasA.get(i).getId(), tropasA.get(i).getNombre(), tropasA.get(i).getArmamento());
					encontrado = true;
				}
			}
		}
		if (!encontrado) {
			System.out.println("ID no encontrado en las filas aliadas.");
		}
		
	}

	private static void imprimir(String[][] matriz) {

		for (int i = 0;i<matriz.length; i++) {
			for (int j = 0; j<matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	private static String[][] generarMatriz(int tamañoM, ArrayList<Tropa> tropasH, ArrayList<Tropa> tropasA) {
		
		String[][] matriz = new String[tamañoM][tamañoM];
		boolean aux = false;
		
		
		//Rellenar
		
		for(int i = 0; i<tamañoM; i++) {
			for(int j = 0; j<tamañoM; j++) {	
				aux = false;
				for (int a = 0; a<tropasH.size(); a++) {
					if (tropasH.get(a).getFila() == i && tropasH.get(a).getColumna() == j) {
						matriz[i][j] = tropasH.get(a).getId();
						aux = true;
					}
				}
				for (int b = 0; b<tropasA.size(); b++) {
					if (tropasA.get(b).getFila() == i && tropasA.get(b).getColumna() == j) {
						matriz[i][j] = tropasA.get(b).getId();
						aux = true;
					}
				}
				if (!aux) {
					matriz[i][j] = "0";
				}		
			}
				
		}
		return matriz;
	}
	
	
}
