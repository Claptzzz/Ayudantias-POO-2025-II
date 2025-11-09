
public class AlumnoFactory {
	public static Alumno crearAlumno(String nombre, double notaExamen1, double notaTalleres, int clasesAsistidas) {
		return new Alumno(nombre, notaExamen1, notaTalleres, clasesAsistidas);
	}
}
