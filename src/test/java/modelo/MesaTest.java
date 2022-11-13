package modelo;

import excepciones.MozoIncorrecto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    Empresa empresa;
    Mesa mesa;
    Mesa mesa2;

    @BeforeEach
    void setUp() throws Exception {
        TreeSet<Mesa> mesas = new TreeSet<>();
        mesa = new Mesa(3);
        mesa2 =  new Mesa(5);
        empresa = new Empresa("Cerveceria", null, mesas, null, null);
    }

    @AfterEach
    void tearDown() {
        empresa.getMesas().clear();
    }

    /**
     * metodo BAJA MESA clase Empresa
     *
     * PRECONDICIONES
     * Mesa distinto de null
     *
     * Se da de baja una mesa presente en la coleccion de mesas
     */
    @Test
    void bajaMesa1() throws Exception {
        empresa.getMesas().add(mesa);
        try {
            empresa.bajaMesa(mesa);
            assertTrue(empresa.getMesas().size()==0,"ERROR AL BORRAR UNA MESA EXISTENTE");
        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }
    }

    /**
     * Se da de baja una mesa NO presente en la coleccion de mesas
     */
    @Test
    void bajaMesa2() {

        empresa.getMesas().add(mesa);
        try {
            empresa.bajaMesa(mesa2);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (Exception e) {
            final String msg = "No existe mesa";
            assertEquals(msg, e.getMessage());
        }
    }

    /**
     * Se quiere dar de baja una mesa. COLECCION DE MESAS VACIA
     */
    @Test
    void bajaMesa3() {
        try {
            empresa.bajaMesa(mesa2);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (Exception e) {
            final String msg = "No existe mesa";
            assertEquals(msg, e.getMessage());
        }
    }


    /**
     * metodo MODIFICA MESA clase Empresa
     *
     * PRECONDICIONES
     * Mesa distinto de null
     * estado solo valores validos
     * cantidad de personas enteros positivos
     *
     * Se quiere MODIFICAR una mesa valida
     */
    @Test
    void modificaMesa1() {
        int cantidad = 6;
        String est = "ocupada";
        try {
            empresa.modificaMesa(cantidad,est,mesa);
            assertTrue(mesa.getCantidadPersonas()==cantidad && mesa.getEstado().equalsIgnoreCase(est),"ERROR AL MODIFICAR UNA MESA ");
        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }
    }

    /**
     * metodo ALTA MESA clase Empresa
     *
     * PRECONDICIONES
     * cantidad de personas enteros positivos
     *
     * Se quiere MODIFICAR una mesa valida
     */
    @Test
    void altaMesa1() {
        int cantidad = 6;
        try {
            empresa.altaMesa(cantidad);
            assertTrue(empresa.getMesas().size()==1,"ERROR AL DAR DE ALTA UNA MESA");
        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }
    }

    /**
     * Se quiere MODIFICAR una mesa con cantidad de personas invalida
     */
    @Test
    void altaMesa2() {
        int cantidad = 0;
        try {
            empresa.altaMesa(cantidad);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (Exception e) {
            final String msg = "Pocas personas para dar de alta una mesa";
            assertEquals(msg, e.getMessage());
        }
    }
}