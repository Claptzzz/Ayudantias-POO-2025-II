package logica;

import java.util.ArrayList;

import dominio.Jugador;

public interface OrdenamientoStrategy {
	void ordenar(ArrayList<Jugador> jugadores);
    String obtenerNombreEstrategia();
}
