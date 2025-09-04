import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File arch = new File("../Campeones.txt");
        Scanner s = new Scanner(arch);

        String partes[] = s.nextLine().split(";");
        int N = Integer.parseInt(partes[0]);
        int M = Integer.parseInt(partes[1]);
        int cantC = Integer.parseInt(partes[2]);

        Champ[][] mz = new Champ[N][M];
        Champ[] campeones = new Champ[cantC];

        while (s.hasNextLine()) {
            String linea = s.nextLine();        
            String datos[] = linea.split(";");
            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            int posX = Integer.parseInt(datos[2]);
            int posY = Integer.parseInt(datos[3]);
            double vida = Double.parseDouble(datos[4]);
            double ataque = Double.parseDouble(datos[5]);
            double defensa = Double.parseDouble(datos[6]);
            Champ campeon = new Champ(id, nombre, posX, posY, vida, ataque, defensa);
            mz[posX-1][posY-1] = campeon;
            campeones[id-1] = campeon;
        }

        int opcion = 0;
        s = new Scanner(System.in);
        do {
            System.out.println("1. Imprimir Matriz");
            System.out.println("2. Info Campeon");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = s.nextInt();
            s.nextLine(); // Consumir el salto de linea

            switch (opcion) {
                case 1:
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (mz[i][j] != null) {
                                System.out.print(mz[i][j].getNombre() + " ");
                            } else {
                                System.out.print("# ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("1. Buscar por Nombre\n2. Buscar por ID\nIngrese una opcion: ");
                    int subOpcion = s.nextInt();
                    s.nextLine(); // Consumir el salto de linea
                    if (subOpcion == 1) {
                        System.out.println("Ingrese el nombre del campeon: ");
                        String nombreBuscado = s.nextLine();
                        boolean encontrado = false;
                        for (Champ c : campeones) {
                            if (c.getNombre().equalsIgnoreCase(nombreBuscado)) {
                                System.out.println(c);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Campeon no encontrado.");
                        }
                    } else if (subOpcion == 2) {
                        System.out.println("Ingrese el ID del campeon: ");
                        int idBuscado = s.nextInt();
                        if (idBuscado >= 1 && idBuscado <= campeones.length) {
                            System.out.println(campeones[idBuscado - 1]);
                        } else {
                            System.out.println("ID invalido.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 3);

        s.close();
    }
}