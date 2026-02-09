package dominio;

public class ADC extends Jugador{
	private double farmPorMinuto;
	private int danioPorSegundo;
	
	public ADC(String nickname, String equipo, String rol, int kills, double kda, double muertesPorPartida,
			String estiloJuego, double farmPorMinuto, int danioPorSegundo) {
		super(nickname, equipo, rol, kills, kda, muertesPorPartida, estiloJuego);
		this.farmPorMinuto = farmPorMinuto;
		this.danioPorSegundo = danioPorSegundo;
	}

	public double getFarmPorMinuto() {
		return farmPorMinuto;
	}

	public void setFarmPorMinuto(double farmPorMinuto) {
		this.farmPorMinuto = farmPorMinuto;
	}

	public int getDanioPorSegundo() {
		return danioPorSegundo;
	}

	public void setDanioPorSegundo(int danioPorSegundo) {
		this.danioPorSegundo = danioPorSegundo;
	}

	@Override
	public String toString() {
		return "ADC [farmPorMinuto=" + farmPorMinuto + ", danioPorSegundo=" + danioPorSegundo + ", nickname=" + nickname
				+ ", equipo=" + equipo + ", rol=" + rol + ", kills=" + kills + ", kda=" + kda + ", muertesPorPartida="
				+ muertesPorPartida + ", estiloJuego=" + estiloJuego + "]";
	}
	
	
	
}
