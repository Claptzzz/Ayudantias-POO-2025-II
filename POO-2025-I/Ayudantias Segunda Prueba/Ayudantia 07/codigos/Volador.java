package dominio;

import logica.Comportamiento;

public class Volador extends Dinosaurio implements Comportamiento{
	private String envergadura;
	private String tipoVuelo;

	public Volador(int id, String tipo, String nombre, String especie, int edad, String envergadura, String tipoVuelo) {
		super(id, tipo, nombre, especie, edad);
		this.envergadura = envergadura;
		this.tipoVuelo = tipoVuelo;
	}

	
	public String getEnvergadura() {
		return envergadura;
	}

	
	public void setEnvergadura(String envergadura) {
		this.envergadura = envergadura;
	}

	
	public String getTipoVuelo() {
		return tipoVuelo;
	}

	
	public void setTipoDiente(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	
	@Override
	public void mostrarFicha() {
		System.out.println("🦅 [VOLADOR]");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Envergadura de alas: " + envergadura);
        System.out.println("Tipo de vuelo: " + tipoVuelo);
	}


	@Override
    public void alimentarse() {
        System.out.println(nombre + " atrapa peces en vuelo usando su estilo " + tipoVuelo + ".");
    }


	@Override
    public void accionar() {
        System.out.println(nombre + " despliega sus alas de " + envergadura + " y sobrevuela el valle.");
    }

}
