package dominio;

import logica.VisitorCuenta;

public class AplicarComisionVisitor implements VisitorCuenta {
    @Override
    public void visitar(CuentaAhorro ahorro) {
        ahorro.modificarSaldo(ahorro.getSaldo() - 100.0);
    }

    @Override
    public void visitar(CuentaCorriente corriente) {
        corriente.modificarSaldo(corriente.getSaldo() - 300.0);
    }

    @Override
    public void visitar(CuentaEmpresarial empresarial) {
        empresarial.modificarSaldo(empresarial.getSaldo() - 1500.0);
    }
}
