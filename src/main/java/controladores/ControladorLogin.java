package controladores;

import Utils.Mensajes;
import modelo.Empresa;
import modelo.Operario;
import vistas.FormPassword;
import vistas.VistaLogin;
import vistas.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener{
    private VistaLogin vista;
    private Empresa modelo;
    private FormPassword form;
    Operario op;

    public ControladorLogin(VistaLogin vista, Empresa modelo, FormPassword form) {
        this.vista = vista;
        this.modelo = modelo;
        this.form = form;
        this.vista.setActionListener(this);
        this.form.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        switch (evento.getActionCommand()) {
            case "LOGIN":
                try {
                    this.op = this.modelo.login(this.vista.getUsuario() , this.vista.getContrasena());
                    if (op != null) {
                        VistaPrincipal vistaP = new VistaPrincipal(op);
                        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vistaP, this.modelo);
                        if ( op.getPassword() == "ADMIN1234"){
                            this.form.ejecutar();
                        }else{
                            vistaP.ejecutar();
                            this.vista.setVisible(false);
                        }
                    }
                    else{
                        Mensajes.lanzarVentanaEmergente("DATOS INCORRECTOS");
                    }
                }
                catch(Exception e){
                    Mensajes.lanzarVentanaEmergente("Error");
                }
                break;
            case "PASSWORD_ADMIN":
                System.out.printf("evento para cambiar contra");
                try {
                    this.modelo.modificarPassword(this.form.getPassword());
                    VistaPrincipal vistaP = new VistaPrincipal(op);
                    ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vistaP, this.modelo);
                    this.vista.setVisible(false);
                    this.form.hideForm();
                    vistaP.ejecutar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}