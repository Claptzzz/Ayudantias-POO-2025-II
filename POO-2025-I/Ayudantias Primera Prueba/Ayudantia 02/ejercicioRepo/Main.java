package ejercicioRepo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		//5 niveles
		//guardar tiempo(seg) y oro.
		//usar vectores
		//usar bubbleSort
		
		Scanner s = new Scanner(System.in);
		int[] tiempoBrian = new int[5];
		int[] oroBrian = new int[5];
		int[] nivelBrian = new int[5];
		int[] tiempoDanilo = new int[5];
		int[] oroDanilo = new int[5];
		int[] nivelDanilo = new int[5];
		
		
		for (int i = 0; i<5; i++) {
			
			nivelBrian[i] = i+1;
			nivelDanilo[i] = i+1;
			System.out.printf("%nIngrese tiempo del nivel %d de Brian: ", i + 1);
			tiempoBrian[i] = s.nextInt();
			s.nextLine();
			System.out.printf("%nIngrese oro del nivel %d de Brian: ", i + 1);
			oroBrian[i] = s.nextInt();
			s.nextLine();
			System.out.printf("%nIngrese tiempo del nivel %d de Danilo: ", i + 1);
			tiempoDanilo[i] = s.nextInt();
			s.nextLine();
			System.out.printf("%nIngrese oro del nivel %d de Danilo: ", i + 1);
			oroDanilo[i] = s.nextInt();
			s.nextLine();
			
		}
		
		calculoPuntajes(tiempoBrian, oroBrian, nivelBrian, tiempoDanilo, oroDanilo, nivelDanilo);
		
		s.close();
	}

	public static void bubbleSort(double[] puntajes, int[] nivel, String name) {

        int n = puntajes.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (puntajes[j] < puntajes[j + 1]) {
                  
                    //intercambio
                    double temp = puntajes[j];
                    int tempNivel = nivel[j];
                    puntajes[j] = puntajes[j + 1];
                    nivel[j] = nivel[j+1];
                    puntajes[j + 1] = temp;
                    nivel[j + 1] = tempNivel;
                }
            }
        }
		
        System.out.printf("%nLos puntajes de %s son: ", name);
        
        for (int i=0; i < 5; i++) {
        	System.out.printf("%n-%f en el nivel %d", puntajes[i], nivel[i]);
        }
		
	}
	
	public static void calculoPuntajes(int[] tiempoBrian, int[] oroBrian, int[] nivelBrian, int[] tiempoDanilo, int[] oroDanilo, int[] nivelDanilo) {
		
		double[] puntajesBrian = new double[5];
		
		double[] puntajesDanilo = new double[5];
		
		for (int i = 0; i<5; i++) {
			
			puntajesBrian[i] = Math.sqrt(tiempoBrian[i] * oroBrian[i]);
			
			puntajesDanilo[i] = Math.sqrt(tiempoDanilo[i] * oroDanilo[i]);
			
		}
		
		bubbleSort(puntajesBrian, nivelBrian, "Brian");
		
		bubbleSort(puntajesDanilo, nivelDanilo, "Danilo");
		
		
	}
	
	
	
}
