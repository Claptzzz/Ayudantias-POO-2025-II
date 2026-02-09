package dominio;

import logica.EstrategiaPlanificacion;
import logica.Mision;
import logica.VisitorMision;

public class Colonizacion implements Mision{
	private String destino;
    private int duracion;
    private double presupuesto;
    private String nivelPeligro;
    private EstrategiaPlanificacion estrategia;
    
    public Colonizacion(String destino, int duracion, double presupuesto, String nivelPeligro) {
    	this.destino = destino;
    	this.duracion = duracion;
    	this.presupuesto = presupuesto;
    	this.nivelPeligro = nivelPeligro;
    	this.estrategia = EstrategiaSelector.seleccionar(duracion, presupuesto, nivelPeligro);
    }
    
	@Override
	public void planificar() {
		estrategia.planificar(this);
		
	}

	@Override
	public void aceptarVisitor(VisitorMision visitor) {
		visitor.visitar(this);
		
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getNivelPeligro() {
		return nivelPeligro;
	}

	public void setNivelPeligro(String nivelPeligro) {
		this.nivelPeligro = nivelPeligro;
	}

	public EstrategiaPlanificacion getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaPlanificacion estrategia) {
		this.estrategia = estrategia;
	}
}
