package dominio;

import java.util.ArrayList;

import logica.ReportesVisitor;
import logica.Visitable;

public class Equipo{
	private String nombre;
	private String nombreEntrenador;
	private int experienciaEntrenador;
	private ArrayList<String> nombreTorneos;
	private ArrayList<Torneo> torneosParticipados;
	private ArrayList<Jugador> jugadores;
	
	public Equipo(String nombre, String nombreEntrenador, int experienciaEntrenador) {
		this.nombre = nombre;
		this.nombreEntrenador = nombreEntrenador;
		this.experienciaEntrenador = experienciaEntrenador;
		nombreTorneos = new ArrayList<>();
		this.torneosParticipados = new ArrayList<>();
		this.jugadores = new ArrayList<>();
	}

	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getNombreEntrenador() {
		return nombreEntrenador;
	}



	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}



	public int getExperienciaEntrenador() {
		return experienciaEntrenador;
	}



	public void setExperienciaEntrenador(int experienciaEntrenador) {
		this.experienciaEntrenador = experienciaEntrenador;
	}



	public ArrayList<Torneo> getTorneosParticipados() {
		return torneosParticipados;
	}



	public void setTorneosParticipados(ArrayList<Torneo> torneosParticipados) {
		this.torneosParticipados = torneosParticipados;
	}



	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	
	

	public ArrayList<String> getNombreTorneos() {
		return nombreTorneos;
	}



	public void setNombreTorneos(ArrayList<String> nombreTorneos) {
		this.nombreTorneos = nombreTorneos;
	}



	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void agregarNombreTorneo(String nombre) {
		nombreTorneos.add(nombre);
	}

	public void agregarParticipacion(Torneo t) {
		torneosParticipados.add(t);
	}
	
	public void agregarJugador(Jugador j) {
		if(jugadores.size() >= 5) {
			System.out.println("No se pueden agregar mas jugadores.");
			return;
		}
		jugadores.add(j);
	}

	public boolean participaEnTorneo(String idTorneo) {
		for(Torneo t: torneosParticipados) {
			if(t.getId().equals(idTorneo)) return true;
		}
		
		return false;
	}
	
	public void removerTorneo(String idTorneo) {
		for(Torneo t: torneosParticipados) {
			if(t.getId().equals(idTorneo)) torneosParticipados.remove(t);
		}
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", nombreEntrenador=" + nombreEntrenador + ", experienciaEntrenador="
				+ experienciaEntrenador + ", torneosParticipados=" + torneosParticipados + ", jugadores=" + jugadores
				+ "]";
	}
	
	
	
	
}
