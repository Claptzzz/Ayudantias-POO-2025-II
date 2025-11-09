public interface ISistema {
	void agregarAlumno(String nombre, double Ex1, double Tall, int clasesAsistidas);
	String calcularNotaNecesariaPorAlumno();
	String calcularAsistenciaNecesariaPorAlumno();
	String predecirEstatus();
	String compararTasasAprobacion();
}