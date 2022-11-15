package controladores;

import Utils.Mensajes;
import modelo.Empresa;
import modelo.PromocionTemporal;
import vistas.VistaPromociones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class ControladorPromociones implements ActionListener{
    private VistaPromociones vista;
    private Empresa modelo;

    public ControladorPromociones(VistaPromociones vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "MOSTRAR_P1":
                this.vista.getFormPromT().setVisible(true);
                break;
            case "INGRESAR_P1":
                try{
                    String nombre = this.vista.getFormPromT().getNombre();
                    String pago = (String)this.vista.getFormPromT().getFormaDePago();
                    int descuento = this.vista.getFormPromT().getDto();
                    int dia = this.vista.getFormPromT().getDias();
                    PromocionTemporal prom = new PromocionTemporal(nombre,pago,descuento,dia,true,true);
                    this.modelo.getPromocionesTemporales().add(prom);
                    this.vista.renderPromocionesTemporales(this.modelo.getPromocionesTemporales());
                    this.vista.getFormPromT().esconder();
                }catch(Exception e){
                    Mensajes.lanzarVentanaEmergente("error");
                }
                break;
            case "ELIMINAR_P1":
                if (this.vista.getPromocionTemporal() != null){
                    this.modelo.getPromocionesTemporales().remove(this.vista.getPromocionTemporal());
                    this.vista.renderPromocionesTemporales(this.modelo.getPromocionesTemporales());
                }else{
                    Mensajes.lanzarVentanaEmergente("SELECCIONE UNA PROMOCION");
                }
                break;
            case "ESTADO_P1":
                if (this.vista.getPromocionTemporal() != null){
                    this.vista.getPromocionTemporal().setActivo(!this.vista.getPromocionTemporal().isActivo());
                }else{
                    Mensajes.lanzarVentanaEmergente("SELECCIONE UNA PROMOCION");
                }
                break;
            case "MOSTRAR_P2":
                break;
            case "INGRESAR_P2":
                break;
            case "ELIMINAR_P2":
                break;
            case "ESTADO_P2":
                break;
        }
    }


}