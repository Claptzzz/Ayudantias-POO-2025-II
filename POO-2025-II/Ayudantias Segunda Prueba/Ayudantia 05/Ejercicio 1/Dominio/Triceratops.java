package Dominio;

public class Triceratops extends Dinosaurio {
    private int cuernos;

    public Triceratops(int id, String especie, String habitat, int esperanzaVida, int velocidad, int cuernos) {
        super(id, especie, habitat, esperanzaVida, velocidad);
        this.cuernos = cuernos;
    }

    public double calcularAdaptabilidad() {
        return (esperanzaVida*cuernos)/velocidad;
    }
    
}
