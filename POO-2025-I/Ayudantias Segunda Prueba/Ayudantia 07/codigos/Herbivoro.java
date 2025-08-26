package dominio;

import logica.Comportamiento;

public class Herbivoro extends Dinosaurio implements Comportamiento{
	private String altura;
	private String tipoDiente;

	public Herbivoro(int id, String tipo, String nombre, String especie, int edad, String altura, String tipoDiente) {
		super(id, tipo, nombre, especie, edad);
		this.altura = altura;
		this.tipoDiente = tipoDiente;
	}

	
	public String getAltura() {
		return altura;
	}

	
	public void setAltura(String altura) {
		this.altura = altura;
	}

	
	public String getTipoDiente() {
		return tipoDiente;
	}

	
	public void setTipoDiente(String tipoDiente) {
		this.tipoDiente = tipoDiente;
	}

	
	@Override
	public void mostrarFicha() {
		System.out.println("🦕 [HERBÍVORO]");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Altura: " + altura);
        System.out.println("Tipo de diente: " + tipoDiente);
	}


	@Override
	public void alimentarse() {
		System.out.println(nombre + " está pastando con sus dientes tipo " + tipoDiente);
		
	}


	@Override
    public void accionar() {
        System.out.println(nombre + " se mueve lentamente entre la vegetación, gracias a su altura " + altura + ".");
    }

}
