package Ayudantia_4.dominio;

public class Venta {
    private String codigo;
    private String codigoProducto;
    private String rutCliente;
    private int cantidadVendida;
    private String fechaVendta;

    public Venta(String codigo,String rutC, String codP, int cantV, String fV) {
        this.codigo = codigo;
        this.rutCliente = rutC;
        this.codigoProducto = codP;
        this.cantidadVendida = cantV;
        this.fechaVendta = fV;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public String getFechaVendta() {
        return fechaVendta;
    }

    public void setFechaVendta(String fechaVendta) {
        this.fechaVendta = fechaVendta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", rutCliente='" + rutCliente + '\'' +
                ", cantidadVendida=" + cantidadVendida +
                ", fechaVendta='" + fechaVendta + '\'' +
                '}';
    }
}
