package Utils;

import javax.swing.*;

public class Mensajes {
    public static void  lanzarVentanaEmergente(String mensaje){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }
}
