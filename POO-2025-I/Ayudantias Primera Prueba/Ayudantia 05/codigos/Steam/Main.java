package Steam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main (String[] args) throws FileNotFoundException {
		
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		
		File arch = new File("Steam.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			
			String[] partes = s.nextLine().split(";");		
			juegos.add(new Juego(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
		}
		
		int opcion = 0;
		
		s = new Scanner(System.in);
		
		do {
			System.out.println("---------------------------------------------------------------");
			System.out.println("Bienvenido al menu");
			System.out.println("---------------------------------------------------------------");
			System.out.println("1) Buscar juego");
			System.out.println("2) Mostrar lista de mejores juegos");
			System.out.println("3) Agregar Juego");
			System.out.println("4) Salir");
			System.out.print("Ingrese opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			
			if (opcion == 1) {
				buscarjuego(juegos, s);
			}else if (opcion == 2) {
				imprimirLista(juegos);
			}else if (opcion == 3) {
				juegos = agregarJuego(juegos, s); //pregunta
			} else if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
				System.out.println("Invalido, reingrese.");
			}
			
		} while(opcion != 4);
		
		s.close();
	}

	private static void buscarjuego(ArrayList<Juego> juegos, Scanner s) {
		
		
		System.out.println("Desea buscar por ID o Nombre? ");
		String aux = s.next();
		boolean find = false;
		
		if (aux.equals("ID")) {
			System.out.println("Ingrese ID: ");
			int aux2 = s.nextInt();
			s.nextLine();
			for (int i = 0; i<juegos.size(); i++) {
				if (aux2 == juegos.get(i).getId()) {
					System.out.printf("ID: %d, Nombre: %s, Descuento: %d, Puntuación: %d, Puntuacion de Sort: %f%n", juegos.get(i).getId(), juegos.get(i).getName(), juegos.get(i).getDiscount(), juegos.get(i).getScore(), juegos.get(i).getSort());
					find = true;
				}
			}
		} else if (aux.equals("Nombre")) {
			System.out.println("Ingrese Nombre: ");
			String aux2 = s.next();
			for (int i = 0; i<juegos.size(); i++) {
				if (aux2.equals(juegos.get(i).getName())) {
					System.out.printf("ID: %d, Nombre: %s, Descuento: %d, Puntuación: %d, Puntuacion de Sort: %f%n", juegos.get(i).getId(), juegos.get(i).getName(), juegos.get(i).getDiscount(), juegos.get(i).getScore(), juegos.get(i).getSort());
					find = true;
				}
			}
		} else {
			System.out.println("opcion invalida.");
		}
		if(!find) {
			System.out.println("Juego no encontrado");
		}
		
	}

	private static void imprimirLista(ArrayList<Juego> juegos) {
		
		
		//
		ordenar(juegos);
		
		//imprimir
		
		for (int i=0; i<juegos.size(); i++) {
			
			System.out.printf("ID: %d, Nombre: %s, Descuento: %d, Puntuación: %d, Puntuacion de Sort: %f%n", juegos.get(i).getId(), juegos.get(i).getName(), juegos.get(i).getDiscount(), juegos.get(i).getScore(), juegos.get(i).getSort());
		}
		
	}

	private static void ordenar(ArrayList<Juego> juegos) {
		
		double actual = 0;
		//Calcular
		for (int i=0; i<juegos.size(); i++) {		
			actual = juegos.get(i).getDiscount() * juegos.get(i).getScore() * 0.8;
			juegos.get(i).setSort(actual);			
		}
		
		
        int n = juegos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (juegos.get(j).getSort() < juegos.get(j+1).getSort()) {
                    
                	Juego temp = juegos.get(j);
                    juegos.set(j, juegos.get(j + 1));
                    juegos.set(j + 1, temp);

                }
            }
        }
	}

	private static ArrayList<Juego> agregarJuego(ArrayList<Juego> juegos, Scanner s) {
		
		System.out.print("Ingrese nombre del juego: ");
		String name = s.next();
		System.out.print("Ingrese descuento en forma de int: ");
		int des = s.nextInt();
		s.nextLine();
		System.out.print("Ingrese puntuacion: ");
		int score = s.nextInt();
		s.nextLine();
		
		int id = 0;
		for (int i=0; i<juegos.size(); i++) {
			id++;
		}
		
		juegos.add(new Juego(id+1,name,des,score));

		return juegos;
	}
	
}
