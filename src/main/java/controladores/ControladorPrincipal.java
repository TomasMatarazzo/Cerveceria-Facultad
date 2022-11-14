package controladores;

import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import vistas.*;
import modelo.Empresa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class ControladorPrincipal implements ActionListener, WindowListener {
    private VistaPrincipal vista;
    private Empresa modelo;

    public ControladorPrincipal(VistaPrincipal vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
        this.vista.addWindowListener(this);
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
            case "NUEVAS_COMANDAS":
                VistaNuevaComandas ventanaNuevasComandas = new VistaNuevaComandas(this.modelo.getComandas(),this.modelo.getPedidos());
                ControladorNuevasComandas controladorNuevasComandas = new ControladorNuevasComandas(ventanaNuevasComandas,this.modelo);
                ventanaNuevasComandas.ejecutar();
                break;
            case "REGISTRAR":
                VistaRegistrarse ventanaRegistrarse = new VistaRegistrarse();
                ControladorRegistrarse controladorLogin = new ControladorRegistrarse(ventanaRegistrarse,this.modelo);
                ventanaRegistrarse.ejecutar();
                break;
            case "ESTADISTICAS":
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
                break;
            case "COMENZAR_JORNADA":
                this.vista.arrancoJornada();
                break;
            case "FINALIZAR_JORNADA":
                this.vista.terminoJornada();
                break;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            IPersistencia persistencia = new PersistenciaBIN();
            Empresa empresa = new Empresa(this.modelo.getNombreEmpresa(),this.modelo.getMozos(),this.modelo.getMesas(),this.modelo.getProductos(),this.modelo.getOperarios());
            persistencia.abrirOutput("Cerveceria.bin");
            persistencia.escribir(empresa);
            persistencia.cerrarOutput();
        }
        catch (IOException o){
            System.out.println(o.getLocalizedMessage());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


}