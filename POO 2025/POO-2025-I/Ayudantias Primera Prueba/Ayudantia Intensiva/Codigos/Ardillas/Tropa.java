package Ardillas;

public class Tropa {

	private String id;
	private String nombre;
	private String armamento;
	private int fila;
	private int columna;
	private String raza;
	
	public Tropa(String id, String nombre, String armamento, int fila, int columna, String raza) {
		this.id = id;
		this.nombre = nombre;
		this.armamento = armamento;
		this.fila = fila;
		this.columna = columna;
		this.raza = raza;
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

	public String getArmamento() {
		return armamento;
	}

	public void setArmamento(String armamento) {
		this.armamento = armamento;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean canMove(String direccion, String[][] matriz) {
		int maxFilas = matriz.length;
		int maxColumnas = matriz[0].length;
		
		int f =moverFila(this.fila, direccion);
		int c =moverColumna(this.columna, direccion);
		
		if (f < 0) {return false;}
		if (c < 0) {return false;}
		if (f >= maxFilas) {return false;}
		if (c >= maxColumnas) {return false;}
		
		return true;
	}
	private int moverColumna(int columna2, String direccion) {
		
		if ("E".equalsIgnoreCase(direccion)) {
			return columna + 1;
		} else if ("O".equalsIgnoreCase(direccion)) {
			return columna - 1;
		}
		return columna;
	}
	private int moverFila(int fila2, String direccion) {
		
		if ("S".equalsIgnoreCase(direccion)) {
			return fila + 1;
		} else if ("N".equalsIgnoreCase(direccion)) {
			return fila - 1;
		}
		return fila;
	}
	public void mover(String direccion, String[][] matriz) {
		
		this.fila = moverFila(this.fila, direccion);
		this.columna = moverColumna(this.columna, direccion);
		
	}
	
	
}
