package logica;

import logica.VisitorCuenta;

import java.util.ArrayList;

public interface SistemaBancario {
	void agregarCuenta(ICuentaBancaria cuenta);
	void aplicarOperacion(VisitorCuenta visitor);
	ArrayList<ICuentaBancaria> getCuentas();
}
