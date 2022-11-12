package controladores;

import Utils.Mensajes;
import modelo.Empresa;
import vistas.VistaNuevaComandas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorNuevasComandas implements ActionListener{
    private VistaNuevaComandas vista;
    private Empresa modelo;

    public ControladorNuevasComandas(VistaNuevaComandas vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "MODIFICAR_COMANDA":
                if (this.vista.getSelectedComanda() != null && this.vista.getSelectedPedido() != null) {
                    this.modelo.agregarPedidoAComanda(this.vista.getSelectedPedido(),this.vista.getSelectedComanda());
                    this.vista.renderListaComandas(this.modelo.getComandas());
                }else{
                    Mensajes.lanzarVentanaEmergente("Selecciona una comanda o pedido");
                }
                break;
            case "CREAR_FACTURA":
                if (this.vista.getSelectedComanda() != null) {
                    try {
                        double total = this.modelo.generarFactura(this.vista.getSelectedComanda());
                        Mensajes.lanzarVentanaEmergente("El total de la factura fue : " + total);
                        this.vista.hideVista();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Mensajes.lanzarVentanaEmergente("Seleccion una comanda");
                }
                break;
        }
    }


}