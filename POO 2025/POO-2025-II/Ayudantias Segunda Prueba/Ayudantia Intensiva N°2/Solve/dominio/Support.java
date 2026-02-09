package dominio;

public class Support extends Jugador{
	private int wardsColocados;
	private int wardsEliminados;
	private double utilidadProporcionada;

	public Support(String nickname, String equipo, String rol, int kills, double kda, double muertesPorPartida,
			String estiloJuego, int wardsColocados, int wardsEliminados, double utilidadProporcionada) {
		super(nickname, equipo, rol, kills, kda, muertesPorPartida, estiloJuego);
		this.wardsColocados = wardsColocados;
		this.wardsEliminados = wardsEliminados;
		this.utilidadProporcionada = utilidadProporcionada;
	}

	public int getWardsColocados() {
		return wardsColocados;
	}

	public void setWardsColocados(int wardsColocados) {
		this.wardsColocados = wardsColocados;
	}

	public int getWardsEliminados() {
		return wardsEliminados;
	}

	public void setWardsEliminados(int wardsEliminados) {
		this.wardsEliminados = wardsEliminados;
	}

	public double getUtilidadProporcionada() {
		return utilidadProporcionada;
	}

	public void setUtilidadProporcionada(double utilidadProporcionada) {
		this.utilidadProporcionada = utilidadProporcionada;
	}

	@Override
	public String toString() {
		return "Support [wardsColocados=" + wardsColocados + ", wardsEliminados=" + wardsEliminados
				+ ", utilidadProporcionada=" + utilidadProporcionada + ", nickname=" + nickname + ", equipo=" + equipo
				+ ", rol=" + rol + ", kills=" + kills + ", kda=" + kda + ", muertesPorPartida=" + muertesPorPartida
				+ ", estiloJuego=" + estiloJuego + "]";
	}
	
	

}
