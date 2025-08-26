package partidas;

import java.util.ArrayList;

import clases.Jugador;

public interface Sistema {
	
	String resumenJugador(int opcion);
	
	String resumenPartidas(int i);
	
	ArrayList<Jugador> getNombres();

	void addJugador(String jugador);

	void addHuntress(String jugador, String tipo, double tiempoPartida, double danioGenerado, double cantF,
			double velMax);

	void addEngineer(String jugador, String tipo, double tiempoPartida, double danioGenerado, double cantT);

	void addLoader(String jugador, String tipo, double tiempoPartida, double danioGenerado, double escudoG,
			double mayorDR, double cantOS);
	
	int getCantJugadores();
	
	String getJugador(int i);
	
	int getPartidasSize();
	
	String getTipo(int i);

}
