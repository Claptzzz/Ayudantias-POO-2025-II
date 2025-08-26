public class Personaje {
    private String nombreJ;
    private String nombreP;
    private double tiempo;
    private double damage;

    public Personaje(String nombreJ, String nombreP, double tiempo, double damage) {
        this.nombreJ = nombreJ;
        this.nombreP = nombreP;
        this.tiempo = tiempo;
        this.damage = damage;
    }
    public String getNombreJ() {
        return nombreJ;
    }
    public String getNombreP() {
        return nombreP;
    }
    public double getTiempo() {
        return tiempo;
    }
    public double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre del jugador='" + nombreJ + '\'' +
                ", nombre del personaje='" + nombreP + '\'' +
                ", tiempo de juego=" + tiempo +
                ", daño realizado=" + damage +
                '}';
    }
}
