package SebastianNat;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		

		System.out.println("Ingrese X (cantidad de pruebas): ");
		double cantP = s.nextInt();
		s.nextLine();
		int aux = 1;
		double prom;
		int actual;
		int best = 0;
		double total = 0;
		
		for (int i=0; i<cantP; i++) {
			System.out.printf("%nIngrese tiempo de la prueba numero %d: ", aux);
			actual = s.nextInt();
			s.nextLine();
			//en el indice 0 el primer intento pasa a ser el mejor
			if (i==0) {best = actual;}
			else if (actual < best) {
				best = actual; 
			}
			aux++;
			total += actual;
		}
		//promedio
		prom = total / cantP;
		
		System.out.printf("%nSu mejor tiempo fue: %d segundos.", best);
		System.out.printf("%nSu promedio fue de: %f segundos", prom);
		
		s.close();
	}
	
	
}
