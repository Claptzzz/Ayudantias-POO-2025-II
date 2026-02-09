import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class solve {
    public static void main(String[] args) throws FileNotFoundException {
        File arch = new File("../Personajes.txt");
        Scanner s = new Scanner(arch);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] datos = linea.split(";");
            String nombreJ = datos[0];
            String nombreP = datos[1];
            double tiempo = Double.parseDouble(datos[2]);
            double damage = Double.parseDouble(datos[3]);
            Personaje personaje = new Personaje(nombreJ, nombreP, tiempo, damage);
            System.out.println(personaje);
        }
        s.close();
    }
}