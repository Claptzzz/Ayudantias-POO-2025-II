package Dominio;

public class Rex extends Dinosaurio {
    private int fuerzaMordida;
    private int durezaPiel;

    public Rex(int id, String especie, String habitat, int esperanzaVida, int velocidad, int fuerzaMordida, int durezaPiel) {
        super(id, especie, habitat, esperanzaVida, velocidad);
        this.fuerzaMordida = fuerzaMordida;
        this.durezaPiel = durezaPiel;
    }

    @Override
    public double calcularAdaptabilidad() {
        return (fuerzaMordida+durezaPiel+velocidad)/esperanzaVida;
    }
}