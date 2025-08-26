package dominio;

import logica.ICuentaBancaria;

public class CuentaFactory {
    public static ICuentaBancaria crearCuenta(String tipo, String titular, double saldo, double extra, String datoExtra) {
        return switch (tipo.toLowerCase()) {
            case "ahorro" -> new CuentaAhorro(titular, saldo, extra);
            case "corriente" -> new CuentaCorriente(titular, saldo, extra);
            case "empresarial" -> new CuentaEmpresarial(titular, saldo, datoExtra);
            default -> throw new IllegalArgumentException("Tipo de cuenta no válido");
        };
    }
}

