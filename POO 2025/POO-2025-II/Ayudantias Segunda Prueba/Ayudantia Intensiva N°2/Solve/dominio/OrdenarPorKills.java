package dominio;

import java.util.ArrayList;

import logica.OrdenamientoStrategy;

public class OrdenarPorKills implements OrdenamientoStrategy{

	@Override
	public void ordenar(ArrayList<Jugador> jugadores) {
		int n = jugadores.size();

	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            
	            // DESCENDENTE: mayor KDA primero
	            if (jugadores.get(j).getKills() < jugadores.get(j + 1).getKills()) {
	                
	                Jugador aux = jugadores.get(j);
	                jugadores.set(j, jugadores.get(j + 1));
	                jugadores.set(j + 1, aux);
	            }
	        }
	    }
	}

	@Override
	public String obtenerNombreEstrategia() {
		return "Ordenamiento por KDA";
	}

}
