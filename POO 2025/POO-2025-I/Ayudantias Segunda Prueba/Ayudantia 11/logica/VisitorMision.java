package logica;

import dominio.Colonizacion;
import dominio.Exploracion;
import dominio.Investigacion;

public interface VisitorMision {
	void visitar(Exploracion m);
    void visitar(Colonizacion m);
    void visitar(Investigacion m);
}
