package ruteo;

public class ClubDeYates {

	public Velero[] puerto = new Velero[5];
	public Velero[] bahia = new Velero[5];
	
	public void zarpar(Velero v) {
		for (int i = 0; i<bahia.length; i++) {
			if (bahia[i] == v) {
				break;
			} else if (bahia[i] == null){
				bahia[i] = v;
				break;
			}
		}
		for (int i = 0; i<puerto.length; i++) {
			if (puerto[i] == v) {
				puerto[i] = null;
				break;
			}
		}
	}
	
	public void atracar(Velero v, int dias) {
		for (int i = 0; i<puerto.length; i++) {
			if(puerto[i] == v) {
				v.calcularMembresia(dias);
				break;
			} else if (puerto[i] == null) {
				puerto[i] = v;
				v.calcularMembresia(dias);
				break;
			}
		}
		for (int i = 0; i<bahia.length; i++) {
			if (bahia[i] == v) {
				bahia[i] = null;
				break;
			}
		}
	}
	
	public void imprimir() {
		System.out.println("Zarpe");
		for (int i = 0; i < bahia.length; i++) {
			if (bahia[i] == null) {
				System.out.print("null,");
			} else {
				System.out.print(bahia[i].getNombre() + ",");
			}
		}
		System.out.println();
		System.out.println("Atraque");
		for (int i = 0; i<puerto.length; i++) {
			if (puerto[i] == null) {
				System.out.print("null,");
			} else {
				System.out.print(puerto[i].getNombre() + ": " + puerto[i].getCostoMantenimiento() + ",");
			}
		}
		System.out.println();
	}
}














