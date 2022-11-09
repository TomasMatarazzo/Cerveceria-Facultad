package controladores;

import modelo.Empresa;
import vistas.VistaLogin;

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
            case "Registrarse":
                //vista.creaOtraVentana("Register");
                break;
            case "LOGIN":
                try {
                    System.out.printf(vista.getUsuario() + vista.getContrasena());
                }
                catch(Exception e){
                    System.out.printf("Excepcion");
                }
                break;
        }
    }


}