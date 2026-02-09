package Ruteo;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(5202, "Mauro Lombardo", "555-1996");
        Cliente cliente2 = new Cliente(5203, "Luis Torres", "555-5678");
        Cliente cliente3 = new Cliente(5204, "Carla Pino", "555-9911");
        Cliente[] clientesDisponibles = {cliente1, cliente2, cliente3};
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        int numeroInicial = 500;
        listaPedidos.add(new Pedido(++numeroInicial, "Osito Haribo", 3590, clientesDisponibles[0]));
        listaPedidos.add(new Pedido(++numeroInicial, "Rollito de Canela", 3590, clientesDisponibles[1]));
        listaPedidos.add(new Pedido(++numeroInicial, "Pizza", 6590, clientesDisponibles[1]));
        listaPedidos.add(new Pedido(++numeroInicial, "Burguer Bacon", 3590, new Cliente(5206, "Camilo Villaruel", "555-9969")));
        listaPedidos.get(2).getCliente().setTelefono("555-2896");
        listaPedidos.remove(1);
        listaPedidos.add(new Pedido(++numeroInicial, "Coca-Cola", 1590, clientesDisponibles[0]));
        listaPedidos.add(new Pedido(++numeroInicial, "Handroll", 3990, null));
        System.out.println(listaPedidos.get(2).getCliente());
        listaPedidos.remove(4);
        System.out.println("\n--- Lista de Pedidos Registrados ---");
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido p : listaPedidos) {
                System.out.println(p);
            }
        }
    }
}
