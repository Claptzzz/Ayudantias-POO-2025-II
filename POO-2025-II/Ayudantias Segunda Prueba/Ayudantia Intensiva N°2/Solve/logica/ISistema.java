package logica;

import java.util.ArrayList;

import dominio.Equipo;
import dominio.Jugador;
import dominio.Torneo;

public interface ISistema {
	Torneo buscarTorneoPorId(String id);
	Equipo buscarEquipoPorNombre(String nombre);
	ArrayList<Equipo> buscarEquiposPorNombre(String textoBusqueda);
	ArrayList<Jugador> obtenerJugadoresDeEquipo(String nombreEquipo);
	ArrayList<Equipo> obtenerEquiposDeTorneo(String idTorneo);
	ArrayList<Jugador> filtrarJugadoresPorRol(String rol);
	boolean eliminarTorneo(String idTorneo);
	String aplicarVisitor(ReportesVisitor visitor);
	ArrayList<Jugador> aplicarOrdenamiento(OrdenamientoStrategy estrategia);
}
