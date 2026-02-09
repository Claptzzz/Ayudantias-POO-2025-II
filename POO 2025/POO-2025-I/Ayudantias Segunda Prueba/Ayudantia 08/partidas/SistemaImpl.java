package partidas;


import java.util.ArrayList;


import clases.Engineer;
import clases.Huntress;
import clases.Jugador;
import clases.Loader;
import clases.Personaje;

public class SistemaImpl implements Sistema {
	
	public static ArrayList<Personaje> partidas = new ArrayList<>();
	public static ArrayList<Jugador> jugadores = new ArrayList<>();

	@Override
	public String resumenJugador(int opcion) {
		
		double auxT = 0;
		double auxD = 0;
		String aux;
		switch (opcion) {
		case 1:
			for (int i = 0; i<partidas.size(); i++) {
				if (partidas.get(i).getJugador().equals(jugadores.get(0).getName())) {
					auxT += partidas.get(i).getTiempoPartida();
					auxD += partidas.get(i).getDanioPartida();
				}
			}
			aux = jugadores.get(0).getName() + " ha jugado " + auxT + " minutos, y ha hecho " + auxD + " de daño.";
			
			return aux;
		case 2:
			for (int i = 0; i<partidas.size(); i++) {
				if (partidas.get(i).getJugador().equals(jugadores.get(1).getName())) {
					auxT += partidas.get(i).getTiempoPartida();
					auxD += partidas.get(i).getDanioPartida();
				}
			}
			aux = jugadores.get(1).getName() + " ha jugado " + auxT + " minutos, y ha hecho " + auxD + " de daño.";
		
			return aux;
		case 3:
			for (int i = 0; i<partidas.size(); i++) {
				if (partidas.get(i).getJugador().equals(jugadores.get(2).getName())) {
					auxT += partidas.get(i).getTiempoPartida();
					auxD += partidas.get(i).getDanioPartida();
				}
			}
			
			aux = jugadores.get(2).getName() + " ha jugado " + auxT + " minutos, y ha hecho " + auxD + " de daño.";
			
			return aux;
		}
		return "";

	}


	@Override
	public String resumenPartidas(int i) {
		
		String aux = partidas.get(i).toString();
		
		return aux;
		
	}

	@Override
	public ArrayList<Jugador> getNombres() {
		return jugadores;
	}


	@Override
	public void addJugador(String jugador) {
		
		boolean aux = false;
		
		for (Jugador i : jugadores) {
			if (i.getName().equals(jugador)) {
				aux = true;
			}
		}
		if (!aux) { 
			jugadores.add(new Jugador(jugador));	
		}
		
		
	}


	@Override
	public void addHuntress(String jugador, String tipo, double tiempoPartida, double danioGenerado, double cantF,
			double velMax) {
		
		Personaje p = new Huntress(jugador, tipo, tiempoPartida, danioGenerado, cantF, velMax);
		partidas.add(p);
		for (Jugador i : jugadores) {
			if (i.getName().equals(jugador)) {
				i.addPartida(p);
			}
		}
		
	}


	@Override
	public void addEngineer(String jugador, String tipo, double tiempoPartida, double danioGenerado, double cantT) {
		
		Personaje p = new Engineer(jugador, tipo, tiempoPartida, danioGenerado, cantT);
		partidas.add(p);
		for (Jugador i : jugadores) {
			if (i.getName().equals(jugador)) {
				i.addPartida(p);
			}
		}
		
	}


	@Override
	public void addLoader(String jugador, String tipo, double tiempoPartida, double danioGenerado, double escudoG,
			double mayorDR, double cantOS) {
		
		Personaje p = new Loader(jugador, tipo, tiempoPartida, danioGenerado, escudoG, mayorDR, cantOS);
		partidas.add(p);
		for (Jugador i : jugadores) {
			if (i.getName().equals(jugador)) {
				i.addPartida(p);
			}
		}
		
	}


	@Override
	public int getCantJugadores() {
		return jugadores.size();
	}


	@Override
	public String getJugador(int i) {
		return jugadores.get(i).getName();
	}


	@Override
	public int getPartidasSize() {
		return partidas.size();
	}


	@Override
	public String getTipo(int i) {
		// TODO Auto-generated method stub
		return partidas.get(i).getTipo();
	}
	
	

}
