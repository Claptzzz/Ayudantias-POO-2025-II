package dominio;

import logica.VisitorCuenta;

public class CuentaAhorro extends CuentaBancaria{
	private double tasaInteres;

	public CuentaAhorro(String titular, double saldo, double tasaInteres) {
		super(titular, saldo);
		this.tasaInteres = tasaInteres;
	}

	public double getTasaInteres() {
		return tasaInteres;
	}

	@Override
	public void aceptar(VisitorCuenta visitor) {
		visitor.visitar(this);
		
	}

	@Override
	public String toString() {
		return "Titular: " + getTitular() + ", saldo: "
				+ getSaldo() + ", tasa de interes: " + tasaInteres;
	}
	
	

}
