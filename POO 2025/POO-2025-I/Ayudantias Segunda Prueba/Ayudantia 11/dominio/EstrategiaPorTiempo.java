package dominio;

import logica.EstrategiaPlanificacion;
import logica.Mision;

public class EstrategiaPorTiempo implements EstrategiaPlanificacion{
	@Override
	public void planificar(Mision mision) {
		System.out.println("[Estrategia: Tiempo] Misión planificada con enfoque en duración mínima.");
	}
}
