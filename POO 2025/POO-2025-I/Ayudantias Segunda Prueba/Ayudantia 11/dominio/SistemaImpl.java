package dominio;

import java.util.ArrayList;

import logica.Sistema;
import logica.Mision;

public class SistemaImpl implements Sistema{
	private static SistemaImpl instancia;
	private ArrayList<Mision> misiones = new ArrayList<>();
	
	private SistemaImpl() {}
	
	public static SistemaImpl getInstancia() {
        if (instancia == null)
            instancia = new SistemaImpl();
        return instancia;
    }

	@Override
	public String crearYAgregarMisiones(String linea) {
		Mision m = MisionFactory.crearMision(linea);
		misiones.add(m);

		
		return "[MISION CARGADA] Misión " + linea;
		
	}

	@Override
	public void iniciarSistema() {
		System.out.println("");
		for(Mision mision: misiones) {
			mision.planificar();
		}
		
		System.out.println();
		
		EstadisticasVisitor visitor = new EstadisticasVisitor();
		for(Mision mision: misiones) {
			mision.aceptarVisitor(visitor);
		}
		
		visitor.mostrarEstadisticas();
	}
	
	
}
