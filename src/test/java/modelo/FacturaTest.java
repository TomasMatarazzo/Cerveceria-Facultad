package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    Empresa empresa;
    Comanda comanda;

    Pedido pedido;
    Producto producto;
    Mesa mesa;
    @BeforeEach
    void setUp() throws Exception {
        producto = new Producto("coca",100,200,3);
        pedido = new Pedido(producto,1);
        mesa = new Mesa(3);
        comanda = new Comanda(mesa,new Mozo("Matias",new GregorianCalendar(1990,12,12),0,1));
        comanda.agregarPedido(pedido);
        empresa = new Empresa("Cerveceria", null, null, null, null);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * metodo GENERAR FACTURA clase Empresa
     *
     * PRECONDICIONES
     * Comanda distinto vacio y null
     *
     * Se quiere generar una factura valida
     */
    @Test
    void crearFactura1() {
        double total;
        try {
            total =empresa.generarFactura(comanda);
            assertTrue(total == pedido.getCantidad()*producto.getPrecioVenta(),"ERROR AL CALCULAR TOTAL");

        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }

    }

    /**
     * Se quiere crear una factura con una mesa Libre
     */
    @Test
    void crearFactura2() throws Exception {
        double total;
        mesa.setEstado("Libre");
        try {
            total =empresa.generarFactura(comanda);
            fail("DEBERIA LANZAR EXCEPCION");

        } catch (Exception e) {
            final String msg = "Imposible crear una Factura sobre una mesa Libre";
            assertEquals(msg, e.getMessage());
        }
    }

}