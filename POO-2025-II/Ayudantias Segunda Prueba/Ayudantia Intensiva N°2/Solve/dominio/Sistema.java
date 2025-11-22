package dominio;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import logica.ISistema;
import logica.OrdenamientoStrategy;
import logica.ReportesVisitor;

public class Sistema implements ISistema{
	private static Sistema instancia;
	private Scanner scan;
	private ArrayList<Torneo> torneos;
    private ArrayList<Equipo> equipos;
    private ArrayList<Jugador> jugadores;
    
    private Sistema() {
        torneos = new ArrayList<>();
        equipos = new ArrayList<>();
        jugadores = new ArrayList<>();
    }
	
	public static ISistema getInstancia() {
		if(instancia == null) {
			instancia = new Sistema();
		}
		
		return instancia;
	}
	
	public void cargarDatos() throws FileNotFoundException {
        cargarTorneos();
        cargarEquipos();
        cargarJugadores();
        vincularDatos(); // Relaciona equipos con torneos, jugadores con equipos
    }
	
	private void cargarTorneos() throws FileNotFoundException {
        scan = new Scanner(new File("Torneos.txt"));
        
        while(scan.hasNextLine()) {
        	String[] partes = scan.nextLine().split(";");
        	String id = partes[0];
        	String nombre = partes[1];
        	String estado = partes[2];
        	String mapa = partes[3];
        	String formato = partes[4];
        	
        	torneos.add(new Torneo(id, nombre, estado, mapa, formato));
        }
    }
    
    private void cargarEquipos() throws FileNotFoundException {
    	scan = new Scanner(new File("Equipos.txt"));
        
        while(scan.hasNextLine()) {
        	String[] partes = scan.nextLine().split(";");
        	String nombre = partes[0];
        	String nombreEntrenador = partes[1];
        	int experienciaEntrenador = Integer.parseInt(partes[2]);
        	
        	Equipo e = new Equipo(nombre, nombreEntrenador, experienciaEntrenador);
        	equipos.add(e);
        	
        	for(int i = 3; i < partes.length; i++) {
        		e.agregarNombreTorneo(partes[i]);
        	}
        }
    }
    
    private void cargarJugadores() throws FileNotFoundException {
    	scan = new Scanner(new File("Jugadores.txt"));
        
        while(scan.hasNextLine()) {
        	String[] partes = scan.nextLine().split(";");
        	String rol = partes[2];
        	jugadores.add(JugadorFactory.crearJugador(rol, partes));
        }
    }
    
    private void vincularDatos() {
    	for (Equipo e : equipos) {
            for (String nombreTorneo : e.getNombreTorneos()) {
                for (Torneo t : torneos) {
                    if (t.getId().equals(nombreTorneo)) {
                        e.agregarParticipacion(t);
                        t.agregarParticipante(e);
                        break; // Salir del loop una vez encontrado el torneo
                    }
                }
            }
        }
        
        for(Jugador j: jugadores) {
        	for(Equipo e: equipos) {
        		if(j.getEquipo().equals(e.getNombre())) {
        			e.agregarJugador(j);
        		}
        	}
        }
    }
    
    public ArrayList<Torneo> getTorneos() {
        return new ArrayList<>(torneos);
    }
    
    public ArrayList<Equipo> getEquipos() {
        return new ArrayList<>(equipos);
    }
    
    public ArrayList<Jugador> getJugadores() {
        return new ArrayList<>(jugadores);
    }
    
    /**
     * Obtiene el total de jugadores en el sistema
     */
    public int getTotalJugadores() {
        return jugadores.size();
    }
    
    /**
     * Obtiene el total de equipos en el sistema
     */
    public int getTotalEquipos() {
        return equipos.size();
    }
    
    /**
     * Obtiene el total de torneos en el sistema
     */
    public int getTotalTorneos() {
        return torneos.size();
    }
    
    /**
     * Verifica si un nombre de equipo ya existe
     * Usado en: Validación al crear equipos
     */
    public boolean existeEquipo(String nombre) {
        return buscarEquipoPorNombre(nombre) != null;
    }
    
    /**
     * Verifica si un ID de torneo ya existe
     * Usado en: Validación al crear torneos
     */
    public boolean existeTorneo(String id) {
        return buscarTorneoPorId(id) != null;
    }
    
