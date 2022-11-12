package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Comanda {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private String estado;

    public Comanda( Mesa mesa,Mozo mozo) throws Exception{
        this.fecha = new Date();
        this.setMesa(mesa);
        this.estado = "abierta";
        this.mesa.setMozo(mozo);
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
        this.mesa = mesa;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return Objects.equals(getFecha(), comanda.getFecha()) && Objects.equals(getMesa(), comanda.getMesa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMesa());
    }

    public void cerrarComanda(){this.estado = "cerrar";}

    @Override
    public String toString() {
        return "Comanda:  " + "Mesa: " + this.getMesa().getNro() + "  Cant-Pedidos: " + this.getPedidos().size();
    }
}
