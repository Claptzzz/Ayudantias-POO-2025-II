import java.util.Scanner;

public class solveExtra {
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el peso del dragon en kg: ");
        int peso = scanner.nextInt();
        scanner.close();
        double comida = peso*0.05;
        System.out.println("La cantidad de comida que debe recibir el dragon es: " + comida + " Kg.");
    }
}
