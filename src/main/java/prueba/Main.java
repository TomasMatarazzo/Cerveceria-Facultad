package prueba;

import controladores.ControladorLogin;
import modelo.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import vistas.FormPassword;
import vistas.VistaLogin;

import java.io.IOException;
import java.util.Calendar;
import java.util.TreeSet;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        Empresa cerveceria=null;

        try {
            try {
                IPersistencia persistencia=new PersistenciaBIN();
                persistencia.abrirInput("Cerveceria.bin");
                cerveceria=(Empresa) persistencia.leer();
                persistencia.cerrarInput();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

            /*TreeSet<Mozo> mozos = cerveceria.getMozos();
            TreeSet<Producto> productos = cerveceria.getProductos();
            TreeSet<Operario> operarios = cerveceria.getOperarios();
            TreeSet<Mesa> mesas=cerveceria.getMesas();*/
            TreeSet<Operario> operarios=new TreeSet<>();
            operarios.add(new Operario("ADMIN","ADMIN","ADMIN1234",true));

            //System.out.println(operarios.toString());

            VistaLogin vista = new VistaLogin();
            Empresa empresa = new Empresa("CerveceriaProgra",null,null,null,operarios);

            FormPassword form = new FormPassword();
            ControladorLogin controlador = new ControladorLogin(vista,empresa,form);
            vista.ejecutar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
