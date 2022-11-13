package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class ComandaTest {

    Empresa empresa;
    Comanda comanda;
    Mozo mozo;
    Pedido pedido;
    Producto producto;
    Mesa mesa;
    @BeforeEach
    void setUp() throws Exception {
        producto = new Producto("coca",100,200,3);
        pedido = new Pedido(producto,1);
        mesa = new Mesa(3);
        mozo =new Mozo("Matias",new GregorianCalendar(1990,12,12),0,1);
        empresa = new Empresa("Cerveceria", null, null, null, null);
    }

    @AfterEach
    void tearDown() {
    }


    /**
     * metodo ALTA COMANDA clase Empresa
     *
     * PRECONDICIONES
     * Comanda distinto vacio y null
     * Mesa distinto vacio y null
     * Mozo distinto vacio y null
     *
     * Se quiere dar de alta una comanda valida
     */
    @Test
    void agregarPedidoAComanda1() {
        try {
            empresa.altaComanda(mesa,mozo,pedido);
            assertTrue(empresa.getComandas().size()==1,"ERROR AL CREAR LA COMANDA");

        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }
    }


    /**
     * Se quiere dar de alta una comanda en una mesa ya ocupada
     */
    @Test
    void agregarPedidoAComanda2() throws Exception {
        mesa.setEstado("ocupada");
        try {
            empresa.altaComanda(mesa,mozo,pedido);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (Exception e) {
            final String msg = "Mesa Ocupada";
            assertEquals(msg, e.getMessage());
        }
    }
}