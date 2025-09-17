package dominio;

public class Jugador {
    private String nick;
	private String posicion;
	private String campeonFavorito;
	private double killsPromedio;
	
	public Jugador(String nick, String posicion, String campeonFavorito, double killsPromedio) {
        this.nick = nick;
        this.posicion = posicion;
        this.campeonFavorito = campeonFavorito;
        this.killsPromedio = killsPromedio;
    }

    public String getNick() {
        return nick;
    }
    public String getPosicion() {
        return posicion;
    }
    public String getCampeonFavorito() {
        return campeonFavorito;
    }
    public double getKillsPromedio() {
        return killsPromedio;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public void setCampeonFavorito(String campeonFavorito) {
        this.campeonFavorito = campeonFavorito;
    }
    public void setKillsPromedio(double killsPromedio) {
        this.killsPromedio = killsPromedio;
    }

    public void mostrarInfo() {
        System.out.println("Nick: " + nick);
        System.out.println("Posición: " + posicion);
        System.out.println("Campeón Favorito: " + campeonFavorito);
        System.out.println("Kills Promedio: " + killsPromedio);
    }

    public String evaluarRendimiento(){
        if(killsPromedio > 200) {
            return "Profesional";
        } else if(killsPromedio >= 100) {
            return "Competente";
        } else if(killsPromedio >= 0) {
            return "Novato";
        }

        return "Datos inválidos";
    }
}
