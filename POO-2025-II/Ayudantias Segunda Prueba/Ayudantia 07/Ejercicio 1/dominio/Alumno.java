
public class Alumno {
	private String nombre;
	private double notaExamen1;
	private double notaTalleres;
	private int clasesAsistidas;
	
	public Alumno(String nombre, double ne, double nt, int ca) {
		this.nombre = nombre;
		this.notaExamen1 = ne;
		this.notaTalleres = nt;
		this.clasesAsistidas = ca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaExamen1() {
		return notaExamen1;
	}

	public void setNotaExamen1(double notaExamen1) {
		this.notaExamen1 = notaExamen1;
	}

	public double getNotaTalleres() {
		return notaTalleres;
	}

	public void setNotaTalleres(double notaTalleres) {
		this.notaTalleres = notaTalleres;
	}

	public int getClasesAsistidas() {
		return clasesAsistidas;
	}

	public void setClasesAsistidas(int clasesAsistidas) {
		this.clasesAsistidas = clasesAsistidas;
	}
	
	public double calcularNotaNecesaria(double porcEx1, double porcEx2) {
		double notaNecesaria = (4.0 - (notaExamen1 * porcEx1)) / porcEx2;
		return Math.round(notaNecesaria * 10.0) / 10.0;

	}
	
	public int calcularAsistenciaNecesaria(int clasesTotales, double porMinAsistencia) {
		 int asistencia = (int) ((porMinAsistencia * clasesTotales - clasesAsistidas) > 0 ? (porMinAsistencia * clasesTotales - clasesAsistidas) : 0);
		
		
		return asistencia;
	}
	
	public double calcularNotaExamenes(double porcEx1, double porcEx2) {
		return ((notaExamen1 * porcEx1) + (calcularNotaNecesaria(porcEx1, porcEx2) * porcEx2));
	}
	
	public double calcularNotaFinal(double porcEx1, double porcEx2) {
		return (((notaExamen1*porcEx1) + (calcularNotaNecesaria(porcEx1, porcEx2) * porcEx2)) * 0.65) + (notaTalleres * 0.35);
	}
	
}