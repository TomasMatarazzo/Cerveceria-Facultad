package controladores;

import Utils.Mensajes;
import excepciones.MozoIncorrecto;
import modelo.Empresa;
import vistas.VistaInventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ControladorInventario implements ActionListener{
    private VistaInventario vista;
    private Empresa modelo;

    public ControladorInventario(VistaInventario vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "NUEVOMOZO":
                //this.vista.getFormMozo().getFecha(); que onda la fecha?
                int cantHijos = Integer.parseInt(this.vista.getFormMozo().getCantHijos());
                Calendar fecha = Calendar.getInstance();
                fecha.set(1970,10,2);
                try {
                    this.modelo.agregaMozo(this.vista.getFormMozo().getNombre(),fecha, cantHijos, this.vista.getFormMozo().getEstado());
                    this.vista.hideFormMozo();
                    this.vista.renderListaMozos(this.modelo.getMozos());
                }
                catch(MozoIncorrecto e){
                    System.out.printf(e.getMessage());
                }
                break;
            case "INGRESAR_MOZO":
                //this.vista.datosMozo();
                this.vista.showFormMozo();
                break;
            case "ELIMINAR_MOZO":
                System.out.printf("hola");
                //this.modelo.bajaMozo(this.vista.getSelectedMozo());
                this.vista.renderListaMozos(this.modelo.getMozos());
                break;
            case "MODIFICAR_MOZO":
                // VERIFICAR COMO SE MODIFICA EL MOZO
                    System.out.printf("/nNASE" + this.vista.getSelectedMozo());
                    int cantHijos2 = Integer.parseInt(this.vista.getFormMozo().getCantHijos());
                    Calendar fecha2 = Calendar.getInstance();
                    fecha2.set(1970, 10, 2);
                    this.modelo.modificaMozo(this.vista.getSelectedMozo(), this.vista.getFormMozo().getNombre(), fecha2, cantHijos2, this.vista.getFormMozo().getEstado());
                    this.vista.hideFormMozo();
                    this.vista.renderListaMozos(this.modelo.getMozos());
//                }
//                else{
//                    Mensajes.lanzarVentanaEmergente("SELECCIONE UN MOZO");
//                }
                break;

            case "NUEVOPRODUCTO":
                // CORREGIR LO DEL ID
                double costo = Double.parseDouble(this.vista.getFormProducto().getCosto());
                double venta = Double.parseDouble(this.vista.getFormProducto().getVenta());
                int stock = Integer.parseInt(this.vista.getFormProducto().getStock());
                this.modelo.altaProducto( 0, this.vista.getFormProducto().getNombre(),costo,venta,stock);
                this.vista.renderListaProductos(this.modelo.getProductos());
                this.vista.hideFormProducto();
                break;
            case "INGRESAR_PRODUCTO":
                this.vista.showFormProducto();
                break;
            case "ELIMINAR_PRODUCTO":
                break;
            case "MODIFICAR_PRODUCTO":
                break;
            case "NUEVAMESA":
                int  nroMesa = Integer.parseInt(this.vista.getFormMesa().getNroMesa());
                int  nroSillas = Integer.parseInt(this.vista.getFormMesa().getCantidadSillas());
                try {
                    this.modelo.altaMesa(nroSillas);
                    this.vista.renderListaMesas(this.modelo.getMesas());
                    this.vista.hideFormMesa();
                }
                catch(Exception e){
                    System.out.printf(e.getMessage());
                }
                break;
            case "INGRESAR_MESA":
                this.vista.showFormMesa();
                break;
            case "ELIMINAR_MESA":
                break;
            case "MODIFICAR_MESA":
                break;
        }
    }


}