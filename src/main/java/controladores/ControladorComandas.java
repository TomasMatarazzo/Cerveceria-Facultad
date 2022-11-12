package controladores;

import Utils.Mensajes;
import excepciones.StockNoDisponible;
import modelo.*;
import vistas.VistaComandas;
import javax.swing.*;
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
                //this.vista.getFormMozo().getFecha(); que onda la fecha?
                System.out.printf("hola");
                this.vista.showFormPedido();
                break;
            case "CREAR_COMANDA":
                //this.vista.datosMozo();
                Mesa mesa = this.vista.getSelectedMesas();
                Producto prod = this.vista.getSelectedProducto();
                Mozo mozo = this.vista.getSelectedMozo();
                //this.modelo.altaComanda();
                this.vista.hideFormPedido();
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
                        e.printStackTrace();
                    }
                }
                else{
                    lanzarVentanaEmergente("Seleccione el producto o indique cantidad");
                }
                break;
            case "NUEVA_COMANDA":
                Mozo mozo1 = this.vista.getSelectedMozo();
                Mesa mesa1 = this.vista.getSelectedMesas();
                Pedido pedido = this.vista.getSelectedPedido();
                if (mozo1 != null && mesa1 != null && pedido !=null){
                    try {
                        this.modelo.altaComanda(mesa1,mozo1,pedido);
                        this.vista.setVisible(false);
                        Mensajes.lanzarVentanaEmergente("Se creo la comanda ya puede agregar pedidos");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Mensajes.lanzarVentanaEmergente("Para crear una comanda debe seleccionar una mesa, un mozo y un producto");
                }
                break;

        }
    }

    public void lanzarVentanaEmergente(String mensaje){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }


}
