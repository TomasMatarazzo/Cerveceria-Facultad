package modelo;

public class Producto implements Comparable<Producto>{
    private int id_producto;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;

    public Producto(int id_producto, String nombre, double precioCosto, double precioVenta, int stockInicial) throws Exception {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.setPrecioCosto(precioCosto);
        this.setPrecioVenta(precioVenta);
        this.checkPrecio(precioCosto,precioVenta);
        this.stockInicial = stockInicial;
    }
    public void checkPrecio(double precioCosto, double precioVenta) throws Exception{
        if (precioVenta < precioCosto)
            throw new Exception();
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) throws Exception{
        if (precioCosto > 0)
            this.precioCosto = precioCosto;
        else
            throw new Exception();
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) throws Exception {
        if (precioVenta > 0)
            this.precioVenta = precioVenta;
        else
            throw new Exception();
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", precioCosto=" + precioCosto +
                ", precioVenta=" + precioVenta +
                ", stockInicial=" + stockInicial +
                '}';
    }


    @Override
    public int compareTo(Producto o) {
        return (this.precioCosto < o.precioCosto)?0:1;
    }
}
