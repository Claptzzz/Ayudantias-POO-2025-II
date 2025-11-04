package Dominio;

public class Brachiosaurus extends Dinosaurio {
    private int largoCuello;

    public Brachiosaurus(int id, String especie, String habitat, int esperanzaVida, int velocidad, int largoCuello) {
        super(id, especie, habitat, esperanzaVida, velocidad);
        this.largoCuello = largoCuello;
    }

    @Override
    public double calcularAdaptabilidad() {
        return (esperanzaVida*largoCuello)/velocidad;
    }
}
