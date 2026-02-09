package Logica;

public interface Sistema {

    String infoAnimales();

    String calcularPrecioHospitalizacionPorID(int id);

    String encontrarMenorYMayorPrecio();

    void agregarAnimal(int id, String nombre, String especie, int edad, double peso, int diasHospedaje, String frecuente);
    
}