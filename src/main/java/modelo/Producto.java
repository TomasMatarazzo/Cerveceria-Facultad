package modelo;

import excepciones.ProductoIncorrecto;

import java.io.Serializable;

public class Producto implements Comparable<Producto>, Serializable {
    private static int id;
    private int id_producto;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;

    public Producto( String nombre, double precioCosto, double precioVenta, int stockInicial) throws Exception {
        this.id_producto = id++;
        this.nombre = nombre;
        this.setPrecioCosto(precioCosto);
        this.setPrecioVenta(precioVenta);
        this.checkPrecio(precioCosto,precioVenta);
        this.stockInicial = stockInicial;
    }

    /**
     * @param precioCosto flotante mayor a cero y menor al precio de venta
     * @param precioVenta flotante mayor a cero y mayor al precio de costo
     * @throws ProductoIncorrecto es lanzada si el precio de venta es menor al de costo
     */
    public void checkPrecio(double precioCosto, double precioVenta) throws ProductoIncorrecto {
        if (precioVenta < precioCosto)
            throw new ProductoIncorrecto("El precio de venta es menor al de costo");
    }

    public int getId_producto() {
        return this.id_producto;
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

    /**
     * Permite setear el precio de costo
     * @param precioCosto flotante mayor a cero
     * @throws ProductoIncorrecto en caso de que el precio de costo sea menor a cero
     */
    public void setPrecioCosto(double precioCosto) throws ProductoIncorrecto{
        if (precioCosto > 0)
            this.precioCosto = precioCosto;
        else
            throw new ProductoIncorrecto("El precio de costo es menor o igual a 0");
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Permite setear el precio de venta
     * @param precioVenta flotante mayor o igual a cero y mayor al precio de costo
     * @throws ProductoIncorrecto se lanza cuando el precio de venta es menor o igual a cero o menor al precio de venta
     */
    public void setPrecioVenta(double precioVenta) throws ProductoIncorrecto {
        if (precioVenta > 0 && precioVenta>this.precioCosto)
            this.precioVenta = precioVenta;
        else
            throw new ProductoIncorrecto("El precio de venta es menor o igual a 0 o menor al precio de costo");
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    @Override
    public String toString() {
        return "Producto:   " + nombre +
                "      PrecioCosto:   " + precioCosto +
                "      PrecioVenta:  " + precioVenta +
                "      Stock:    " + stockInicial;
    }


    @Override
    public int compareTo(Producto o) {
        if (this.getId_producto() == o.id_producto)
            return 0;
        else{
            if (this.id_producto > o.id_producto){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
