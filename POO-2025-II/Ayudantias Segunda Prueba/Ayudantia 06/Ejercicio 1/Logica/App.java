package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

    private static Scanner s;
    private static Sistema sistema = new SistemaImpl();

    public static void main(String[] args) throws FileNotFoundException {

        cargarDatos();
        
        int opcion = 0;
        s = new Scanner(System.in);
        do { 
            System.out.println("1) Imprimir informacion animales.");
            System.out.println("2) Calcular precio hospitalizacion por ID.");
            System.out.println("3) Menor y Mayor precio encontrado.");
            System.out.println("4) Salir.");
            System.out.print("Ingrese una opcion: ");
            opcion = s.nextInt();
            s.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    System.out.println(sistema.infoAnimales());
                    break;
                case 2:
                    System.out.print("Ingrese el ID del animal: ");
                    int id = s.nextInt();
                    s.nextLine(); // Limpiar el buffer
                    System.out.println(sistema.calcularPrecioHospitalizacionPorID(id));
                    break;
                case 3:
                    System.out.println(sistema.encontrarMenorYMayorPrecio());
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
    
    private static void cargarDatos() throws FileNotFoundException {
        File arch = new File("Datos.txt");
        s = new Scanner(arch);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String especie = partes[2];
            int edad = Integer.parseInt(partes[3]);
            double peso = Double.parseDouble(partes[4]);
            int diasHospedaje = Integer.parseInt(partes[5]);
            String frecuente = partes[6];
            sistema.agregarAnimal(id, nombre, especie, edad, peso, diasHospedaje, frecuente);
        }
    }
}
