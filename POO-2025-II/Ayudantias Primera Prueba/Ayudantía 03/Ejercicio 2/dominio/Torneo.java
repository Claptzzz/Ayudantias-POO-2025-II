package dominio;

public class Torneo {
    private Equipo[] equipos = new Equipo[8];
    private int[][] resultados = new int[8][8];
    private int totalEquipos = 0;
    
    

    public Equipo[] getEquipos() {
		return equipos;
	}

	public int[][] getResultados() {
		return resultados;
	}

	public int getTotalEquipos() {
		return totalEquipos;
	}

	public void cargarEquipo(Equipo e) {
        if(totalEquipos < 8) {
            equipos[totalEquipos] = e;
            totalEquipos++;
        } else {
            System.out.println("No se pueden agregar más equipos al torneo.");
        }
    }

    public void mostrarEquipos(){
        for(int i = 0; i < totalEquipos; i++) {
            System.out.println("Equipo " + (i + 1) + ":");
            equipos[i].mostrarInfoEquipo();
            System.out.println();
        }
    }

    public void buscarJugador(String nick) {
        for(int i = 0; i < totalEquipos; i++) {
            for(int j = 0; j < 5; j++) {
                if(equipos[i].getJugadores()[j] != null && equipos[i].getJugadores()[j].getNick().equalsIgnoreCase(nick)) {
                    System.out.println("Jugador encontrado en el equipo " + equipos[i].getNombreEquipo() + ":");
                    equipos[i].getJugadores()[j].mostrarInfo();
                    return;
                }
            }
        }
        System.out.println("Jugador no encontrado.");

    }

    public void generarEnfrentamientos(){
        for(int i = 0; i < totalEquipos; i++) {
            for(int j = 0; j < totalEquipos; j++) {
                if(i != j) {
                    resultados[i][j] = (int)(Math.random() * 3); // 0: empate, 1: equipo i gana, 2: equipo j gana
                } else {
                    resultados[i][j] = -1; // No se juega contra sí mismo
                }
            }
        }
    }

    public void mostrarTabla(){
        System.out.printf("%-15s", "Equipo");
        for(int i = 0; i < totalEquipos; i++) {
            System.out.printf("%-10s", equipos[i].getNombreEquipo());
        }
        System.out.println();

        for(int i = 0; i < totalEquipos; i++) {
            System.out.printf("%-15s", equipos[i].getNombreEquipo());
            for(int j = 0; j < totalEquipos; j++) {
                String simbolo;
                if(resultados[i][j] == -1) {
                    simbolo = "—";
                } else if(resultados[i][j] == 0) {
                    simbolo = "=";
                } else if(resultados[i][j] == 1) {
                    simbolo = "✔";
                } else {
                    simbolo = "✘";
                }
                System.out.printf("%-10s", simbolo);
            }
            System.out.println();
        }

        System.out.println("\nLeyenda:");
        System.out.println("✔ = gana equipo fila");
        System.out.println("✘ = pierde equipo fila");
        System.out.println("= = empate");
        System.out.println("— = no aplica (mismo equipo)");
    }

    public String equipoMasExperimentado(){
        double maxKillsPromedio = -1;
        String equipoMasExperimentado = "";
        for(int i = 0; i < totalEquipos; i++) {
            double killsPromedioEquipo = equipos[i].calcularKillsPromedioEquipo();
            if(killsPromedioEquipo > maxKillsPromedio) {
                maxKillsPromedio = killsPromedioEquipo;
                equipoMasExperimentado = equipos[i].getNombreEquipo();
            }
        }
        return "Equipo: " + equipoMasExperimentado + " con Kills Promedio: " + maxKillsPromedio;
    }
    
    public void filtrarPorRegion(String region) {
    	for(int i = 0; i < totalEquipos; i++) {
    		if(equipos[i].getRegion().equals(region)) {
    			equipos[i].mostrarInfoEquipo();
    			System.out.println("----------------------");
    		}
    	}
    }
}
