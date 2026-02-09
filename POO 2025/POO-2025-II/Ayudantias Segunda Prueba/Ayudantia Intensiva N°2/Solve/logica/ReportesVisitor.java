package logica;

import dominio.Jugador;

public interface ReportesVisitor {
	void visitarJugador(Jugador jugador);
    
    String obtenerResultado();
}
