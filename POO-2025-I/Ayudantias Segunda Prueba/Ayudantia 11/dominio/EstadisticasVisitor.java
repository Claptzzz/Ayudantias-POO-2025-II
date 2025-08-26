package dominio;

import logica.VisitorMision;

public class EstadisticasVisitor implements VisitorMision{
	private int duracion = 0;
	private double presupuesto = 0;
	private int cantMisionesNivAlto = 0;
	private int cantMisionesNivMedio = 0;
	private int cantMisionesNivBajo = 0;

	@Override
	public void visitar(Exploracion m) {
		duracion += m.getDuracion();
		presupuesto += m.getPresupuesto();
		if(m.getNivelPeligro().equalsIgnoreCase("Alto")) {
			cantMisionesNivAlto++;
		} else if(m.getNivelPeligro().equalsIgnoreCase("Medio")) {
			cantMisionesNivMedio++;
		} else {
			cantMisionesNivBajo++;
		}
		
	}

	@Override
	public void visitar(Colonizacion m) {
		duracion += m.getDuracion();
		presupuesto += m.getPresupuesto();
		if(m.getNivelPeligro().equalsIgnoreCase("Alto")) {
			cantMisionesNivAlto++;
		} else if(m.getNivelPeligro().equalsIgnoreCase("Medio")) {
			cantMisionesNivMedio++;
		} else {
			cantMisionesNivBajo++;
		}
	}

	@Override
	public void visitar(Investigacion m) {
		duracion += m.getDuracion();
		presupuesto += m.getPresupuesto();
		if(m.getNivelPeligro().equalsIgnoreCase("Alto")) {
			cantMisionesNivAlto++;
		} else if(m.getNivelPeligro().equalsIgnoreCase("Medio")) {
			cantMisionesNivMedio++;
		} else {
			cantMisionesNivBajo++;
		}
	}
	
	public void mostrarEstadisticas() {
        System.out.println("=== Estadísticas Generales ===");
        System.out.println("Total presupuesto: " + presupuesto);
        System.out.println("Duración total: " + duracion + " días");
        System.out.println("Misiones por nivel de peligro");
        System.out.println("  ALTO: " + cantMisionesNivAlto);
        System.out.println("  MEDIO: " + cantMisionesNivMedio);
        System.out.println("  BAJO: " + cantMisionesNivBajo);
	}
	
}
