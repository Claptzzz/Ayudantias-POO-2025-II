package Visitor;

import Dominio.Recurso;

public class ValorCalculadorVisitor implements InventarioVisitor {

	private int valorTotal = 0;
	private String detalles = "";
	
	@Override
	public void visitar(Recurso recurso) {
		int precioUnitario = recurso.getPrecioBase() + (recurso.getTier() * 20);
		int valorRecurso = recurso.getCantidad() * precioUnitario;
		valorTotal += valorRecurso;
		
		detalles += "Nombre: " + recurso.getNombre() + " (Tier " + recurso.getTier() + "): " + 
				recurso .getCantidad() + " x " + precioUnitario + " = " + valorRecurso + " $\n";
	}

	@Override
	public String mostrarResultado() {
		String aux = "";
		aux += "VALOR TOTAL INVENTARIO\n";
		aux += "------------------------------------------------------------\n";
		aux += detalles + "\n";
		aux += "------------------------------------------------------------\n";
		aux += "Total: " + valorTotal + "$\n";
		aux += "------------------------------------------------------------\n";
		return aux;
	}
	
	
}
