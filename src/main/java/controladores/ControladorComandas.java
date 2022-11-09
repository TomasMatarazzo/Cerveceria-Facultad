package controladores;

import excepciones.StockNoDisponible;
import modelo.Empresa;
import vistas.VistaComandas;
import modelo.Pedido;

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
        }
    }

    public void lanzarVentanaEmergente(String mensaje){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }


}
