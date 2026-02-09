package Dominio;

public class Perro implements InterfaceAnimal {
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private int diasHospedaje;
    private String frecuente;

    public Perro(int id, String nombre, String especie, int edad, double peso, int diasHospedaje, String frecuente) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.diasHospedaje = diasHospedaje;
        this.frecuente = frecuente;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public double calcularPrecio() {
        if (frecuente.equals("SI")){
            return (40000+(peso*diasHospedaje))*0.75;
        }
        return 40000+(peso*diasHospedaje);
    }

    @Override
    public String toString() {
        return "Perro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", diasHospedaje=" + diasHospedaje +
                ", frecuente='" + frecuente + '\'' +
                '}';
    }
}
