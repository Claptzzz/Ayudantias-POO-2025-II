package ejercicioMatriz;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner tecladoInt = new Scanner(System.in);
		Random rand = new Random();
		
		int opcion = 0;
		int[][] matriz = null;
		int tamanio = 0;
		
		do {
			System.out.println("\n----- Menú -----");
			System.out.println("1. Construir una matriz");
			System.out.println("2. Mostrar matriz");
			System.out.println("3. Mostrar suma de diagonal principal");
			System.out.println("4. Mostrar cantidad de números primos en la matriz");
			System.out.println("5. Transponer la matriz");
			System.out.println("6. Salir");
			System.out.print("> ");
			opcion = tecladoInt.nextInt();
			tecladoInt.nextLine();

			
			if (opcion == 1) {
				System.out.println("\n--- CONSTRUIR MATRIZ ---");
				do {
					System.out.print("Ingrese el tamaño de la matriz (2-10): ");
					tamanio = tecladoInt.nextInt();
					tecladoInt.nextLine();
					if (tamanio < 2 || tamanio > 10) {
						System.out.println("Ingrese un número dentro del rango!");
					}
				} while (tamanio < 2 || tamanio > 10);
				
				matriz = new int[tamanio][tamanio];
				
				// llena la matriz con numeros aleatorios del 1 al 100
				for (int i = 0; i < tamanio; i++) {
					for (int j = 0; j < tamanio; j++) {
						matriz[i][j] = rand.nextInt(100) + 1;
					}
				}
				System.out.println("Matriz generada correctamente.");
				
			} else if (opcion == 2) {
				if (matriz == null) {
					System.out.println("Primero debes contruir la matriz!");
				} else {
					System.out.println("\n--- MATRIZ ---");
					imprimirMatriz(matriz);
				}
				
			} else if (opcion == 3) {
				if (matriz == null) {
					System.out.println("Primero debes contruir la matriz!");
				} else {
					int sumaDiagonal = 0;
					for (int i = 0; i < tamanio; i++) {
						sumaDiagonal += matriz[i][i];
					}
					System.out.println("Suma de la diagonal principal: " + sumaDiagonal);
				}
				
			} else if (opcion == 4) {
				if (matriz == null) {
					System.out.println("Primero debes contruir la matriz!");
				} else {
					int cantPrimos = 0;
					for (int i = 0; i < tamanio; i++) {
						for (int j = 0; j < tamanio; j++) {
							if (esPrimo(matriz[i][j])) {
								cantPrimos++;
							}
						}
					}
					System.out.println("Cantidad de números primos en la matriz: " + cantPrimos);
				}
				
			} else if (opcion == 5) {
				if (matriz == null) {
					System.out.println("Primero debes contruir la matriz!");
				} else {
					int[][] matrizTranspuesta = new int[tamanio][tamanio];
					for (int i = 0; i < tamanio; i++) {
						for (int j = 0; j < tamanio; j++) {
							matrizTranspuesta[j][i] = matriz[i][j];
						}
					}
					System.out.println("\n--- MATRIZ TRANSPUESTA ---");
					imprimirMatriz(matrizTranspuesta);
				}
				
			} else if (opcion == 6) {
				System.out.println("Hasta luego :D");
				
			} else {
				System.out.println("Opción no válida!");
			}
			
		} while (opcion != 6);
		
		tecladoInt.close();
	}
	
	
    public static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
    
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    

	
	
	
}
