package dominio;

import logica.Comportamiento;

public class Carnivoro extends Dinosaurio implements Comportamiento{
	private String habilidad;
	private String tecnicaCaza;

	public Carnivoro(int id, String tipo, String nombre, String especie, int edad, String habilidad, String tecnicaCaza) {
		super(id, tipo, nombre, especie, edad);
		this.habilidad = habilidad;
		this.tecnicaCaza = tecnicaCaza;
	}

	
	public String getHabilidad() {
		return habilidad;
	}

	
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	
	public String getTecnicaCaza() {
		return tecnicaCaza;
	}

	
	public void setTipoDiente(String tecnicaCaza) {
		this.tecnicaCaza = tecnicaCaza;
	}

	
	@Override
	public void mostrarFicha() {
		System.out.println("🦖 [CARNÍVORO]");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Habilidad: " + habilidad);
        System.out.println("Técnica de caza: " + tecnicaCaza);
	}


	@Override
	public void alimentarse() {
		System.out.println(nombre + " está cazando con su técnica: " + tecnicaCaza + ".");
		
	}


	@Override
    public void accionar() {
        System.out.println(nombre + " usa su habilidad de " + habilidad + " para acechar a su presa.");
    }

}
