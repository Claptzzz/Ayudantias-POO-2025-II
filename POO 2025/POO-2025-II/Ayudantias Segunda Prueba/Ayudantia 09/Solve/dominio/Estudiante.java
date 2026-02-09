package dominio;

public class Estudiante {
	private String rut;
	private String nombre;
	private String carrera;
	private int semestre;
	private double promedio;
	
	public Estudiante(String rut, String nombre, String carrera, int semestre, double promedio) {
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.semestre = semestre;
		this.promedio = promedio;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "RUN: " + rut + "\nNombre: " + nombre + "\nCarrera: " + carrera + "\nSemestre: " + semestre + "\nPromedio: " + promedio;
	}
	
	
}
