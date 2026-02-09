package ruteo;

public class Velero {
	
	private String nombre;
	private int codigo;
	private int costoMantenimiento = 0;
	private static int costoMembresia;
	
	public Velero(String nombre, int codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	public void calcularMembresia(int dias) {
		costoMantenimiento = getCostoMantenimiento() + costoMembresia * dias;
	}

	public static void asignarMembresia(int costo) {
		costoMembresia = costo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCostoMantenimiento() {
		return costoMantenimiento;	
	}
	
}

























