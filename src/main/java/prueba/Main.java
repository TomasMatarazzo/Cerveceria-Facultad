package prueba;

import controladores.ControladorLogin;
import controladores.ControladorPrincipal;
import modelo.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import vistas.FormPassword;
import vistas.VistaLogin;
import vistas.VistaPrincipal;

import java.io.IOException;
import java.util.Calendar;
import java.util.TreeSet;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            IPersistencia persistencia=new PersistenciaBIN();
            Producto prod1 = new Producto(0, "hola1", 12, 24, 15);
            Producto prod2 = new Producto(2, "hola1", 12, 24, 15);
            Producto prod3 = new Producto(3, "hola1", 12, 24, 15);
            TreeSet<Producto> productos = new TreeSet<>();
            productos.add(prod1);
            productos.add(prod2);
            productos.add(prod3);

            System.out.println("1111");

            Mozo mozo1 = new Mozo("ignacitoo", Calendar.getInstance(),3,0);
            Mozo mozo2 = new Mozo("ignacito1o",Calendar.getInstance(),3,1);
            Mozo mozo3 = new Mozo("ignacito2o",Calendar.getInstance(),3,2);

            TreeSet<Mozo> mozos = new TreeSet<>();
            TreeSet<Mesa> mesas=new TreeSet<Mesa>();
            TreeSet<Operario> operarios=new TreeSet<Operario>();

            Operario op = new Operario("matarazzo","ADMIN","ADMIN1234",true);
            op.setAdministrador();
            operarios.add(op);

            mozos.add(mozo1);
            mozos.add(mozo2);
            mozos.add(mozo3);

            VistaLogin vista = new VistaLogin();
            Empresa empresa = new Empresa("CerveceriaProgra",mozos,mesas,productos,operarios);

            System.out.println(empresa);

            System.out.printf(empresa.getOperarios().first().toString());
            FormPassword form = new FormPassword();
            ControladorLogin controlador = new ControladorLogin(vista,empresa,form);
            vista.ejecutar();


            try {
                persistencia.abrirOutput("Cerveceria.bin");
                System.out.println("Crea archivo escritura");
                System.out.println(empresa);
                persistencia.escribir(empresa);
                System.out.println("Empresa grabado exitosamente");
                persistencia.cerrarOutput();
                System.out.println("Archivo cerrado");
            }
            catch (IOException e){
                System.out.println(e.getLocalizedMessage());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
