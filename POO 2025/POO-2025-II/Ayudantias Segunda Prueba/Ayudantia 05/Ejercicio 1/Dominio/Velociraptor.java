package Dominio;

public class Velociraptor extends Dinosaurio {
    private int inteligencia;
    private int filoGarras;

    public Velociraptor(int id, String especie, String habitat, int esperanzaVida, int velocidad, int inteligencia, int filoGarras) {
        super(id, especie, habitat, esperanzaVida, velocidad);
        this.inteligencia = inteligencia;
        this.filoGarras = filoGarras;
    }
    
    @Override
    public double calcularAdaptabilidad() {
        return ((velocidad+inteligencia)/esperanzaVida)*filoGarras;
    }
    
}
