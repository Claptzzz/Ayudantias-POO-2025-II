package Ruteo;

public class Cliente {
    private int rut;
    private String nombre;
    private String telefono;

    public Cliente(int rut, String nombre, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        System.out.println(Pedido.isBeep());
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente {" + "rut=" + rut + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }

}
