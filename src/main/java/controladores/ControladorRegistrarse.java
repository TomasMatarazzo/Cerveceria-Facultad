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
            case "REGISTRARSE":
                try {
<<<<<<< Updated upstream
                    this.modelo.signup(vista.getApellido(),vista.getUsuario(), vista.getContrasena(),true);
=======
                        this.modelo.signup(vista.getApellido(),vista.getUsuario(), vista.getContrasena(),true);
>>>>>>> Stashed changes
                    this.vista.hideWindow();
                }
                catch(Exception e){
                    System.out.printf("Excepcion");
                }
                break;
        }
    }


}