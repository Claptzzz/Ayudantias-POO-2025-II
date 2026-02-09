package clases;

public class Loader extends Personaje {
	
	private double escudoGenerado;
	private double mayorDistancia;
	private double cantOS;

	public Loader(String jugador, String tipo, double tiempoPartida, double danioPartida, double escudoGenerado, double mayorDistancia, double CantOS) {
		super(jugador, tipo, tiempoPartida, danioPartida);
		this.escudoGenerado = escudoGenerado;
		this.mayorDistancia = mayorDistancia;
		this.cantOS = cantOS;
	}
	public double getEscudoGenerado() {
		return escudoGenerado;
	}

	public void setEscudoGenerado(double escudoGenerado) {
		this.escudoGenerado = escudoGenerado;
	}

	public double getMayorDistancia() {
		return mayorDistancia;
	}

	public void setMayorDistancia(double mayorDistancia) {
		this.mayorDistancia = mayorDistancia;
	}

	public double getCantOS() {
		return cantOS;
	}

	public void setCantOS(double cantOS) {
		this.cantOS = cantOS;
	}
	@Override
	public String toString() {
		return "Loader [escudoGenerado=" + escudoGenerado + ", mayorDistancia=" + mayorDistancia + ", cantOS=" + cantOS
				+ ", jugador=" + jugador + ", tiempoPartida=" + tiempoPartida + ", danioPartida=" + danioPartida + "]";
	}

	
}
