package modelo;

import java.time.Instant;
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
        this.promocionesTemporales=promocionesTemporales;
        this.promocionesProductos=promocionesProductos;
        this.formaDePago=formaDePago;
        this.total = this.setTotal();
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

    /**
     * El metodo permite calcular el total a facturar, recorre todos los pedidos realizados y hace un calculo parcial al que posteriormente se le van
     * a aplicar descuentos en caso de ser necesario. Primero se recorre el arreglo de promociones de producto para saber si es necesario
     * aplicarle un descuento, para esto la promocion debera estar activa. Luego recorreremos el arreglo de promociones temporales para
     * saber si corresponde aplicarselas.
     * @return devuelve un flotante que debera ser mayor a cero, representa el total a cobrar a la mesa correspondiente
     */
    public double setTotal() {
        double total=0;
        double parcial;

        for (int i=0;i<pedidos.size();i++) {
           parcial=pedidos.get(i).getCantidad()*pedidos.get(i).getProducto().getPrecioVenta();
            if (this.promocionesProductos != null) { // || promocionesProductos.size() > 0) {
                for (int j = 0; j < promocionesProductos.size(); j++) {
                    if (promocionesProductos.get(j).isActiva()) {
                        if (promocionesProductos.get(j).isAplicaDosPorUno()) {
                            parcial /= 2.;
                        } else if (promocionesProductos.get(j).isAplicaDtoPorCantidad() && pedidos.get(i).getCantidad() >= promocionesProductos.get(j).getDtoPorCantidad_CantMinima()) {
                            parcial = promocionesProductos.get(j).getDtoPorCantidad_PrecioUnitario() * pedidos.get(i).getCantidad();
                        }
                    }
                }
            }
            total += parcial;
        }

        if (this.promocionesTemporales != null){ //|| promocionesTemporales.size() > 0) {
            for (int k = 0; k < promocionesTemporales.size(); k++) {
                if (promocionesTemporales.get(k).isActivo() && promocionesTemporales.get(k).getFormaDePago().equals(this.getFormaDePago()) && promocionesTemporales.get(k).getDiasDePromo() == Date.from(Instant.now()).getDay()) {
                    total = total - total*(double) promocionesTemporales.get(k).getPorcentajeDescuento() / 100;
                }
            }
        }

        return total;
    }
}
