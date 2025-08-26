package dominio;

import java.util.ArrayList;

import logica.ICuentaBancaria;
import logica.SistemaBancario;
import logica.VisitorCuenta;

public class SistemaBancarioImpl implements SistemaBancario{
	private static SistemaBancarioImpl instancia;
	private ArrayList<ICuentaBancaria> cuentas = new ArrayList();
	
	private SistemaBancarioImpl() {};
	
	public static SistemaBancarioImpl getInstancia() {
		if(instancia == null) {
			instancia = new SistemaBancarioImpl();
		}
		return instancia;
	}

	@Override
	public void agregarCuenta(ICuentaBancaria cuenta) {
		cuentas.add(cuenta);
		
	}

	@Override
	public void aplicarOperacion(VisitorCuenta visitor) {
		for(ICuentaBancaria cuenta: cuentas) {
			cuenta.aceptar(visitor);
		}
		
	}

	@Override
	public ArrayList<ICuentaBancaria> getCuentas() {
		return cuentas;
	}

}
