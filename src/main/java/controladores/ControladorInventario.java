package controladores;

import excepciones.MozoIncorrecto;
import modelo.Empresa;
import controladores.vistas.VistaInventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ControladorInventario implements ActionListener{
    private VistaInventario vista;
    private Empresa modelo = new Empresa();

    public ControladorInventario(VistaInventario vista) {
        this.vista = vista;
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
                int cantHijos2 = Integer.parseInt(this.vista.getFormMozo().getCantHijos());
                Calendar fecha2 = Calendar.getInstance();
                fecha2.set(1970,10,2);
                this.modelo.modificaMozo(this.vista.getSelectedMozo(),this.vista.getFormMozo().getNombre(),fecha2, cantHijos2, this.vista.getFormMozo().getEstado());
                this.vista.hideFormMozo();
                this.vista.renderListaMozos(this.modelo.getMozos());
                break;

            case "NUEVOPRODUCTO":
                // CORREGIR LO DEL ID
                System.out.printf("rnyyt");
                double costo = Double.parseDouble(this.vista.getFormProducto().getCosto());
                double venta = Double.parseDouble(this.vista.getFormProducto().getVenta());
                int stock = Integer.parseInt(this.vista.getFormProducto().getStock());
                System.out.printf("hola");
                this.modelo.altaProducto( 0, this.vista.getFormProducto().getNombre(),costo,venta,stock);
                this.vista.renderListaProductos(this.modelo.getProductos());
                this.vista.hideFormProducto();
                break;
            case "INGRESAR_PRODUCTO":
                System.out.printf("nashe");
                this.vista.showFormProducto();
                break;
            case "ELIMINAR_PRODUCTO":
                break;
            case "MODIFICAR_PRODUCTO":
                break;
            case "NUEVAMESA":
                System.out.printf(this.vista.getFormMesa().getNroMesa() + this.vista.getFormMesa().getCantidadSillas());
                this.vista.hideFormMesa();
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