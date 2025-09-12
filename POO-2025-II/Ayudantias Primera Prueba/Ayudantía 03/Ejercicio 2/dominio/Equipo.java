package dominio;

public class Equipo{
    private String nombreEquipo;
    private int numJugadores;
    private String region;
    private int anioFundacion;
    private Jugador[] jugadores = new Jugador[5];
    private int jugadoresActuales = 0;

    public Equipo(String nombreEquipo, int numJugadores, String region, int anioFundacion) {
        this.nombreEquipo = nombreEquipo;
        this.numJugadores = numJugadores;
        this.region = region;
        this.anioFundacion = anioFundacion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }
    public int getNumJugadores() {
        return numJugadores;
    }
    public String getRegion() {
        return region;
    }
    public int getAnioFundacion() {
        return anioFundacion;
    }
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }
    
    

    public Jugador[] getJugadores() {
		return jugadores;
	}

	public int getJugadoresActuales() {
		return jugadoresActuales;
	}

	public void agregarJugador(Jugador j) {
        if(jugadoresActuales < 5) {
            jugadores[jugadoresActuales] = j;
            jugadoresActuales++;
        } else {
            System.out.println("No se pueden agregar más jugadores al equipo.");
        }
    }

    public void mostrarInfoEquipo() {
        System.out.println("Nombre del Equipo: " + nombreEquipo);
        System.out.println("Número de Jugadores: " + numJugadores);
        System.out.println("Región: " + region);
        System.out.println("Año de Fundación: " + anioFundacion);
        System.out.println("Jugadores:");
        System.out.println("-------------------");
        for(int i = 0; i < jugadoresActuales; i++) {
            System.out.println("Jugador " + (i + 1) + ":");
            jugadores[i].mostrarInfo();
            System.out.println("Evaluación de Rendimiento: " + jugadores[i].evaluarRendimiento());
            System.out.println();
        }
    }

    public double calcularKillsPromedioEquipo() {
        double totalKills = 0;
        for(int i = 0; i < jugadoresActuales; i++) {
            totalKills += jugadores[i].getKillsPromedio();
        }
        return totalKills / jugadoresActuales;
    }
}
