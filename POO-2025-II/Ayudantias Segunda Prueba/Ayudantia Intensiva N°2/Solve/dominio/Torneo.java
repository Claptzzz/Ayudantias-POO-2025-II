package dominio;

import java.util.ArrayList;


public class Torneo{
	private String id;
	private String nombre;
	private String estado;
	private String mapa;
	private String formatoPartidas;
	private ArrayList<Equipo> participantes;
	
	public Torneo(String id, String nombre, String estado, String mapa, String formatoPartidas) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.mapa = mapa;
		this.formatoPartidas = formatoPartidas;
		this.participantes = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getFormatoPartidas() {
		return formatoPartidas;
	}

	public void setFormatoPartidas(String formatoPartidas) {
		this.formatoPartidas = formatoPartidas;
	}

	public ArrayList<Equipo> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Equipo> participantes) {
		this.participantes = participantes;
	}

	public void agregarParticipante(Equipo e) {
		participantes.add(e);
	}
	
	
}
