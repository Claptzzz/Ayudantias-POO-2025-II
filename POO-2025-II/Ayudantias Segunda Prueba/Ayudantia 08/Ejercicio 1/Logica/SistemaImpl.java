package Logica;

import java.util.ArrayList;

import Dominio.Jugador;
import Dominio.Recurso;
import Strategy.EstrategiaRecoleccion;
import Strategy.EstrategiaSegura;
import Strategy.EstrategiaArriesgada;
import Visitor.InventarioVisitor;
import Visitor.BonificacionPremiumVisitor;
import Visitor.ValorCalculadorVisitor;

public class SistemaImpl implements Sistema {
	
	private static SistemaImpl instance;
	private static ArrayList<Recurso> recursos = new ArrayList<>();
	private static Jugador jugador;
	private static EstrategiaRecoleccion estrategiaActual = new EstrategiaSegura();
	
	private SistemaImpl() {}
	
	
	public static SistemaImpl getInstance() {
		if (instance == null) {
			instance = new SistemaImpl();
		}
		return instance;
	}
	@Override
	public void crearRecurso(int id, String nombre, String tipo, int cantidad, String zona, int tier) {
		recursos.add(new Recurso(id, nombre, tipo, cantidad, zona, tier));
	}


	@Override
	public void addJugador(String nombre, boolean premium) {
		jugador = new Jugador(nombre, premium);
	}


	@Override
	public String getNameJugador() {
		return jugador.getNombre();
	}


	@Override
	public String getCuentaJugador() {
		return jugador.getTipoCuenta();
	}


	@Override
	public String getEstrategiaActual() {
		return estrategiaActual.getNombre();
	}


	@Override
	public String verRecursos() {
		String aux = "";
		aux += "Inventario: \n";
		aux += "------------------------------------------------------------\n";
		int i = 1;
		for (Recurso r : recursos) {
			aux += i + ")" + recursos.get(i-1) + "\n";
			i++;
		}
		return aux;
	}


	@Override
	public String recolectar(int recurso) {
		String aux = "";
		if (recursos.get(recurso-1) != null) {
			Recurso r = recursos.get(recurso-1);
			aux += "------------------------------------------------------------\n";
			int cantidadRecolectada = (int)estrategiaActual.recolectar(r);
			r.agregarCantidad(cantidadRecolectada);
			aux += "Nuevo total: " + r.getCantidad() + "unidades\n";
			aux += "------------------------------------------------------------\n";
		} else {
			return "Recurso no existe";
		}
		return aux;
	}


	@Override
	public String cambiarEstrategia(int estrategia) {
		EstrategiaRecoleccion ant = estrategiaActual;
		if (estrategia == 1) {
			estrategiaActual = new EstrategiaArriesgada();
		} else {
			estrategiaActual = new EstrategiaSegura();
		}
		String aux = "Estrategia cambiada: \n";
		aux += ant.getNombre() + "->" + estrategiaActual.getNombre() + "\n";
		return aux;
	}


	@Override
	public String descripcionEstrategiaArriesgada() {
		return new EstrategiaArriesgada().getDescripcion();
	}


	@Override
	public String descripcionEstrategiaSegura() {
		return new EstrategiaSegura().getDescripcion();
	}


	@Override
	public String calcularPlata() {
		String aux = "";
		ValorCalculadorVisitor visitor = new ValorCalculadorVisitor();
		aux += "Calculando valores del inventario... \n";
		for (Recurso r : recursos) {
			r.aceptar(visitor);
		}
		
		aux += visitor.mostrarResultado();
		
		return aux;
	}


	@Override
	public String aplicarBonoPremium() {
		String aux = "";
		BonificacionPremiumVisitor visitor = new BonificacionPremiumVisitor(jugador.isPremium());
		
		aux += "Aplicando Bonificacion....\n";
		for (Recurso r : recursos) {
			r.aceptar(visitor);
		}
		
		aux += visitor.mostrarResultado();
		
		return aux;
	}
	
	
	

}
