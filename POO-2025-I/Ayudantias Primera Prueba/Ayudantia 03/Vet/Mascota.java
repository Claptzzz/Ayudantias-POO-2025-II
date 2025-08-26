package dominio;

public class Mascota {
	
	private int id;
	private String nombre;
	private String especie;
	private int edad;
	private float peso;
	
	public Mascota(int id, String nombre, String especie, int edad, float peso) {
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.peso = peso;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", especie: " + especie + ", edad: " + edad + ", peso: " + peso;
	}
	
	

}
