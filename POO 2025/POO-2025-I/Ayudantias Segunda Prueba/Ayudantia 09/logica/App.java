package logica;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import dominio.AplicarComisionVisitor;
import dominio.CuentaFactory;
import dominio.SistemaBancarioImpl;

public interface App {
	
	public static void leerArchivo(SistemaBancario sistema) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("cuentas.txt"));
		
		while(scan.hasNextLine()) {
			String[] partes = scan.nextLine().split(",");
			String titular = partes[0];
			double saldo = Double.parseDouble(partes[1]);
			String tipo = partes[2];
			
			if(tipo.equalsIgnoreCase("ahorro")) {
				double tasaInteres = Double.parseDouble(partes[3]);
				sistema.agregarCuenta(CuentaFactory.crearCuenta(tipo, titular, saldo, tasaInteres, null));
				
			} else if(tipo.equalsIgnoreCase("corriente")){
				double limiteSobregiro = Double.parseDouble(partes[3]);
				sistema.agregarCuenta(CuentaFactory.crearCuenta(tipo, titular, saldo, limiteSobregiro, null));
				
			} else if(tipo.equalsIgnoreCase("empresarial")){
				String rutEmpresa = partes[3];
				sistema.agregarCuenta(CuentaFactory.crearCuenta(tipo, titular, saldo, 0, rutEmpresa));
			}
		}
	}
	
	public static void menu(SistemaBancario sistema) {
		Scanner tecladoInt = new Scanner(System.in);
		Scanner tecladoStr = new Scanner(System.in);
		int opcion = 0;
		
		do {
			System.out.println("----MENU SISTEMA BANCARIO----");
			System.out.println("1. Crear cuenta");
			System.out.println("2. Aplicar comisión a cuentas");
			System.out.println("3. Ver información de cuentas");
			System.out.println("4. Salir");
			System.out.print("Opcion: ");
			opcion = tecladoInt.nextInt();
			
			if(opcion == 1) {
				System.out.print("Titular: ");
			    String titular = tecladoStr.nextLine();

			    System.out.print("Saldo: ");
			    double saldo = tecladoInt.nextDouble();

			    System.out.print("Tipo de cuenta (ahorro/corriente/empresarial): ");
			    String tipo = tecladoStr.nextLine();

			    if (tipo.equalsIgnoreCase("ahorro")) {
			        System.out.print("Tasa de interés: ");
			        double tasa = tecladoInt.nextDouble();
			        sistema.agregarCuenta(CuentaFactory.crearCuenta(tipo, titular, saldo, tasa, null));
			    } else if (tipo.equalsIgnoreCase("corriente")) {
			        System.out.print("Límite sobregiro: ");
			        double limite = tecladoInt.nextDouble();
			        sistema.agregarCuenta(CuentaFactory.crearCuenta(tipo, titular, saldo, limite, null));
			    } else if (tipo.equalsIgnoreCase("empresarial")) {
			        System.out.print("RUT empresa: ");
			        String rut = tecladoStr.nextLine();
			        sistema.agregarCuenta(CuentaFactory.crearCuenta(tipo, titular, saldo, 0, rut));
			    }
			    
			} else if(opcion == 2) {
				sistema.aplicarOperacion(new AplicarComisionVisitor());
			} else if(opcion == 3) {
				for(ICuentaBancaria cuenta: sistema.getCuentas()) {
					System.out.println(cuenta.toString());
				}
			}
			
			
		} while(opcion != 4);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		SistemaBancario sistema = SistemaBancarioImpl.getInstancia();
		leerArchivo(sistema);
		menu(sistema);
	}
}
