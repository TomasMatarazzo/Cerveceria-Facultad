package prueba;

import controladores.ControladorPrincipal;
import vistas.VistaPrincipal;
import modelo.Empresa;
import modelo.Mozo;
import modelo.Producto;

import java.util.Calendar;
import java.util.TreeSet;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            System.out.printf("ansdf;lkajsdfl;ka");
            Producto prod1 = new Producto(0, "hola1", 12, 24, 15);
            Producto prod2 = new Producto(2, "hola1", 12, 24, 15);
            Producto prod3 = new Producto(3, "hola1", 12, 24, 15);
            TreeSet<Producto> productos = new TreeSet<>();
            productos.add(prod1);
            productos.add(prod2);
            productos.add(prod3);

            Mozo mozo1 = new Mozo("ignacitoo", Calendar.getInstance(),3,0);
            Mozo mozo2 = new Mozo("ignacito1o",Calendar.getInstance(),3,1);
            Mozo mozo3 = new Mozo("ignacito2o",Calendar.getInstance(),3,2);

            TreeSet<Mozo> mozos = new TreeSet<>();
            mozos.add(mozo1);
            mozos.add(mozo2);
            mozos.add(mozo3);



            VistaPrincipal frame = new VistaPrincipal();
            Empresa empresa = new Empresa();
            empresa.setMozos(mozos);
            empresa.setProductos(productos);
            ControladorPrincipal controlador = new ControladorPrincipal(frame,empresa);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
