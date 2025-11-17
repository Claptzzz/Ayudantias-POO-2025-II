package Strategy;

import Dominio.Recurso;

public interface EstrategiaRecoleccion {
	int recolectar(Recurso recurso);
	String getDescripcion();
	String getNombre();
}
