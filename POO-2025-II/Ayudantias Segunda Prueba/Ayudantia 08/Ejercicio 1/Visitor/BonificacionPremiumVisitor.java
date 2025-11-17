package Visitor;

import Dominio.Recurso;

public class BonificacionPremiumVisitor implements InventarioVisitor {
	
	private boolean esPremium;
	private int recursosModificados = 0;
	private String cambios = "";
	
	public BonificacionPremiumVisitor(boolean esPremium) {
		this.esPremium = esPremium;
	}

	@Override
	public void visitar(Recurso recurso) {
		if(!esPremium) {
			return;
		}
		
		int cantidadOriginal = recurso.getCantidad();
		int nuevaCantidad = (int)(cantidadOriginal*1.5); //aumentar 50%
		recurso.setCantidad(nuevaCantidad);

		cambios += recurso.getNombre() + ": " + cantidadOriginal + " -> " + nuevaCantidad + "\n";
		recursosModificados++;
	}

	@Override
	public String mostrarResultado() {
		String aux = "";
		aux += "------------------------------------------------------------\n";
		aux += "                    Bonificacion Premium                    \n";
		aux += "------------------------------------------------------------\n";
		
		if (!esPremium) {
			aux += "No corresponde a una cuenta premium\n";
			aux += "Sin bonificacion aplicada\n";
		} else {
			aux += cambios + "\n";
			aux += "------------------------------------------------------------\n";
			aux += "Bonificacion aplicada a " + recursosModificados + "recursos\n";
		}
		aux += "------------------------------------------------------------\n";
		return aux;
	}
}
