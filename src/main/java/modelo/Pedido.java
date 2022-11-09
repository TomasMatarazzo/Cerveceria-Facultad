package modelo;

import excepciones.StockNoDisponible;

public class Pedido {
    private Producto producto;
    private int cantidad;

    public Pedido(Producto producto, int cantidad) throws StockNoDisponible {
        this.producto = producto;
        this.setCantidad(cantidad);
        this.verificaStock();
        producto.setStockInicial(producto.getStockInicial()-cantidad);
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

    public void setCantidad(int cantidad) throws StockNoDisponible {
        if (cantidad > 0)
            this.cantidad = cantidad;
        else
            throw new StockNoDisponible("La cantidad ingresada es menor o igual a cero");
    }

    public void verificaStock() throws StockNoDisponible{
        if (this.cantidad > this.producto.getStockInicial()){
            throw new StockNoDisponible("No hay stock suficiente");
        }
    }
}
