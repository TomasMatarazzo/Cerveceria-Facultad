package controladores;

import Utils.Mensajes;
import excepciones.StockNoDisponible;
import modelo.Empresa;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import vistas.VistaComandas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorComandas implements ActionListener{
    private VistaComandas vista;
    private Empresa modelo;

    public ControladorComandas(VistaComandas vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "FORM_PEDIDO":
                this.vista.showFormPedido();
                break;
            case "CREAR_PEDIDO":
                int cant;
                if (this.vista.getSelectedProducto() != null && !this.vista.getCantDelPedido().equals("")) {
                    cant = Integer.parseInt(this.vista.getCantDelPedido());
                    try {
                        Pedido ped = new Pedido(this.vista.getSelectedProducto(), cant);
                        this.modelo.altaPedido(ped);
                        this.vista.renderListaPedidos(this.modelo.getPedidos());
                        this.vista.hideFormPedido();
                    } catch (StockNoDisponible e) {
                        Mensajes.lanzarVentanaEmergente("No hay stock");
                    }
                }
                else{
                    Mensajes.lanzarVentanaEmergente("Seleccione el producto o indique cantidad");
                }
                break;
            case "NUEVA_COMANDA":
                Mozo mozo1 = this.vista.getSelectedMozo();
                Mesa mesa1 = this.vista.getSelectedMesas();
                Pedido pedido = this.vista.getSelectedPedido();
                if (mozo1 != null && mesa1 != null && pedido !=null && !mesa1.getEstado().equals("ocupada") && mozo1.getEstado() == 0 ){
                    try {
                        this.modelo.altaComanda(mesa1,mozo1,pedido);
                        this.vista.setVisible(false);
                        Mensajes.lanzarVentanaEmergente("Se creo la comanda ya puede agregar pedidos");
                    } catch (Exception e) {
                        Mensajes.lanzarVentanaEmergente("Error a la hora de crear la comanda");
                    }
                }else{
                    Mensajes.lanzarVentanaEmergente("Para crear una comanda debe seleccionar una mesa, un mozo y un producto LIBRES");
                }
                break;
        }
    }
}
