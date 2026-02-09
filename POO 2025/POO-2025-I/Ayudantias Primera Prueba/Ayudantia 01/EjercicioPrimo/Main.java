package EjercicioPrimo;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.printf("Ingrese el digito a evaluar: ");
		int x = s.nextInt();
		s.nextLine();
		
		if (esPrimo(x)) {
			System.out.println("El numero es primo");
		} else {
			System.out.println("El numero no es primo");
		}
		s.close();
	}
	
	public static boolean esPrimo(int x) {
		
		if (x < 2) { return false; }
		
		//analizar desde 2 hasta su raiz cuadrada
		for (int i=2; i<=Math.sqrt(x); i++) {
			if (x % i == 0) {return false;} //si se puede dividir entonces no es primo
		}
		
		return true;
	}
	 
}
