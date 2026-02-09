package Logica;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import Dominio.Dinosaurio;
import Dominio.Rex;
import Dominio.Brachiosaurus;
import Dominio.Triceratops;
import Dominio.Velociraptor;

public class App {

    private static Scanner s;
    private static ArrayList<Dinosaurio> dinosaurios = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {

        leerDinos();
        
        int opcion = 0;
        s = new Scanner(System.in);
        do { 
            System.out.println("1) Filtrar Info de ejemplares por especie");
            System.out.println("2) Calcular adaptabilidades acumuladas de cada especie");
            System.out.println("3) Mostrar dinosaurio con mejor adaptabilidad");
            System.out.println("4) Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = s.nextInt();
            s.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    filtrarInfoPorEspecie();
                    break;
                case 2:
                    calcularAcumulado();
                    break;
                case 3:
                    mostrarMejorDinosaurio();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }   
        } while (opcion != 4);
    }

    private static void filtrarInfoPorEspecie() {
        System.out.print("Ingrese la especie a filtrar: ");
        String especie = s.nextLine();
        
        for (Dinosaurio dino : dinosaurios) {
            if (dino.getEspecie().equalsIgnoreCase(especie)) {
                System.out.println(dino);
            }
        }
    }

    private static void calcularAcumulado() {
        double acumuladoVelo = 0;
        double acumuladoTri = 0;
        double acumuladoRex = 0;
        double acumuladoBra = 0;

        for (Dinosaurio dino : dinosaurios) {
            if (dino instanceof Velociraptor) {
                acumuladoVelo += dino.calcularAdaptabilidad();
            } else if (dino instanceof Triceratops) {
                acumuladoTri += dino.calcularAdaptabilidad();
            } else if (dino instanceof Rex) {
                acumuladoRex += dino.calcularAdaptabilidad();
            } else if (dino instanceof Brachiosaurus) {
                acumuladoBra += dino.calcularAdaptabilidad();
            }
        }

        System.out.println("Adaptabilidad acumulada por especie:");
        System.out.println("Velociraptor: " + acumuladoVelo);
        System.out.println("Triceratops: " + acumuladoTri);
        System.out.println("Tiranosaurio Rex: " + acumuladoRex);
        System.out.println("Brachiosaurio: " + acumuladoBra);
        
    }

    private static void mostrarMejorDinosaurio() {
        Dinosaurio mejorDino = null;
        double mejorAdaptabilidad = 0;

        for (Dinosaurio dino : dinosaurios) {
            double adaptabilidad = dino.calcularAdaptabilidad();
            if (adaptabilidad > mejorAdaptabilidad) {
                mejorAdaptabilidad = adaptabilidad;
                mejorDino = dino;
            }
        }
        if (mejorDino != null) {
            System.out.println("Dinosaurio con mejor adaptabilidad:");
            System.out.println(mejorDino);
            System.out.println("Adaptabilidad: " + mejorAdaptabilidad);
        } else {
            System.out.println("No hay dinosaurios registrados.");
        }
    }

    private static void leerDinos() throws FileNotFoundException {
        File arch = new File("Dinosaurios.txt");
        s = new Scanner(arch);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            int id = Integer.parseInt(partes[0]);
            String especie = partes[1];
            String habitat = partes[2];
            int esperanzaVida = Integer.parseInt(partes[3]);
            int velocidad = Integer.parseInt(partes[4]);
            switch (especie.toLowerCase()) {
                case "velociraptor":
                    int inteligencia = Integer.parseInt(partes[5]);
                    int filoGarras = Integer.parseInt(partes[6]);
                    Velociraptor velo = new Velociraptor(id, especie, habitat, esperanzaVida, velocidad, inteligencia, filoGarras);
                    dinosaurios.add(velo);
                    break;
                case "triceratops":
                    int tamañoCuernos = Integer.parseInt(partes[5]);
                    Triceratops tri = new Triceratops(id, especie, habitat, esperanzaVida, velocidad, tamañoCuernos);
                    dinosaurios.add(tri);
                    break;
                case "tyrannosaurus rex":
                    int fuerzaMordida = Integer.parseInt(partes[5]);
                    int durezaPiel = Integer.parseInt(partes[6]);
                    Rex rex = new Rex(id, especie, habitat, esperanzaVida, velocidad, fuerzaMordida, durezaPiel);
                    dinosaurios.add(rex);
                    break;
                case "brachiosaurus":
                    int largoCuello = Integer.parseInt(partes[5]);
                    Brachiosaurus bra = new Brachiosaurus(id, especie, habitat, esperanzaVida, velocidad, largoCuello);
                    dinosaurios.add(bra);
                    break;
                default:
                    System.out.println("Especie desconocida: " + especie);
            }
        }
    }
}