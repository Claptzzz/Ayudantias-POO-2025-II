package Dominio;

public class Soldado {
	
	private String nombre;
	private String especialidad;
	private int edad;
	private int exp;
	private String ciudad;
	private int posx;
	private int posy;
	
	
	public Soldado(String nombre, String especialidad, int edad, int exp, String ciudad, int posx, int posy) {
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.edad = edad;
		this.exp = exp;
		this.ciudad = ciudad;
		this.posx = posx;
		this.posy = posy;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public int getEdad() {
		return edad;
	}

	public int getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return "Soldado [nombre=" + nombre + ", especialidad=" + especialidad + ", edad=" + edad + ", exp=" + exp
				+ ", ciudad=" + ciudad + ", posx=" + posx + ", posy=" + posy + "]";
	}

}
