package dominio;

import logica.EstrategiaPlanificacion;
import logica.Mision;

public class EstrategiaPorRecursos implements EstrategiaPlanificacion{

	@Override
	public void planificar(Mision mision) {
		System.out.println("[Estrategia: Recursos] Misión optimizada por uso de presupuesto.");
	}

}
