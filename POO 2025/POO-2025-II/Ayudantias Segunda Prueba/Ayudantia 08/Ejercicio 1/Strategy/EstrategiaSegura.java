package Strategy;

import Dominio.Recurso;

public class EstrategiaSegura implements EstrategiaRecoleccion {

	@Override
	public int recolectar(Recurso recurso) {
		int cantidadBase = 50;
		
		
		
		System.out.println("Recoleccion segura activada");
		System.out.printf("Recolectando: %s en zona verde\n", recurso.getNombre());
		System.out.printf("Cantidad %d (x1)\n", cantidadBase);
		System.out.println("Riesgo: 0%");
		
		return cantidadBase;
	}

	@Override
	public String getDescripcion() {
		return "Solo zonas verdes | x1 cantidad | 0% riesgo | Seguro pero sin bonificaciones";
	}

	@Override
	public String getNombre() {
		return "SEGURA";
	}

}
