package clases;

public class Huntress extends Personaje {
	
	private double cantFlechas;
	private double velMax;

	public Huntress(String jugador, String tipo, double tiempoPartida, double danioPartida, double cantFlechas, double velMax) {
		super(jugador, tipo, tiempoPartida, danioPartida);
		this.cantFlechas = cantFlechas;
		this.velMax = velMax;
	}
	public double getCantFlechas() {
		return cantFlechas;
	}

	public void setCantFlechas(double cantFlechas) {
		this.cantFlechas = cantFlechas;
	}

	public double getVelMax() {
		return velMax;
	}

	public void setVelMax(double velMax) {
		this.velMax = velMax;
	}
	@Override
	public String toString() {
		return "Huntress [cantFlechas=" + cantFlechas + ", velMax=" + velMax + ", jugador=" + jugador
				+ ", tiempoPartida=" + tiempoPartida + ", danioPartida=" + danioPartida + "]";
	}

	
}
