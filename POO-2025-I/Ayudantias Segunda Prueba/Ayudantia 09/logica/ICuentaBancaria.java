package logica;

public interface ICuentaBancaria {
	String getTitular();
	double getSaldo();
	void aceptar(VisitorCuenta visitor);
}
