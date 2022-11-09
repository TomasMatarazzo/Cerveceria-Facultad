package prueba;

import controladores.ControladorPrincipal;
import controladores.vistas.VistaPrincipal;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            VistaPrincipal frame = new VistaPrincipal();
            ControladorPrincipal controlador = new ControladorPrincipal(frame);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
