package controladores;

import Utils.Mensajes;
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
                try {
                    int cantHijos = Integer.parseInt(this.vista.getFormMozo().getCantHijos());
                    Calendar fecha = Calendar.getInstance();
                    fecha.set(1970,10,2);
                    this.modelo.agregaMozo(this.vista.getFormMozo().getNombre(),fecha, cantHijos, this.vista.getFormMozo().getEstado());
                    this.vista.hideFormMozo();
                    this.vista.renderListaMozos(this.modelo.getMozos());
                }
                catch(Exception e){
                    Mensajes.lanzarVentanaEmergente("Ingrese correctamente los datos del mozo");
                }
                break;
            case "INGRESAR_MOZO":
                this.vista.estadoAgregarMozo();
                this.vista.showFormMozo();
                break;
            case "INGRESAR_MOZO2":
                if (this.vista.getSelectedMozo() != null) {
                    this.vista.estadoModificarMozo();
                    this.vista.showFormMozo();
                }else{
                    Mensajes.lanzarVentanaEmergente("Seleccione un mozo");
                }
                break;
            case "ELIMINAR_MOZO":
                if (this.vista.getSelectedMozo() != null) {
                    this.modelo.bajaMozo(this.vista.getSelectedMozo());
                    this.vista.renderListaMozos(this.modelo.getMozos());
                }
                else{
                    Mensajes.lanzarVentanaEmergente("Seleccione un mozo");
                }
                break;
            case "MODIFICAR_MOZO":
                try {
                    int cantHijos2 = Integer.parseInt(this.vista.getFormMozo().getCantHijos());
                    Calendar fecha2 = Calendar.getInstance();
                    fecha2.set(1970, 10, 2);
                    this.modelo.modificaMozo(this.vista.getSelectedMozo(), this.vista.getFormMozo().getNombre(), fecha2, cantHijos2, this.vista.getFormMozo().getEstado());
                    this.vista.hideFormMozo();
                    this.vista.renderListaMozos(this.modelo.getMozos());
                }
                catch (Exception e){
                    Mensajes.lanzarVentanaEmergente("Ingrese los datos correctamente");
                }
                break;

            case "NUEVOPRODUCTO":
                // CORREGIR LO DEL ID
                try {
                    double costo = Double.parseDouble(this.vista.getFormProducto().getCosto());
                    double venta = Double.parseDouble(this.vista.getFormProducto().getVenta());
                    int stock = Integer.parseInt(this.vista.getFormProducto().getStock());
                    this.modelo.altaProducto( this.vista.getFormProducto().getNombre(), costo, venta, stock);
                    System.out.printf(this.modelo.getProductos().toString());
                    this.vista.renderListaProductos(this.modelo.getProductos());
                    this.vista.hideFormProducto();
                }
                catch(Exception e){
                    Mensajes.lanzarVentanaEmergente("Ingrese correctamente los datos");
                }
                break;
            case "INGRESAR_PRODUCTO":
                this.vista.estadoAgregarProducto();
                this.vista.showFormProducto();
                break;
            case "INGRESAR_PRODUCTO2":
                if (this.vista.getSelectedProducto() != null) {
                    this.vista.estadoModificarProducto();
                    this.vista.showFormProducto();
                }
                else{
                    Mensajes.lanzarVentanaEmergente("Seleccione un producto");
                }
                break;
            case "ELIMINAR_PRODUCTO":
                System.out.printf("holaa");
                if (this.vista.getSelectedProducto() != null) {
                    System.out.printf("PRODUCTO ESSS");
                    System.out.printf(this.vista.getSelectedProducto().toString());
                    this.modelo.bajaProducto(this.vista.getSelectedProducto());
                    this.vista.renderListaProductos(this.modelo.getProductos());
                }
                else{
                    System.out.printf("no");
                    Mensajes.lanzarVentanaEmergente("Seleccione una mesa");
                }
                break;
            case "MODIFICAR_PRODUCTO":
                try {
                    double costo = Double.parseDouble(this.vista.getFormProducto().getCosto());
                    double venta = Double.parseDouble(this.vista.getFormProducto().getVenta());
                    int stock = Integer.parseInt(this.vista.getFormProducto().getStock());
                    this.modelo.modificaProducto(this.vista.getSelectedProducto().getNombre(),costo,venta,stock, this.vista.getSelectedProducto());
                    this.vista.hideFormProducto();
                    this.vista.renderListaProductos(this.modelo.getProductos());
                }
                catch (Exception e){
                    Mensajes.lanzarVentanaEmergente(e.getMessage());
                }
                break;
            case "NUEVAMESA":
                try {
                    int  nroMesa = Integer.parseInt(this.vista.getFormMesa().getNroMesa());
                    int  nroSillas = Integer.parseInt(this.vista.getFormMesa().getCantidadSillas());
                    this.modelo.altaMesa(nroSillas);
                    this.vista.renderListaMesas(this.modelo.getMesas());
                    this.vista.hideFormMesa();
                }
                catch(Exception e){
                    Mensajes.lanzarVentanaEmergente("Ingrese los datos correctamente");
                }
                break;
            case "INGRESAR_MESA":
                this.vista.estadoAgregarMesa();
                this.vista.showFormMesa();
                break;
            case "INGRESAR_MESA2":
                if (this.vista.getSelectedMesas() != null) {
                    this.vista.estadoModificarMesa();
                    this.vista.showFormMesa();
                }else{
                    Mensajes.lanzarVentanaEmergente("Seleccione una mesa");
                }
                break;
            case "ELIMINAR_MESA":
                if (this.vista.getSelectedMesas() != null) {
                    this.modelo.bajaMesa(this.vista.getSelectedMesas());
                    this.vista.renderListaMesas(this.modelo.getMesas());
                }
                else{
                    Mensajes.lanzarVentanaEmergente("Seleccione una mesa");
                }
                break;
            case "MODIFICAR_MESA":
                try {
                    int sillas = Integer.parseInt(this.vista.getFormMesa().getCantidadSillas());
                    this.modelo.modificaMesa(sillas,this.vista.getSelectedMesas().getEstado(), this.vista.getSelectedMesas());
                    this.vista.hideFormMesa();
                    this.vista.renderListaMesas(this.modelo.getMesas());
                }
                catch (Exception e){
                    Mensajes.lanzarVentanaEmergente("Ingrese los datos correctamente");
                }
                break;

        }
    }


}