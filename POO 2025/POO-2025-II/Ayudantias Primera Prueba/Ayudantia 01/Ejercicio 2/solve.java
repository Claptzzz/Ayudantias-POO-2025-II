import java.util.Scanner;

public class solve {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantAlumnos = s.nextInt();
        s.nextLine(); // Consumir el salto de línea

        while (cantAlumnos > 0) {
            System.out.print("Ingrese la cantidad de notas por alumno: ");
            int cantNotas = s.nextInt();
            double total = 0;
            s.nextLine(); // Consumir el salto de línea
            for (int i = 0; i < cantNotas; i++) {
                System.out.print("Ingrese la nota " + (i + 1) + ": ");
                double nota = s.nextDouble();
                s.nextLine();
                total += nota;
            }
            double promedio = total / cantNotas;
            System.out.println("El promedio de notas es: " + promedio);
            cantAlumnos--;
        }
        s.close();
    }
}
