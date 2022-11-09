package controladores;

import vistas.VistaComandas;
import vistas.VistaInventario;
import modelo.Empresa;
import vistas.VistaEstadisticas;
import vistas.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener{
    private VistaPrincipal vista;
    private Empresa modelo;

    public ControladorPrincipal(VistaPrincipal vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "FORMDATOS":
                this.vista.showFormSueldo();
                break;
            case "MODIFICAR_DATOS":
                try {
                    this.vista.setNombre(this.vista.getFormSueldo().getNombre());
                    this.vista.setSueldo(this.vista.getFormSueldo().getSueldo());
                    this.vista.hideFormSueldo();
                }
                catch(Exception e){
                    System.out.printf("Excepcion");
                }
                break;
            case "REGISTRAR":
                
            case "ESTADISTICAS":
                //VistaEstadisticas ventanaEstadisticas = new VistaEstadisticas(Estadisticas.mayorVolumenVenta(this.modelo.getMozos()),Estadisticas.menorVolumenVenta(this.modelo.getMozos()), String.valueOf(Estadisticas.promedioPorMesa(this.modelo.getMesas())));
                VistaEstadisticas ventanaEstadisticas = new VistaEstadisticas("Martin","Tomas","4523");
                ventanaEstadisticas.ejecutar();
                break;
            case "COMANDAS":
                try {
                    VistaComandas vistaComandas = new VistaComandas(this.modelo.getProductos(),this.modelo.getMesas(), this.modelo.getMozos(), this.modelo.getPedidos());
                    ControladorComandas controlador = new ControladorComandas(vistaComandas,this.modelo);
                    vistaComandas.ejecutar();
                }
                catch(Exception e){
                    System.out.printf(e.getMessage());
                }
                break;
            case "GESTIONES":
                VistaInventario frame = new VistaInventario(this.modelo.getMozos() , this.modelo.getProductos(), this.modelo.getMesas());
                ControladorInventario controlador2 = new ControladorInventario(frame,this.modelo);
                frame.ejecutar();
        }
    }


}