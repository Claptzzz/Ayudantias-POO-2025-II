package Logica;

public interface Sistema {
	
	
	
	void crearRecurso(int id, String nombre, String tipo, int cantidad, String zona, int tier);
	void addJugador(String nombre, boolean premium);
	String getNameJugador();
	String getCuentaJugador();
	String getEstrategiaActual();
	String verRecursos();
	String recolectar(int recurso);
	String cambiarEstrategia(int estrategia);
	String descripcionEstrategiaArriesgada();
	String descripcionEstrategiaSegura();
	String calcularPlata();
	String aplicarBonoPremium();
}
