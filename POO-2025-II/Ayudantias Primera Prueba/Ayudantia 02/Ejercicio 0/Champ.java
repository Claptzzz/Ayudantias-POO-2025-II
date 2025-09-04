public class Champ {

    private int id;
    private String nombre;
    private int posX;
    private int posY;
    private double vida;
    private double ataque;
    private double defensa;

    public Champ(int id, String nombre, int posX, int posY, double vida, double ataque, double defensa) {
        this.id = id;
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Champ{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                '}';
    }


}