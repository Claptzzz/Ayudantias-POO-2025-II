package dominio;

import logica.VisitorCuenta;

public class CuentaEmpresarial extends CuentaBancaria{
	private String rutEmpresa;
	
	public CuentaEmpresarial(String titular, double saldo, String rutEmpresa) {
        super(titular, saldo);
        this.rutEmpresa = rutEmpresa;
    }

    @Override
    public void aceptar(VisitorCuenta visitor) {
        visitor.visitar(this);
    }
    
    @Override
	public String toString() {
		return "Titular: " + getTitular() + ", saldo: "
				+ getSaldo() + ", rut de empresa: " + rutEmpresa;
	}

}
