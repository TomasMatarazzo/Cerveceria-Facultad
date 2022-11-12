package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Empresa empresa;

    Producto producto;

    int cantidad;


    @BeforeEach
    void setUp() throws Exception {
        producto = new Producto("Coca",200,300,5);
        empresa = new Empresa("Cerveceria", null, null, null, null);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * metodo REALIZAR PEDIDO  clase Empresa
     *
     * PRECONDICIONES
     * producto distinto de null
     * cantidad mayor a cero
     *
     * Se quiere realizar un pedido valido
     */
    @Test
    void realizarPedido1() {
        cantidad = 1;
        try {
            empresa.realizarPedido(producto,cantidad);
            assertTrue(empresa.getPedidos().size()==0,"ERROR AL AGREGAR UN PEDIDO");
        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }
    }

    /**
     * Se quiere realizar un pedido con una cantidad mayor al stock disponible
     */
    @Test
    void realizarPedido2() {
        cantidad = 10;
        try {
            empresa.realizarPedido(producto,cantidad);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (Exception e) {
            final String msg = "No hay stock suficiente";
            assertEquals(msg, e.getMessage());
        }
    }
}