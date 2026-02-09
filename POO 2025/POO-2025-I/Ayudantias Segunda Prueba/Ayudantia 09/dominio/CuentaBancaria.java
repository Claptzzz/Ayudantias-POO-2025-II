package dominio;

import logica.VisitorCuenta;

import logica.ICuentaBancaria;

public abstract class CuentaBancaria implements ICuentaBancaria{
	protected String titular;
	protected double saldo;
	
	public CuentaBancaria(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}
	
	@Override
    public String getTitular() {
        return titular;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
	
    public void modificarSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    @Override
    public abstract void aceptar(VisitorCuenta visitor);

	@Override
	public String toString() {
		return "Titular: " + titular + ", saldo: " + saldo;
	}
    
    
    
}
