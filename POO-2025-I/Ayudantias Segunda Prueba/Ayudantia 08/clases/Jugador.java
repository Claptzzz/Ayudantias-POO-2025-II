package clases;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Personaje> partidas;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		partidas = new ArrayList<>();
	}
	
	public String getName() {
		return nombre;
	}
	
	public void addPartida(Personaje p) {
		partidas.add(p);
	}
	
	

}
