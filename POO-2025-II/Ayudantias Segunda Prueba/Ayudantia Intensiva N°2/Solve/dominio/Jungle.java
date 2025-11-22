package dominio;

public class Jungle extends Jugador{
	private int objetivosAsegurados;
	private int ganksExitosos;

	public Jungle(String nickname, String equipo, String rol, int kills, double kda, double muertesPorPartida,
			String estiloJuego, int objetivosAsegurados, int ganksExitosos) {
		super(nickname, equipo, rol, kills, kda, muertesPorPartida, estiloJuego);
		this.objetivosAsegurados = objetivosAsegurados;
		this.ganksExitosos = ganksExitosos;
	}

	public int getObjetivosAsegurados() {
		return objetivosAsegurados;
	}

	public void setObjetivosAsegurados(int objetivosAsegurados) {
		this.objetivosAsegurados = objetivosAsegurados;
	}

	public int getGanksExitosos() {
		return ganksExitosos;
	}

	public void setGanksExitosos(int ganksExitosos) {
		this.ganksExitosos = ganksExitosos;
	}

	@Override
	public String toString() {
		return "Jungle [objetivosAsegurados=" + objetivosAsegurados + ", ganksExitosos=" + ganksExitosos + ", nickname="
				+ nickname + ", equipo=" + equipo + ", rol=" + rol + ", kills=" + kills + ", kda=" + kda
				+ ", muertesPorPartida=" + muertesPorPartida + ", estiloJuego=" + estiloJuego + "]";
	}
	
	

}
