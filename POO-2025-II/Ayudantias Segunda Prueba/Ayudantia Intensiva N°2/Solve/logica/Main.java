package logica;

import java.io.FileNotFoundException;

import dominio.Sistema;
import gui.Menu;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Sistema sistema = (Sistema) Sistema.getInstancia();
		Menu gui = new Menu(sistema);
		gui.iniciar();
	}
}
