package controladores;

import modelo.Empresa;
import vistas.VistaRegistrarse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarse implements ActionListener{
    private VistaRegistrarse vista;
    private Empresa modelo;

    public ControladorRegistrarse(VistaRegistrarse vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "Registrarse":
                //vista.creaOtraVentana("Register");
                break;
            case "REGISTRARSE":
                try {
                    System.out.printf(vista.getUsuario() + vista.getContrasena() + vista.getApellido());
                    modelo.signup(vista.getApellido(),vista.getUsuario(), vista.getContrasena(),true);
                    this.vista.hideWindow();
                    //modelo = Empresa.getInstance().login();
                    //vista.setObservado(modelo);
//                    modelo.loguearse();
//                } catch (ErrorDeContrasenaException e1) {
//                    JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
//                    vista.contrasenaInvalida();
//                } catch (ErrorDeUsuarioException e2) {
//                    JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
//                    vista.nombreUsuarioInvalido();
//                }
                }
                catch(Exception e){
                    System.out.printf("Excepcion");
                }
                break;
        }
    }


}