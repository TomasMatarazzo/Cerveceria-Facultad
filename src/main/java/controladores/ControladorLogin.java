package controladores;

import Utils.Mensajes;
import interfaces.IVista;
import modelo.Empresa;
import modelo.Operario;
import vistas.VistaLogin;
import vistas.VistaPrincipal;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener{
    private VistaLogin vista;
    private Empresa modelo;

    public ControladorLogin(VistaLogin vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "LOGIN":
                try {
                    Operario op = this.modelo.login(this.vista.getUsuario() , this.vista.getContrasena());
                    if (op != null) {
                        System.out.printf("ana");
                        VistaPrincipal vistaP = new VistaPrincipal(op);
                        System.out.printf("she");
                        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vistaP, this.modelo);
                        System.out.printf("nati");
                        vistaP.ejecutar();
                        this.vista.setVisible(false);

                    }
                    else{
                        Mensajes.lanzarVentanaEmergente("DATOS INCORRECTOS");
                    }
                }
                catch(Exception e){
                    Mensajes.lanzarVentanaEmergente(e.getMessage());
                }
                break;
        }
    }
}