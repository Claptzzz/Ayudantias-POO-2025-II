package Ruteo;

public class Pedido {
    private int numeroPedido;
    private String despcripcion;
    private double total;
    private Cliente cliente;
    private static boolean beep;

    public Pedido(int numeroPedido, String despcripcion, double total, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.despcripcion = despcripcion;
        this.total = total;
        this.cliente = cliente;
        if (beep) System.out.println("VSS");
        beep = !beep;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
    public String getDespcripcion() {
        return despcripcion;
    }
    public double getTotal() {
        return total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public static boolean isBeep() {
        return beep;
    }

    @Override
    public String toString() {
        String nombreCliente;
        if (cliente != null) {
            nombreCliente = cliente.getNombre();
        } else {
            nombreCliente = "N/A";
        }
        return "Pedido {" + "numeroPedido=" + numeroPedido + ", despcripcion=" + despcripcion + 
        ", total= $" + (int) total + ", cliente=" + nombreCliente + '}';
    }
}
