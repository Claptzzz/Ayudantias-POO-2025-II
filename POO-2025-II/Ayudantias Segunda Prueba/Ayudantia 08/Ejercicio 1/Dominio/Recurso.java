package Dominio;

import Visitor.InventarioVisitor;

public class Recurso {

	private int id;
	private String nombre;
	private String tipo;
	private int cantidad;
	private String zona;
	private int tier;
	
	public Recurso(int id, String nombre, String tipo, int cantidad, String zona, int tier) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.zona = zona;
		this.tier = tier;
	}
	
	public void aceptar(InventarioVisitor visitor) {
		visitor.visitar(this);
	}
	
	public void agregarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	
	public int getPrecioBase() {
		switch(this.tipo.toLowerCase()) {
			case "madera":
				return 100;
			case "mineral":
				return 150;
			case "fibra":
				return 80;
			case "cuero":
				return 120;
			case "piedra":
				return 90;
			default:
				return 100;
		}
	}
	
	public double getMultiplicadorZona() {
		switch (this.zona.toLowerCase()) {
			case "verde":
				return 1.0;
			case "amarilla":
				return 1.2;
			case "roja":
				return 1.5;
			case "negra":
				return 2.0;
			default:
				return 1.0;
		}
	}
	
	public int getRiesgoZona() {
		switch (this.zona.toLowerCase()) {
			case "verde":
				return 0;
			case "amarilla":
				return 15;
			case "roja":
				return 30;
			case "negra":
				return 50;
			default:
				return 0;
		}
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getZona() {
		return zona;
	}

	public int getTier() {
		return tier;
	}

	@Override
	public String toString() {
		return "Recurso [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", cantidad=" + cantidad + ", zona="
				+ zona + ", tier=" + tier + "]";
	}
	
	
		
	
	
	
}
