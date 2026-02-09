package clases;

public class Engineer extends Personaje {
	
	private double cantTorretas;
	
	public Engineer(String jugador, String tipo, double tiempoPartida, double danioPartida, double cantTorretas) {
		super(jugador, tipo, tiempoPartida, danioPartida);
		this.cantTorretas = cantTorretas;
	}
	public double getCantTorretas() {
		return cantTorretas;
	}

	public void setCantTorretas(double cantTorretas) {
		this.cantTorretas = cantTorretas;
	}
	@Override
	public String toString() {
		return "Engineer [cantTorretas=" + cantTorretas + ", jugador=" + jugador + ", tiempoPartida=" + tiempoPartida
				+ ", danioPartida=" + danioPartida + "]";
	}
	
	
}
