import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class solve {

    public static void main(String[] args) throws FileNotFoundException {

        //lectura de archivos
        File archA = new File("../Armas.txt");
        File archM = new File("../Monster.txt");
        Scanner s = new Scanner(archA);

        //leemos la primera linea
        int cantArmas = Integer.parseInt(s.nextLine());
        //creamos el vector de armas
        Armas[] armas = new Armas[cantArmas];
        //creamos un contador para el indice del vector
        int i = 0;

        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] datos = linea.split(";");
            String nombre = datos[0];
            String tipo = datos[1];
            //creamos el objeto Armas y lo agregamos al vector
            Armas arma = new Armas(nombre, tipo);
            armas[i] = arma;
            i++;
        }

        s = new Scanner(archM);
        //leemos la primera linea
        int cantMonstruos = Integer.parseInt(s.nextLine());
        //creamos el vector de monstruos
        Monster[] monstruos = new Monster[cantMonstruos];
        //reiniciamos el contador
        i = 0;
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] datos = linea.split(";");
            String nombre = datos[0];
            String debilidad = datos[1];
            //creamos el objeto Monster y lo agregamos al vector
            Monster monstruo = new Monster(nombre, debilidad);
            monstruos[i] = monstruo;
            i++;
        }

        int opcion = 0;
        //hacemos el menu
        do {
            System.out.println("1. Evaluar");
            System.out.println("2. Salir");
            s = new Scanner(System.in);
            System.out.print("Ingrese una opcion: ");
            opcion = s.nextInt();

            if (opcion == 1) {
                //mostramos los monstruos
                int indice = 0;
                System.out.println("Monstruos:");
                for (Monster monstruo : monstruos) {
                    System.out.println(indice + ")Nombre: " + monstruo.getNombre() + ", Debilidad: " + monstruo.getDebilidad());
                    indice++;
                }
                System.out.print("Ingrese el indice del monstruo a evaluar: ");
                indice = s.nextInt();

                //mostramos las armas optimas para ese monstruo
                System.out.println("Armas optimas para " + monstruos[indice].getNombre() + ":");
                for (Armas arma : armas) {
                    if (arma.getTipo().equals(monstruos[indice].getDebilidad())) {
                        System.out.println("- " + arma.getNombre());
                    }
                }
            } else if (opcion != 2 && opcion != 1) {
                System.out.println("Opcion invalida, intente nuevamente.");
            }   
        } while (opcion!=2);

        //cerramos el scanner
        s.close();
        System.out.println("Programa finalizado.");

    }
}
