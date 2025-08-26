package Ayudantia_4.logica;

import Ayudantia_4.dominio.Producto;
import Ayudantia_4.dominio.Venta;
import Ayudantia_4.dominio.Cliente;
import Ayudantia_4.dominio.Tienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static boolean leerProductos(Tienda tienda){
        boolean leidos = false;
        try {
            Scanner scan = new Scanner(new File("productos.txt"));

            while(scan.hasNextLine()){
                String[] partes = scan.nextLine().split(";");
                String codigo = partes[0];
                String nombre = partes[1];
                String categoria = partes[2];
                double precio = Double.parseDouble(partes[3]);
                int stock = Integer.parseInt(partes[4]);

                Producto producto = new Producto(codigo, nombre, categoria, precio, stock);
                leidos = tienda.agregarProducto(producto);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return leidos;
    }

    public static boolean leerVentas(Tienda tienda){
        boolean leidos = false;
        try {
            Scanner scan = new Scanner(new File("ventas.txt"));

            while(scan.hasNextLine()){
                String[] partes = scan.nextLine().split(";");
                String codigo = partes[0];
                String rutCliente = partes[1];
                String codigoP = partes[2];
                int cantidad = Integer.parseInt(partes[3]);
                String fecha = partes[4];

                Venta venta = new Venta(codigo, rutCliente, codigoP, cantidad, fecha);
                leidos = tienda.agregarVenta(venta);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return leidos;
    }

    public static boolean leerClientes(Tienda tienda){
        boolean leidos = false;
        try {
            Scanner scan = new Scanner(new File("clientes.txt"));

            while(scan.hasNextLine()){
                String[] partes = scan.nextLine().split(";");
                String rut = partes[0];
                String nombre = partes[1];
                String direccion = partes[2];

                Cliente cliente = new Cliente(rut, nombre, direccion);
                for(int i = 3; i < partes.length; i++){
                    String codigoVenta = partes[i];
                    for(int j = 0; j < tienda.getVentas().length; j++){
                        if(tienda.getVentas()[j] != null){
                            if(codigoVenta.equals(tienda.getVentas()[j].getCodigo())){
                                cliente.agregarCompra(tienda.getVentas()[j]);
                            }
                        }
                    }
                }

                leidos = tienda.agregarCliente(cliente);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return leidos;
    }

    public static Producto crearProducto(){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoStr = new Scanner(System.in);
        Scanner tecladoDouble = new Scanner(System.in);

        System.out.print("Ingrese el código del producto: ");
        String codigo = tecladoStr.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = tecladoStr.nextLine();
        System.out.print("Ingrese el categoria del producto: ");
        String categoria = tecladoStr.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = tecladoDouble.nextDouble();
        System.out.print("Ingrese el stock del producto: ");
        int stock = tecladoInt.nextInt();

        return new Producto(codigo, nombre, categoria, precio, stock);
    }

    public static Venta crearVenta(Tienda tienda){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoStr = new Scanner(System.in);

        System.out.print("Ingrese el código del producto: ");
        String codigoProducto = tecladoStr.nextLine();

        Producto productoSeleccionado = null;
        for (Producto p : tienda.getProductos()) {
            if (p != null && p.getCodigo().equals(codigoProducto)) {
                productoSeleccionado = p;
                break;
            }
        }

        if (productoSeleccionado == null) {
            System.out.println("Producto no encontrado.");
            return null;
        }

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = tecladoInt.nextInt();
        tecladoInt.nextLine(); // Limpiar buffer

        if (productoSeleccionado.getStock() < cantidad) {
            System.out.println("Stock insuficiente. Disponible: " + productoSeleccionado.getStock());
            return null;
        }

        System.out.print("Ingrese el RUT del cliente: ");
        String rutCliente = tecladoStr.nextLine();

        System.out.print("Ingrese la fecha de la venta (YYYY-MM-DD): ");
        String fecha = tecladoStr.nextLine();

        // Generar código único de venta
        int id = 0;
        for (Venta v : tienda.getVentas()) {
            if (v != null) id++;
        }

        String codigoVenta = "V" + id;

        return new Venta(codigoVenta, rutCliente, codigoProducto, cantidad, fecha);
    }

    public static Cliente crearCliente(){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoStr = new Scanner(System.in);

        System.out.print("Ingrese el rut del cliente: ");
        String rutC = tecladoStr.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = tecladoStr.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = tecladoStr.nextLine();

        return new Cliente(rutC, nombre, direccion);
    }

    public static void desplegarMenu(Tienda tienda){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoStr = new Scanner(System.in);
        Scanner tecladoDouble = new Scanner(System.in);

        int opcion = 0;
        do{
            System.out.println("----SISTEMA ELECTRIC BOY----\n");
            System.out.println("1. Registrar un producto.");
            System.out.println("2. Realizar venta.");
            System.out.println("3. Consultar productos en stock.");
            System.out.println("4. Generar reportes.");
            System.out.println("5. Salir.");

            System.out.print("Opcion: ");
            opcion = tecladoInt.nextInt();

            if(opcion == 1){
                System.out.println("Registrar un producto:\n");
                Producto producto = crearProducto();

                for(int i = 0; i < tienda.getProductos().length ;i++){
                    if(tienda.getProductos()[i].getCodigo().equals(producto.getCodigo())){
                        System.out.println("El producto con el codigo " + producto.getCodigo() + " ya existe");
                        tienda.agregarProducto(producto);
                        System.out.println("Se ha agregado " + producto.getStock() + " de stock a la tienda.");
                        break;
                    } else{
                        if(tienda.agregarProducto(producto)){
                            System.out.println("El producto se ha agregado exitosamente!");
                            break;
                        };
                    }
                }

            } else if(opcion == 2){
                System.out.println("Realizar venta:\n");

                Venta venta = crearVenta(tienda);
                if (venta == null) {
                    System.out.println("No se pudo realizar la venta.");
                    continue;
                }

                // Buscar cliente
                Cliente cliente = null;
                for (Cliente c : tienda.getClientes()) {
                    System.out.println(venta.getRutCliente() + " " + c.getRut());
                    if (c != null && c.getRut().equals(venta.getRutCliente())) {
                        cliente = c;
                        break;
                    }
                }

                // Si cliente no existe, crearlo y agregarlo
                if (cliente == null) {
                    System.out.println("Cliente no encontrado. Creándolo...");
                    cliente = crearCliente();
                    tienda.agregarCliente(cliente);
                }

                cliente.agregarCompra(venta);
                tienda.agregarVenta(venta);

                // Buscar y actualizar producto
                for (Producto p : tienda.getProductos()) {
                    if (p != null && p.getCodigo().equals(venta.getCodigoProducto())) {
                        p.setStock(p.getStock() - venta.getCantidadVendida());
                        break;
                    }
                }

                System.out.println("¡Venta registrada exitosamente!");
            } else if(opcion == 3){
                System.out.println("Productos en stock:\n");
                for(int i = 0; i < tienda.getProductos().length ;i++){
                    if(tienda.getProductos()[i] != null){
                        if(tienda.getProductos()[i].getStock() > 0){
                            System.out.println(tienda.getProductos()[i].toString());
                        }
                    }
                }

            } else if(opcion == 4){
                System.out.println("Generar reportes:\n");

                // ------------------------------
                // Reporte: Producto más vendido
                // ------------------------------
                Producto[] productos = tienda.getProductos();
                Venta[] ventas = tienda.getVentas();

                int[] cantidadesVendidas = new int[productos.length];

                for (int i = 0; i < ventas.length; i++) {
                    Venta venta = ventas[i];
                    if (venta != null) {
                        for (int j = 0; j < productos.length; j++) {
                            if (productos[j] != null &&
                                    productos[j].getCodigo().equals(venta.getCodigoProducto())) {
                                cantidadesVendidas[j] += venta.getCantidadVendida();
                            }
                        }
                    }
                }

                int maxVentas = -1;
                int indiceMasVendido = -1;

                for (int i = 0; i < cantidadesVendidas.length; i++) {
                    if (cantidadesVendidas[i] > maxVentas) {
                        maxVentas = cantidadesVendidas[i];
                        indiceMasVendido = i;
                    }
                }

                System.out.println("🔹 Producto más vendido:");
                if (indiceMasVendido != -1) {
                    Producto p = productos[indiceMasVendido];
                    System.out.println("  - Nombre: " + p.getNombre());
                    System.out.println("  - Código: " + p.getCodigo());
                    System.out.println("  - Total unidades vendidas: " + maxVentas);
                } else {
                    System.out.println("  - No hay ventas registradas.");
                }

                // -------------------------------------
                // Reporte: Cliente que más ha comprado
                // -------------------------------------
                Cliente[] clientes = tienda.getClientes();
                int[] comprasPorCliente = new int[clientes.length];

                for (int i = 0; i < ventas.length; i++) {
                    Venta venta = ventas[i];
                    if (venta != null) {
                        for (int j = 0; j < clientes.length; j++) {
                            if (clientes[j] != null &&
                                    clientes[j].getRut().equals(venta.getRutCliente())) {
                                comprasPorCliente[j] += venta.getCantidadVendida();
                            }
                        }
                    }
                }

                int maxCompras = -1;
                int indiceTopCliente = -1;

                for (int i = 0; i < comprasPorCliente.length; i++) {
                    if (comprasPorCliente[i] > maxCompras) {
                        maxCompras = comprasPorCliente[i];
                        indiceTopCliente = i;
                    }
                }

                System.out.println("\n🔹 Cliente que más ha comprado:");
                if (indiceTopCliente != -1) {
                    Cliente c = clientes[indiceTopCliente];
                    System.out.println("  - Nombre: " + c.getNombre());
                    System.out.println("  - RUT: " + c.getRut());
                    System.out.println("  - Total productos comprados: " + maxCompras);
                } else {
                    System.out.println("  - No hay clientes con compras.");
                }


            } else if(opcion == 5){
                System.out.println("Hasta luego :D!");
            }

        } while(opcion != 5);
    }


    public static void main(String[] args){
        Tienda tienda = new Tienda();
        leerProductos(tienda);
        leerVentas(tienda);
        leerClientes(tienda);
        desplegarMenu(tienda);
    }

}
