package dominio;

public class Mid extends Jugador{
	private String tipoMid;

	public Mid(String nickname, String equipo, String rol, int kills, double kda, double muertesPorPartida,
			String estiloJuego, String tipoMid) {
		super(nickname, equipo, rol, kills, kda, muertesPorPartida, estiloJuego);
		this.tipoMid = tipoMid;
	}

	public String getTipoMid() {
		return tipoMid;
	}

	public void setTipoMid(String tipoMid) {
		this.tipoMid = tipoMid;
	}

	@Override
	public String toString() {
		return "Mid [tipoMid=" + tipoMid + ", nickname=" + nickname + ", equipo=" + equipo + ", rol=" + rol + ", kills="
				+ kills + ", kda=" + kda + ", muertesPorPartida=" + muertesPorPartida + ", estiloJuego=" + estiloJuego
				+ "]";
	}
	
	

}
