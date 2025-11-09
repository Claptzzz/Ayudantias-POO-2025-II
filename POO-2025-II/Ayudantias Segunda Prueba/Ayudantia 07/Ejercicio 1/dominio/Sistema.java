package dominio;

import java.util.ArrayList;

import logica.ISistema;

public class Sistema implements ISistema{
	private static Sistema instancia;
	
	private ArrayList<Alumno> alumnos = new ArrayList<>();
	private double porcEx1 = 0.47, porcEx2 = 0.53, porcMinAsistencia = 0.6;
	private int clasesTotales = 10;
	
	public static Sistema getInstancia() {
		if(instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}
	
	public void agregarAlumno(String nombre, double Ex1, double Tall, int clasesAsistidas) {
		Alumno alumno = AlumnoFactory.crearAlumno(nombre, Ex1, Tall, clasesAsistidas);
		alumnos.add(alumno);
	}

	@Override
	public String calcularNotaNecesariaPorAlumno() {
		String r = "";
		for(Alumno a: alumnos) {
			r += a.getNombre() + " necesita: " + a.calcularNotaNecesaria(porcEx1, porcEx2);
			r += "\n";
		}
		
		return r;
	}

	@Override
	public String calcularAsistenciaNecesariaPorAlumno() {
		String r = "";
		
		for(Alumno a: alumnos) {
			r += a.getNombre() + " necesita: " + a.calcularAsistenciaNecesaria(clasesTotales, porcMinAsistencia);
			r += "\n";
		}
		
		return r;
	}

	@Override
	public String predecirEstatus() {
		String r = "Según las métricas \n";
		
		for(Alumno a: alumnos) {
			r += a.getNombre() + " estará: ";
			double notaExamenes = a.calcularNotaExamenes(porcEx1, porcEx2);
			double notaTalleres = a.getNotaTalleres();
			double notaFinal = a.calcularNotaFinal(porcEx1, porcEx2);
			double porcAsistenciaActual = (double) a.getClasesAsistidas() / clasesTotales;
			
			r += notaExamenes >= 3.95 && notaTalleres >= 3.95 && notaFinal >= 3.95 && porcAsistenciaActual >= 0.6 ? "Está Aprobado": "Está Reprobado";
			r += "\n";
		}
		
		return r;
	}

	@Override
	public String compararTasasAprobacion() {
		String r = "";
		int totalAprobados = 0;
		
		for(Alumno a: alumnos) {
			if(a.calcularNotaFinal(porcEx1, porcEx2) >= 3.95) totalAprobados++;
		}
		
		int tasaAprobacion = (totalAprobados/alumnos.size()) * 100;
		if(tasaAprobacion > 25) {
			r += "La tasa de aprobación actual es mayor a la del semestre anterior por " + (tasaAprobacion - 25) + " puntos";
		} else {
			r += "La tasa de aprobación actual es menor a la del semestre anterior por " + (25 - tasaAprobacion) + " puntos";
		}
		
		return r;
	}

}
