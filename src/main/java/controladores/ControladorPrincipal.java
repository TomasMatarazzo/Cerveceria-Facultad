package controladores;

import controladores.vistas.VistaComandas;
import controladores.vistas.VistaInventario;
import modelo.Empresa;
import controladores.vistas.VistaEstadisticas;
import controladores.vistas.VistaPrincipal;
import modelo.Mozo;
import modelo.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TreeSet;

public class ControladorPrincipal implements ActionListener{
    private VistaPrincipal vista;
    private Empresa modelo;

    public ControladorPrincipal(VistaPrincipal vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Mozo mozo1 = new Mozo("ignacitoo", Calendar.getInstance(),3,0);
        Mozo mozo2 = new Mozo("ignacito1o",Calendar.getInstance(),3,1);
        Mozo mozo3 = new Mozo("ignacito2o",Calendar.getInstance(),3,2);

        TreeSet<Mozo> mozos = new TreeSet<>();
        mozos.add(mozo1);
        mozos.add(mozo2);
        mozos.add(mozo3);
        switch (evento.getActionCommand()) {
            case "FORMDATOS":
                //vista.creaOtraVentana("Register");
                this.vista.showFormSueldo();
                break;
            case "MODIFICAR_DATOS":
                try {
//                    this.modelo.setNombreEmpresa( this.vista.getFormSueldo().getNombre());
//                    this.modelo.setSueldoBasico( Double.parseDouble(this.vista.getFormSueldo().getSueldo()));
                    this.vista.setNombre(this.vista.getFormSueldo().getNombre());
                    this.vista.setSueldo(this.vista.getFormSueldo().getSueldo());
                    this.vista.hideFormSueldo();
                    //modelo = Empresa.getInstance().Principal();
                    //vista.setObservado(modelo);
//                    modelo.loguearse();
//                } catch (ErrorDeContrasenaException e1) {
//                    JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
//                    vista.contrasenaInvalida();
//                } catch (ErrorDeUsuarioException e2) {
//                    JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
//                    vista.nombreUsuarioInvalido();
//                }
                }
                catch(Exception e){
                    System.out.printf("Excepcion");
                }
                break;
            case "ESTADISTICAS":
                //VistaEstadisticas ventanaEstadisticas = new VistaEstadisticas(Estadisticas.mayorVolumenVenta(this.modelo.getMozos()),Estadisticas.menorVolumenVenta(this.modelo.getMozos()), String.valueOf(Estadisticas.promedioPorMesa(this.modelo.getMesas())));
                VistaEstadisticas ventanaEstadisticas = new VistaEstadisticas("Martin","Tomas","4523");
                ventanaEstadisticas.ejecutar();

                break;
            case "COMANDAS":

                try {
                    Producto prod1 = new Producto(0, "hola1", 12, 24, 15);
                    Producto prod2 = new Producto(2, "hola1", 12, 24, 15);
                    Producto prod3 = new Producto(3, "hola1", 12, 24, 15);
                    TreeSet<Producto> productos = new TreeSet<>();
                    productos.add(prod1);
                    productos.add(prod2);
                    productos.add(prod3);

                    //lo de arriba dps se va
                    VistaComandas vistaComandas= new VistaComandas(mozos,productos);
                    ControladorComandas controlador = new ControladorComandas(vistaComandas);
                    //vistaComandas.ejecutar();

                }
                catch(Exception e){
                    System.out.printf("hoal");
                }

            case "GESTIONES":
                VistaInventario frame = new VistaInventario(mozos);
                ControladorInventario controlador = new ControladorInventario(frame);
                frame.ejecutar();
        }
    }


}