package controladores;

import modelo.Empresa;
import controladores.vistas.VistaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener{
    private VistaLogin vista;
    private Empresa modelo;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "Registrarse":
                //vista.creaOtraVentana("Register");
                break;
            case "LOGIN":
                try {
                    System.out.printf(vista.getUsuario() + vista.getContrasena());
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