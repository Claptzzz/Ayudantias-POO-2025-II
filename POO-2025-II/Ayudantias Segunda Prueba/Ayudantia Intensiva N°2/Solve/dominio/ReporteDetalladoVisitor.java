package dominio;

import logica.ReportesVisitor;

public class ReporteDetalladoVisitor implements ReportesVisitor{
	private String detalles;

	@Override
	public void visitarJugador(Jugador jugador) {
		detalles += "\nJugador: " + jugador.getNickname();
		detalles += "\n  Equipo: " + jugador.getEquipo();
		detalles += "\n  Rol: " + jugador.getRol();
		detalles += "\n  Kills: " + jugador.getKills();
		detalles += "\n  Estilo de juego: " + jugador.getEstiloJuego();
		
		switch(jugador.getRol()) {
			case "Top":
				Top top = ((Top) jugador);
				detalles += "\n  Uso efectivo de teleports: " + top.getUsoTeleport() + " | " + "Resistencia: " + top.getResistencia();
				detalles += "\n";
				break;
			case "Jungle":
				Jungle jg = ((Jungle) jugador);
				detalles += "\n  Objetivos asegurados: " + jg.getObjetivosAsegurados() + " | " + "Ganks exitosos: " + jg.getGanksExitosos();
				detalles += "\n";
				break;
			case "Mid":
				Mid mid = ((Mid) jugador);
				detalles += "\n  Tipo mid: " + mid.getTipoMid();
				detalles += "\n";
				break;
			case "ADC":
				ADC adc = ((ADC) jugador);
				detalles += "\n  Farm por minuto: " + adc.getFarmPorMinuto() + " | " + "DPS: " + adc.getDanioPorSegundo();
				detalles += "\n";
				break;
			case "Support":
				Support supp = ((Support) jugador);
				detalles += "\n  Wards colocados: " + supp.getWardsColocados() + " | " + "Wards eliminados: " + supp.getWardsEliminados() + 
						" | " + "Utilidad proporcionada: " + supp.getUtilidadProporcionada();
				detalles += "\n";
				break;
		}
	}

	@Override
	public String obtenerResultado() {
		String r = "=== REPORTE DETALLADO DE JUGADORES ===";
		r += detalles;
		
		return r;
	}

}
