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
        Empresa cerveceria = null;

        try {
            TreeSet<Operario> operarios = new TreeSet<>();
            TreeSet<Mozo> mozos = new TreeSet<>();
            TreeSet<Producto> productos = new TreeSet<>();
            TreeSet<Mesa> mesas = new TreeSet<>();
            try {
                IPersistencia persistencia=new PersistenciaBIN();
                persistencia.abrirInput("Cerveceria.bin");
                cerveceria = (Empresa) persistencia.leer();
                persistencia.cerrarInput();
                mozos = cerveceria.getMozos();
                productos = cerveceria.getProductos();
                operarios = cerveceria.getOperarios();
                mesas=cerveceria.getMesas();
            } catch (IOException e) {
                System.out.println("Se creo un nuevo archivo binario");
                Operario admin = new Operario("ADMIN","ADMIN","ADMIN1234",true);
                admin.setAdministrador();
                operarios.add(admin);
            }

            VistaLogin vista = new VistaLogin();
            Empresa empresa = new Empresa("CerveceriaProgra",mozos,mesas,productos,operarios);

            FormPassword form = new FormPassword();
            ControladorLogin controlador = new ControladorLogin(vista,empresa,form);
            vista.ejecutar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
