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
}