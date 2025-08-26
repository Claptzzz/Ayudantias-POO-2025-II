package Ayudantia_4.dominio;

import java.util.Arrays;

public class Cliente {
    private String rut;
    private String nombre;
    private String direccion;
    private Venta[] compras;

    public Cliente(String rut, String nombre, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        compras = new Venta[100];
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean agregarCompra(Venta compra){
        boolean agregado = false;
        for(int i = 0; i < compras.length; i++){
            if(compras[i] == null){
                compras[i] = compra;
                agregado = true;
            }
        }
        return agregado;
    }

    public String verCompras(){
        String comprass = "";
        for(int i = 0; i < compras.length; i++){
            if(compras[i] != null){
                comprass += compras[i].toString() + "\n";
            }
        }
        return comprass;
    }

    @Override
    public String toString() {
        return "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", compras=" + Arrays.toString(compras);
    }
}