    /**
     * Obtiene todos los nombres únicos de equipos
     * Usado en: ComboBox para seleccionar equipos
     */
    public ArrayList<String> obtenerNombresEquipos() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Equipo e : equipos) {
            nombres.add(e.getNombre());
        }
        return nombres;
    }
    
    /**
     * Obtiene información resumida del sistema
     * Usado en: Panel de inicio o estadísticas generales
     */
    public String obtenerResumenSistema() {
        return String.format(
            "Sistema de Gestión LoL eSports\n" +
            "────────────────────────────────\n" +
            "Torneos registrados: %d\n" +
            "Equipos registrados: %d\n" +
            "Jugadores registrados: %d",
            torneos.size(), equipos.size(), jugadores.size()
        );
    }

    /**
     * Busca un torneo por su ID
     * Usado en: Ver detalles de torneo
     */
	@Override
	public Torneo buscarTorneoPorId(String id) {
		for (Torneo t : torneos) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
	}

	/**
     * Busca un equipo por su nombre
     * Usado en: Ver roster del equipo
     */
	@Override
	public Equipo buscarEquipoPorNombre(String nombre) {
		for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
	}

	/**
     * Busca equipos que contengan el texto en su nombre
     * Usado en: Búsqueda en tiempo real en pestaña Equipos
     */
	@Override
	public ArrayList<Equipo> buscarEquiposPorNombre(String textoBusqueda) {
		ArrayList<Equipo> resultados = new ArrayList<>();
        String busqueda = textoBusqueda.toLowerCase();
        
        for (Equipo e : equipos) {
            if (e.getNombre().toLowerCase().contains(busqueda)) {
                resultados.add(e);
            }
        }
        return resultados;
	}

	/**
     * Obtiene todos los jugadores de un equipo específico
     * Usado en: Ver roster del equipo
     */
	@Override
	public ArrayList<Jugador> obtenerJugadoresDeEquipo(String nombreEquipo) {
		ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
        
        for (Jugador j : jugadores) {
            if (j.getEquipo().equals(nombreEquipo)) {
                jugadoresEquipo.add(j);
            }
        }
        return jugadoresEquipo;
	}

	/**
     * Obtiene todos los equipos que participan en un torneo
     * Usado en: Ver detalles de torneo
     */
	@Override
	public ArrayList<Equipo> obtenerEquiposDeTorneo(String idTorneo) {
		ArrayList<Equipo> equiposTorneo = new ArrayList<>();
        
        for (Equipo e : equipos) {
            if (e.participaEnTorneo(idTorneo)) {
                equiposTorneo.add(e);
            }
        }
        return equiposTorneo;
	}

	/**
     * Filtra jugadores por rol
     * Usado en: Filtros opcionales en pestaña Jugadores
     */
	@Override
	public ArrayList<Jugador> filtrarJugadoresPorRol(String rol) {
		ArrayList<Jugador> filtrados = new ArrayList<>();
        
        for (Jugador j : jugadores) {
            if (j.getRol().equalsIgnoreCase(rol)) {
                filtrados.add(j);
            }
        }
        return filtrados;
	}

	/**
     * Elimina un torneo del sistema
     * Usado en: Botón "Eliminar Torneo"
     */
	@Override
	public boolean eliminarTorneo(String idTorneo) {
		Torneo torneo = buscarTorneoPorId(idTorneo);
        if (torneo != null) {
            // Remover el torneo de los equipos que participan
            for (Equipo e : equipos) {
                e.removerTorneo(idTorneo);
            }
            return torneos.remove(torneo);
        }
        return false;
	}

	/**
     * Aplica un visitor a todos los jugadores del sistema
     * Usado en: Generar reportes
     */
	@Override
	public String aplicarVisitor(ReportesVisitor visitor) {
		for (Jugador jugador : jugadores) {
            jugador.aceptar(visitor);
        }
        return visitor.obtenerResultado();
	}

	/**
     * Aplica una estrategia de ordenamiento a la lista de jugadores
     * Usado en: Ordenar tabla de jugadores
     * IMPORTANTE: Retorna una NUEVA lista ordenada, no modifica la original
     */
	@Override
	public ArrayList<Jugador> aplicarOrdenamiento(OrdenamientoStrategy estrategia) {
		ArrayList<Jugador> jugadoresOrdenados = new ArrayList<>(jugadores);
        estrategia.ordenar(jugadoresOrdenados);
        return jugadoresOrdenados;
	}
}
