package prueba;

import controladores.ControladorLogin;
import controladores.ControladorPrincipal;
import modelo.*;
import vistas.FormPassword;
import vistas.VistaLogin;
import vistas.VistaPrincipal;

import java.util.Calendar;
import java.util.TreeSet;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            Producto prod1 = new Producto( "hola1", 12, 24, 100);
            Producto prod2 = new Producto( "hola1", 12, 24, 100);
            Producto prod3 = new Producto( "hola1", 12, 24, 100);
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
            Mesa mesa1 = new Mesa(10);
            Mesa mesa2 = new Mesa(20);
            TreeSet<Mesa> mesas = new TreeSet<Mesa>();
            mesas.add(mesa1);
            mesas.add(mesa2);




            VistaLogin vista = new VistaLogin();
            Empresa empresa = new Empresa();
            empresa.setMozos(mozos);
            empresa.setProductos(productos);
            empresa.setMesas(mesas);
            Operario op = new Operario("matarazzo","ADMIN","ADMIN1234",true);
            op.setAdministrador();
            TreeSet<Operario> operarios = new TreeSet<>();
            operarios.add(op);
            empresa.setOperarios(operarios);


            FormPassword form = new FormPassword();
            ControladorLogin controlador = new ControladorLogin(vista,empresa,form);
            vista.ejecutar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
