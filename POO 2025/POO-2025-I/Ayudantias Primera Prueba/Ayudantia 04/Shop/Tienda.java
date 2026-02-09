package Ayudantia_4.dominio;

public class Tienda {
    Producto[] productos;
    Venta[] ventas;
    Cliente[] clientes;

    public Tienda(){
        productos = new Producto[100];
        ventas = new Venta[100];
        clientes = new Cliente[100];
    }

    public boolean agregarProducto(Producto producto){
        boolean agregado = false;
        for (int i = 0; i < productos.length; i++) {
            if(productos[i] == null){
                productos[i] = producto;
                agregado = true;
                break;
            } else if(productos[i].getCodigo().equals(producto.getCodigo())){
                productos[i].setStock(productos[i].getStock() + producto.getStock());
                agregado = true;
            } else {
                agregado = false;
            }

        }
        return agregado;
    }

    public boolean agregarVenta(Venta venta){
        boolean agregado = false;
        for (int i = 0; i < ventas.length; i++) {
            if(ventas[i] == null){
                ventas[i] = venta;
                agregado = true;
                break;
            }
        }
        return agregado;
    }

    public boolean agregarCliente(Cliente cliente){
        boolean agregado = false;
        for (int i = 0; i < clientes.length; i++) {
            if(clientes[i] == null){
                clientes[i] = cliente;
                agregado = true;
                break;
            }
        }
        return agregado;
    }

    public String verProductos(){
        String productoss = "";
        for(int i = 0; i < productos.length; i++){
            if(productos[i] != null){
                productoss += productos[i].getCodigo() + ", ";
            }
        }
        return productoss;
    }

    public String verVentas(){
        String ventass = "";
        for(int i = 0; i < ventas.length; i++){
            if(ventas[i] != null){
                ventass += ventas[i].getCodigo() + ", ";
            }
        }
        return ventass;
    }

    public String verClientes(){
        String clientess = "";
        for(int i = 0; i < clientes.length; i++){
            if(clientes[i] != null){
                clientess += clientes[i].getRut() + ", ";
            }
        }
        return clientess;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public Cliente[] getClientes() {
        return clientes;
    }
}
