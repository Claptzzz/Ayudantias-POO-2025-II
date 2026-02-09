package rawr;

public class Dinosaurio {
	
	private String id;
	private String nombre;
	private String edad;
	private String dieta;
	private String especie;
	private int nivelAmenaza;

	public Dinosaurio(String id, String nombre, String edad, String dieta, String especie, int nivelAmenaza) {
		
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.dieta = dieta;
		this.especie = especie;
		this.nivelAmenaza = nivelAmenaza;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEdad() {
		return edad;
	}
	
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public String getDieta() {
		return dieta;
	}
	
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public int getNivelAmenaza() {
		return nivelAmenaza;
	}
	
	public void setNivelAmenaza(int nivelAmenaza) {
		this.nivelAmenaza = nivelAmenaza;
	}
	
}

