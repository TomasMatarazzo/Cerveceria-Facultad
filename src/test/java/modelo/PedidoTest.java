package modelo;

import excepciones.StockNoDisponible;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Empresa empresa;

    Pedido pedido2;
    Pedido pedido;
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
            pedido = empresa.realizarPedido(producto,cantidad);
            assertTrue(pedido.getProducto().equals(producto) && pedido.getCantidad()==cantidad,"ERROR AL AGREGAR UN PEDIDO");
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

    /**
     * metodo ALTA PEDIDO  clase Empresa
     *
     * PRECONDICIONES
     * pedido distinto de null
     *
     * Se quiere realizar un alta de pedido correcta
     */
    @Test
    void altaPedido1() throws StockNoDisponible {
        pedido = new Pedido(producto,1);
        try {
            empresa.altaPedido(pedido);
            assertTrue(empresa.getPedidos().size()==1,"ERROR AL AGREGAR UN PEDIDO");
        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }
    }

    /**
     * Se quiere realizar un alta de pedido correcta
     */
    @Test
    void altaPedido2() {
        try {
            pedido = new Pedido(producto,10);
            empresa.altaPedido(pedido);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (StockNoDisponible e) {
            final String msg = "No hay stock suficiente";
            assertEquals(msg, e.getMessage());
        }
    }
}