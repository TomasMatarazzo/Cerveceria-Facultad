package controladores;

import modelo.Empresa;
import controladores.vistas.VistaRegistrarse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarse implements ActionListener{
    private VistaRegistrarse vista;
    private Empresa modelo;

    public ControladorRegistrarse(VistaRegistrarse vista) {
        this.vista = vista;
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