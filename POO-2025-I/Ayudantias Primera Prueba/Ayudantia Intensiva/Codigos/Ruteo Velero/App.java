package ruteo;

class App {
	
	public static void main(String[] args) {
		
		ClubDeYates yates = new ClubDeYates();
		Velero v1 = new Velero("Vagabundo 1", 502);
		Velero.asignarMembresia(20000);
		Velero v2 = new Velero("El Ucenino", 1281);
		Velero v3 = new Velero("Pirata Granate", 801);
		Velero v4 = new Velero("Vagabundo 2", 602);
		yates.atracar(v1, 12);
		yates.zarpar(v2);
		yates.zarpar(v2);
		yates.atracar(v3, 5);
		yates.zarpar(v3);
		yates.atracar(v4, 8);
		Velero.asignarMembresia(30000);
		yates.atracar(v4, 12);
		yates.atracar(v3, 15);
		yates.atracar(v2, 10);
		yates.zarpar(v2);
		yates.atracar(v2, 5);
		yates.zarpar(v1);
		yates.imprimir();
	}
}



















