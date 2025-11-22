package dominio;

import java.util.ArrayList;

import logica.ReportesVisitor;

public class RankingVisitor implements ReportesVisitor{
	private ArrayList<Jugador> jugadores = new ArrayList<>();
	private String detalles;
	
	private void ordenarKDA() {
		for(int i = 0; i < jugadores.size() - 1; i++) {
			for(int j = 0; j < jugadores.size() - i - 1; j++) {
				if(jugadores.get(j).getKda() < jugadores.get(j+1).getKda()) {
					Jugador aux = jugadores.get(j);
					jugadores.set(j, jugadores.get(j+1));
					jugadores.set(j+1, aux);
				}
			}
		}
		
		int index = 1;
		for(Jugador j: jugadores) {
			detalles += "\n" + index + ". " + j.getNickname() + "(" + j.getEquipo() + " - " + j.getRol() + ") - KDA: " + j.getKda();
			detalles += "\n";
			index++;
		}
	}

	@Override
	public void visitarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	@Override
	public String obtenerResultado() {
		ordenarKDA();
		String r = "\n=== RANKING DE JUGADORES ===";
		r += "\nMétrica: KDA\n";
		r += detalles;
		
		return r;
	}

}
