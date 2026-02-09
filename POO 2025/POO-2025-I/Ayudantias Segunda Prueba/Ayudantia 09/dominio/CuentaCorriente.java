package dominio;

import logica.VisitorCuenta;

public class CuentaCorriente extends CuentaBancaria{
	private double limiteSobregiro;
	
	public CuentaCorriente(String titular, double saldo, double limiteSobregiro) {
        super(titular, saldo);
        this.limiteSobregiro = limiteSobregiro;
    }

    public double getLimiteSobregiro() {
		return limiteSobregiro;
	}

	@Override
    public void aceptar(VisitorCuenta visitor) {
        visitor.visitar(this);
    }
	
	@Override
	public String toString() {
		return "Titular: " + getTitular() + ", saldo: "
				+ getSaldo() + ", limite de sobregiro: " + limiteSobregiro;
	}
}
