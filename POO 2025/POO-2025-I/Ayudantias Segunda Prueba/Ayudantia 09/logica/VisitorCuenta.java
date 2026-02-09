package logica;

import dominio.CuentaAhorro;
import dominio.CuentaCorriente;
import dominio.CuentaEmpresarial;

public interface VisitorCuenta {
	void visitar(CuentaAhorro cuenta);
	void visitar(CuentaCorriente cuenta);
	void visitar(CuentaEmpresarial cuenta);
}
