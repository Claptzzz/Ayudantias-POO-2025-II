package Dominio;

public class Jugador {

	private String nombre;
	private boolean premium;
	
	public Jugador(String nombre, boolean premium) {
		this.nombre = nombre;
		this.premium = premium;
	}
	
	public String getTipoCuenta() {
		return this.premium ? "PREMIUM" : "FREE";
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
