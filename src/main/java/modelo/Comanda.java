package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Comanda {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private String estado;

    public Comanda( Mesa mesa, ArrayList<Pedido> pedidos, String estado) throws Exception{
        this.fecha = new Date();
        this.setMesa(mesa);
        this.pedidos = pedidos;
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


    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
