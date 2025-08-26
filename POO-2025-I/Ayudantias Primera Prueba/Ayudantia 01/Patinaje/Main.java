package Patinaje;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		
		int max = 0;
		int min = 11;
		int total = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese nombre del/la participante: ");
		String name = s.next(); 
		s.nextLine();
		
		for(int i=0; i<5; i++) {
			
			System.out.println("Ingrese calificacion: ");
			int actual = s.nextInt();
			s.nextLine();
			if (actual < min) {min = actual;}
			if (actual > max) {max = actual;}
			total += actual;
		}
		System.out.println(min + " " + max);
		total -= min + max;
		System.out.printf("Puntaje final obtenido de %s: %d",name, total);
		s.close();
	}
}
