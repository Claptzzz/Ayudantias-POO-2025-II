package dominio;

public class JugadorFactory {
	public static Jugador crearJugador(String rol, String[] datos){
		Jugador j = null;
        
        String nickname = datos[0];
        String equipo = datos[1];
        String rolJugador = datos[2];
        int kills = Integer.parseInt(datos[3]);
        double kda = Double.parseDouble(datos[4]);
        double muertesPorPartida = Double.parseDouble(datos[5]);
        String estiloJuego = datos[6];
        
        switch(rol.toLowerCase()) {
            case "top":
                int usoTeleport = Integer.parseInt(datos[7]);
                int resistencia = Integer.parseInt(datos[8]);
                j = new Top(nickname, equipo, rolJugador, kills, kda, 
                           muertesPorPartida, estiloJuego, usoTeleport, resistencia);
                break;
                
            case "jungle":
                int objetivosAsegurados = Integer.parseInt(datos[7]);
                int ganksExitosos = Integer.parseInt(datos[8]);
                j = new Jungle(nickname, equipo, rolJugador, kills, kda, 
                              muertesPorPartida, estiloJuego, objetivosAsegurados, ganksExitosos);
                break;
                
            case "mid":
                String tipoMid = datos[7];
                j = new Mid(nickname, equipo, rolJugador, kills, kda, 
                           muertesPorPartida, estiloJuego, tipoMid);
                break;
                
            case "adc":
                double farmPorMinuto = Double.parseDouble(datos[7]);
                int dps = Integer.parseInt(datos[8]);
                j = new ADC(nickname, equipo, rolJugador, kills, kda, 
                           muertesPorPartida, estiloJuego, farmPorMinuto, dps);
                break;
                
            case "support":
                int wardsColocados = Integer.parseInt(datos[7]);
                int wardsEliminados = Integer.parseInt(datos[8]);
                double utilidadProporcionada = Double.parseDouble(datos[9]);
                j = new Support(nickname, equipo, rolJugador, kills, kda, 
                               muertesPorPartida, estiloJuego, wardsColocados, 
                               wardsEliminados, utilidadProporcionada);
                break;
                
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }
        
        return j;
	}
}
