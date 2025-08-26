package dominio;

import logica.EstrategiaPlanificacion;

public class EstrategiaSelector {
	public static EstrategiaPlanificacion seleccionar(int duracion, double presupuesto, String nivel) {
        if (nivel.equalsIgnoreCase("ALTO")) {
            return new EstrategiaPorRiesgo();
        } else if (presupuesto > 50000) {
            return new EstrategiaPorRecursos();
        } else if (duracion < 100) {
            return new EstrategiaPorTiempo();
        } else {
            return new EstrategiaPorRecursos(); // Estrategia por defecto
        }
    }
}
