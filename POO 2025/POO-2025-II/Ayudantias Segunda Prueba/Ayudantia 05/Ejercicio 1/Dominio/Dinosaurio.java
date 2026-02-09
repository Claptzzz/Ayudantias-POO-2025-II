package Dominio;

public abstract class Dinosaurio {
    protected int id;
    protected String especie;
    protected String habitat;
    protected int esperanzaVida;
    protected int velocidad;

    public Dinosaurio(int id, String especie, String habitat, int esperanzaVida, int velocidad) {
        this.id = id;
        this.especie = especie;
        this.habitat = habitat;
        this.esperanzaVida = esperanzaVida;
        this.velocidad = velocidad;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    public abstract double calcularAdaptabilidad();

    @Override
    public String toString() {
        return "Dinosaurio{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", habitat='" + habitat + '\'' +
                ", esperanzaVida=" + esperanzaVida +
                ", velocidad=" + velocidad +
                '}';
    }

}
