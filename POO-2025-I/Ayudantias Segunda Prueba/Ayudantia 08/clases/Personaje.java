package clases;

public abstract class Personaje {

	protected String jugador;
	protected String tipo;
	protected double tiempoPartida;
	protected double danioPartida;
	
	public Personaje(String jugador, String tipo, double tiempoPartida, double danioPartida) {
		this.jugador = jugador;
		this.tipo = tipo;
		this.tiempoPartida = tiempoPartida;
		this.danioPartida = danioPartida;
	}
	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTiempoPartida() {
		return tiempoPartida;
	}

	public void setTiempoPartida(double tiempoPartida) {
		this.tiempoPartida = tiempoPartida;
	}

	public double getDanioPartida() {
		return danioPartida;
	}

	public void setDanioPartida(double danioPartida) {
		this.danioPartida = danioPartida;
	}
}
