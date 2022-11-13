package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    Empresa empresa;
    Comanda comanda;
    Mozo mozo;
    Pedido pedido;
    Producto producto;
    Mesa mesa;
    String formaPago;
    @BeforeEach
    void setUp() throws Exception {
        producto = new Producto("coca",100,200,3);
        pedido = new Pedido(producto,1);
        mesa = new Mesa(3);
        mozo =new Mozo("Matias",new GregorianCalendar(1990,12,12),0,1);
        comanda = new Comanda(mesa,mozo);
        comanda.agregarPedido(pedido);
        empresa = new Empresa("Cerveceria", null, null, null, null);
        empresa.altaComanda(mesa,mozo,pedido);
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
    void generarFactura1() {
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
    void generarFactura2() throws Exception {
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
    /**
     * metodo CREAR FACTURA clase Empresa
     *
     * PRECONDICIONES
     * Comanda distinto vacio y null
     *
     * Se quiere crear una factura valida
     */
    @Test
    void crearFactura1() {
        formaPago = "efectivo";
        try {
            empresa.crearFactura(mesa,formaPago);
            assertTrue(empresa.getComandas().size()==0,"ERROR AL BORRAR COMANDA");

        } catch (Exception e) {
            fail("NO DEBERIA LANZAR EXCEPCION");
        }

    }
}