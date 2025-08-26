/*
 * Nicolás Antonio Rojas Bustos C1 21.295.708-9

 * 
 * 
 */

package Musica;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//160 a 220 seg
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de canciones escuchadas: ");
		int x = s.nextInt();
		s.nextLine();
		int aux = 1;
		int total = 0;
		int min = 220;
		int max = 160;
		double totalAnuncios = 0;
		
		//ciclo para analizar el tiempo de las canciones
		for (int i=0; i<x; i++) {
			
			System.out.printf("%nIngrese la duracion de la cancion numero %d: ", aux);
			int actual = s.nextInt();
			s.nextLine();
			
			if (actual <= 220 && actual >= 160) {
				if (actual < min) {min = actual;}
				if (actual > max) {max = actual;}
				total += actual;
				totalAnuncios += actual;
				if (aux%3 == 0) {totalAnuncios += anuncios(actual);} 
				aux++;
			} else {
				System.out.println("\nDuracion invalida, reingrese.");
				i--;
			}
		}
		System.out.printf("%nEl tiempo total escuchado fue de: %d segundos.", total);
		System.out.printf("%nLa cancion con mayor duracion fue de: %d segundos, y la de menor duracion fue de: %d segundos.", max, min);
		System.out.printf("%nEl tiempo total con anuncios fue: %f", totalAnuncios);
		s.close();
		
	}
	//calcula el tiempo del anuncio
	public static double anuncios(int actual) {
		
		double anuncio = actual * 0.15;
		
		return anuncio;
	}
	
	
	
	
}
