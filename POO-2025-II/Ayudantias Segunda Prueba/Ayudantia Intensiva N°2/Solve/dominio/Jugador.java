package dominio;

import logica.ReportesVisitor;
import logica.Visitable;

public abstract class Jugador implements Visitable{
	protected String nickname;
	protected String equipo;
	protected String rol;
	protected int kills;
	protected double kda;
	protected double muertesPorPartida;
	protected String estiloJuego;
	
	public Jugador(String nickname, String equipo, String rol, int kills, double kda, double muertesPorPartida, String estiloJuego) {
		this.nickname = nickname;
		this.equipo = equipo;
		this.rol = rol;
		this.kills = kills;
		this.kda = kda;
		this.muertesPorPartida = muertesPorPartida;
		this.estiloJuego = estiloJuego;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public double getKda() {
		return kda;
	}

	public void setKda(double kda) {
		this.kda = kda;
	}

	public double getMuertesPorPartida() {
		return muertesPorPartida;
	}

	public void setMuertesPorPartida(double muertesPorPartida) {
		this.muertesPorPartida = muertesPorPartida;
	}

	public String getEstiloJuego() {
		return estiloJuego;
	}

	public void setEstiloJuego(String estiloJuego) {
		this.estiloJuego = estiloJuego;
	}
	
	@Override
    public void aceptar(ReportesVisitor visitor) {
        visitor.visitarJugador(this);
    }
	
}
