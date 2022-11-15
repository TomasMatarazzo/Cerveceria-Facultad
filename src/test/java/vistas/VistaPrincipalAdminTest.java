package vistas;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.TreeSet;
import javax.swing.JButton;

import controladores.ControladorPrincipal;
import modelo.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VistaPrincipalAdminTest {
    Robot robot;
    ControladorPrincipal controlador;
    VistaPrincipal vista;
    Empresa empresa;

    public VistaPrincipalAdminTest(){
        try {
            robot = new Robot();
        } catch (AWTException e) {

        }
    }

    @BeforeEach
    void setUp() {
        TreeSet<Mesa> mesas = new TreeSet<>();
        TreeSet<Mozo> mozos = new TreeSet<>();
        TreeSet<Producto> productos = new TreeSet<>();
        TreeSet<Operario> operarios = new TreeSet<>();
        empresa = new Empresa("Prueba GUI 1",mozos,mesas,productos,operarios);
        Operario op = new Operario("eee","matias","matias01",true);
        op.setAdministrador();
        vista = new VistaPrincipal(op);
        controlador = new ControladorPrincipal(vista,empresa);
        vista.ejecutar();
    }

    @AfterEach
    void tearDown() {
       controlador.getVista().setVisible(false);
    }

    @Test
    public void testBotonesDeshabilitados()
    {
        //obtengo las referencias a los componentes necesarios
        JButton nuevaComanda = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonNuevaComanda");
        JButton promocion = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonPromociones");
        JButton estadisticas = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonEstadisticas");

        assertFalse(nuevaComanda.isEnabled(), "El boton comandas deberia estar deshablitado");
        assertFalse(promocion.isEnabled(), "El boton promocion deberia estar deshablitado");
        assertFalse(estadisticas.isEnabled(), "El boton estadisticas deberia estar deshablitado");
    }

    @Test
    public void testBotonesHabilitados()
    {
        //obtengo las referencias a los componentes necesarios
        JButton gestiones = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonGestiones");
        JButton operario = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonOperario");
        JButton nuevaJornada = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComenzarJornada");
        JButton modificar = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonModificar");
        JButton comanda = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComandas");

        assertTrue(comanda.isEnabled(), "El boton comandas deberia estar hablitado");
        assertTrue(gestiones.isEnabled(), "El boton gestiones deberia estar hablitado");
        assertTrue(operario.isEnabled(), "El boton operario deberia estar hablitado");
        assertTrue(nuevaJornada.isEnabled(), "El boton Nueva jornada deberia estar hablitado");
        assertTrue(modificar.isEnabled(), "El boton modificar deberia estar hablitado");
    }

    @Test
    public void testIniciaJornada()
    {
        robot.delay(UtilsTest.getDelay());

        JButton gestiones = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonGestiones");
        JButton operario = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonOperario");
        JButton nuevaJornada = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComenzarJornada");
        JButton modificar = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonModificar");
        JButton comanda = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComandas");
        JButton nuevaComanda = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonNuevaComanda");
        JButton promocion = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonPromociones");
        JButton estadisticas = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonEstadisticas");

        UtilsTest.clickComponent(nuevaJornada, robot);

        assertTrue(comanda.isEnabled(), "El boton comandas deberia estar hablitado");
        assertTrue(gestiones.isEnabled(), "El boton gestiones deberia estar hablitado");
        assertTrue(operario.isEnabled(), "El boton operario deberia estar hablitado");
        assertTrue(nuevaJornada.isEnabled(), "El boton Nueva jornada deberia estar hablitado");
        assertTrue(modificar.isEnabled(), "El boton modificar deberia estar hablitado");
        assertTrue(nuevaComanda.isEnabled(), "El boton comandas deberia estar hablitado");
        assertTrue(promocion.isEnabled(), "El boton promocion deberia estar hablitado");
        assertTrue(estadisticas.isEnabled(), "El boton estadisticas deberia estar hablitado");
    }

    @Test
    public void testBotonEstadisticas()
    {
        robot.delay(UtilsTest.getDelay());
        JButton nuevaJornada = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComenzarJornada");
        UtilsTest.clickComponent(nuevaJornada, robot);
        JButton estadisticas = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonEstadisticas");
        UtilsTest.clickComponent(estadisticas, robot);
        assertTrue(controlador.getVentanaEmergente().getClass() == VistaEstadisticas.class, "NO CREA LA VENTANA CORRECTA");
    }

    @Test
    public void testBotonOperario()
    {
        robot.delay(UtilsTest.getDelay());
        JButton operario = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonOperario");
        UtilsTest.clickComponent(operario, robot);
        assertTrue(controlador.getVentanaEmergente().getClass() == VistaRegistrarse.class, "NO CREA LA VENTANA CORRECTA");
    }

    @Test
    public void testBotonNuevaComanda()
    {
        robot.delay(UtilsTest.getDelay());
        JButton nuevaComanda = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComandas");
        UtilsTest.clickComponent(nuevaComanda, robot);
        assertTrue(controlador.getVentanaEmergente().getClass() == VistaComandas.class, "NO CREA LA VENTANA CORRECTA");
    }

    @Test
    public void testBotonComandas()
    {
        robot.delay(UtilsTest.getDelay());
        JButton nuevaJornada = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComenzarJornada");
        UtilsTest.clickComponent(nuevaJornada, robot);
        JButton comandas = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonNuevaComanda");
        UtilsTest.clickComponent(comandas, robot);
        assertTrue(controlador.getVentanaEmergente().getClass() == VistaNuevaComandas.class, "NO CREA LA VENTANA CORRECTA");
    }

    @Test
    public void testBotonGestiones()
    {
        robot.delay(UtilsTest.getDelay());
        JButton gestiones = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonGestiones");
        UtilsTest.clickComponent(gestiones, robot);
        assertTrue(controlador.getVentanaEmergente().getClass() == VistaInventario.class, "NO CREA LA VENTANA CORRECTA");
    }
    @Test
    public void testBotonPromociones()
    {
        robot.delay(UtilsTest.getDelay());
        JButton nuevaJornada = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonComenzarJornada");
        UtilsTest.clickComponent(nuevaJornada, robot);
        JButton promociones = (JButton) UtilsTest.getComponentForName(controlador.getVista(), "botonPromociones");
        UtilsTest.clickComponent(promociones, robot);
        assertTrue(controlador.getVentanaEmergente().getClass() == VistaPromociones.class, "NO CREA LA VENTANA CORRECTA");
    }

}
