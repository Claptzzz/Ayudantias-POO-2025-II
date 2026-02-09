package dominio;

import logica.EstrategiaPlanificacion;
import logica.Mision;

public class EstrategiaPorRiesgo implements EstrategiaPlanificacion{

	@Override
	public void planificar(Mision mision) {
		System.out.println("[Estrategia: Riesgo] Misión evaluada en función del nivel de peligro.");
	}
	
}
