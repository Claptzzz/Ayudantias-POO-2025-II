package dominio;

import logica.Mision;

public class MisionFactory {
	public static Mision crearMision(String linea) {
		String[] datos = linea.split(";");
		String tipo = datos[0];
        String destino = datos[1];
        int duracion = Integer.parseInt(datos[2]);
        double presupuesto = Double.parseDouble(datos[3]);
        String nivel = datos[4];
        
        return switch(tipo) {
        	case "Exploracion" -> new Exploracion(destino, duracion, presupuesto, nivel);
        	case "Colonizacion" -> new Colonizacion(destino, duracion, presupuesto, nivel);
            case "Investigacion" -> new Investigacion(destino, duracion, presupuesto, nivel);
            default -> throw new IllegalArgumentException("Tipo de misión no reconocido:" + tipo);
        };
        
	}
}
