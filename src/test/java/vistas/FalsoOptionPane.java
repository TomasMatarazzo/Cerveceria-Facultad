package vistas;

import java.awt.Component;

public class FalsoOptionPane {
    private String mensaje = null;

    public FalsoOptionPane() {
        super();
    }

    public void ShowMessage(Component parent, String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
