package modelo;

public class Pedido {
    private Producto producto;
    private int cantidad;

    public Pedido(Producto producto, int cantidad) throws Exception {
        this.producto = producto;
        this.setCantidad(cantidad);
        this.verificaStock();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) throws Exception {
        if (cantidad > 0)
            this.cantidad = cantidad;
        else
            throw new Exception();
    }

    public void verificaStock() throws Exception{
        if (this.cantidad > this.producto.getStockInicial()){
            throw new  Exception();
        }
    }
}
