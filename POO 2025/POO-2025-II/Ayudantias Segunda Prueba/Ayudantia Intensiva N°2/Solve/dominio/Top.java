package dominio;

public class Top extends Jugador{
	private int usoTeleport;
	private int resistencia;

	public Top(String nickname, String equipo, String rol, int kills, double kda, double muertesPorPartida,
			String estiloJuego, int usoTeleport, int resistencia) {
		super(nickname, equipo, rol, kills, kda, muertesPorPartida, estiloJuego);
		this.usoTeleport = usoTeleport;
		this.resistencia = resistencia;
	}

	public int getUsoTeleport() {
		return usoTeleport;
	}

	public void setUsoTeleport(int usoTeleport) {
		this.usoTeleport = usoTeleport;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	@Override
	public String toString() {
		return "Top [usoTeleport=" + usoTeleport + ", resistencia=" + resistencia + ", nickname=" + nickname
				+ ", equipo=" + equipo + ", rol=" + rol + ", kills=" + kills + ", kda=" + kda + ", muertesPorPartida="
				+ muertesPorPartida + ", estiloJuego=" + estiloJuego + "]";
	}
	
	

}
