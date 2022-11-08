package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date date;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos=new ArrayList<>();
    private double total;
    private String formaDePago;
    private ArrayList<ProductoEnPromocion> promocionesProductos;
    private ArrayList<PromocionTemporal> promocionesTemporales;

    public Factura(Date date, Mesa mesa, ArrayList<Pedido> pedidos,String formaDePago,ArrayList<ProductoEnPromocion> promocionesProductos,ArrayList<PromocionTemporal> promocionesTemporales) {
        this.date = date;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.total = this.setTotal();
        this.formaDePago=formaDePago;
        this.promocionesTemporales=promocionesTemporales;
        this.promocionesProductos=promocionesProductos;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getTotal() {
        return total;
    }

    public double setTotal() {
        double total=0;
        double parcial;
        for (int i=0;i<pedidos.size();i++){
            parcial=pedidos.get(i).getCantidad()*pedidos.get(i).getProducto().getPrecioVenta();
            for(int j=0;j<promocionesProductos.size();i++){
                if(pedidos.get(i).getProducto()==promocionesProductos.get(j).getProducto()){
                    if(promocionesProductos.get(j).isActiva()){
                        if(promocionesProductos.get(j).isAplicaDosPorUno()){
                            parcial /=2;
                        }
                        else if(promocionesProductos.get(j).isAplicaDtoPorCantidad() && pedidos.get(i).getCantidad()>=promocionesProductos.get(j).getDtoPorCantidad_CantMinima()){
                            parcial=promocionesProductos.get(j).getDtoPorCantidad_PrecioUnitario()*pedidos.get(i).getCantidad();
                        }
                    }
                }
            }
            total+=parcial;
        }
        for(int k=0;k<promocionesTemporales.size();k++){
            if(promocionesTemporales.get(k).isActivo() && promocionesTemporales.get(k).getFormaDePago().equals(this.getFormaDePago())){
                total*= (double) promocionesTemporales.get(k).getPorcentajeDescuento() /100;
            }
        }

        return total;
    }
}
