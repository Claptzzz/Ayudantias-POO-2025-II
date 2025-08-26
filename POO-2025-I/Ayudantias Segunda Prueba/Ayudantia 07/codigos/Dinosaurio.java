package dominio;

public abstract class Dinosaurio {
	protected int id;
	protected String tipo;
	protected String nombre;
	protected String especie;
	protected int edad;
	
	public Dinosaurio(int id, String tipo, String nombre, String especie, int edad) {
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	public abstract void mostrarFicha();

}
