package Strategy;

import java.util.Random;

import Dominio.Recurso;

public class EstrategiaArriesgada implements EstrategiaRecoleccion {
	
	private Random random = new Random();

	@Override
	public int recolectar(Recurso recurso) {
		int cantidadBase = 50;
		double multiplicador = recurso.getMultiplicadorZona();
		int riesgo = recurso.getRiesgoZona();
		
		System.out.println("Estrategia ARRIESGADA activada");
		System.out.printf("Recolectando %s en zona %s\n",recurso.getNombre(), recurso.getZona());
		System.out.printf("Cantidad base: %d (x%f)\n", cantidadBase, multiplicador);
		System.out.printf("Riesgo: %d\n", riesgo);
		
		int cantidadFinal = (int)(cantidadBase * multiplicador);
		
		if (random.nextInt(100) < riesgo) {
			System.out.println("Ataque!! perdiste el 50% de recursos");
			cantidadFinal /= 2;
		} else {
			System.out.println("Recoleccion existosa");
		}
		return cantidadFinal;
	}

	@Override
	public String getDescripcion() {
		return "Todas las zonas | x1-2 segun zona | Riesgo variable | Alto riesgo, alta recompensa";
	}

	@Override
	public String getNombre() {
		return "ARRIESGADA";
	}

}
