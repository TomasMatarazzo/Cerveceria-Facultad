package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Comanda {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> productos = new ArrayList<>();
    private String estado;

    public Comanda( Mesa mesa, ArrayList<Pedido> productos, String estado) throws Exception{
        this.fecha = new Date();
        this.setMesa(mesa);
        this.productos = productos;
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) throws Exception {
        if (this.mesa.getEstado().equalsIgnoreCase("libre"))
            this.mesa = mesa;
        else{
            throw new Exception();
        }
    }

    public ArrayList<Pedido> getProductos() {
        return productos;
    }

    public void agregarPedido(Pedido pedido){
        this.productos.add(pedido);
    }

    public void setProductos(ArrayList<Pedido> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
