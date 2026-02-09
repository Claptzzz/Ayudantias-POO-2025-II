package Visitor;

import Dominio.Recurso;

public interface InventarioVisitor {
	void visitar(Recurso recurso);
	String mostrarResultado();
}
