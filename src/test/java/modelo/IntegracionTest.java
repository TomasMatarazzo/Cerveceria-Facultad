package modelo;

import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de integracion. Casos de prueba:")
class IntegracionTest {
    Empresa empresa;

    @Nested
    @DisplayName("1. VistaPrincipal ausente")
    class CasoDePrueba1 {
        @BeforeEach
        void setUp() {
        }

        @AfterEach
        void tearDown() {
        }

        @Test
        void altaComandaTest1() {
        }
    }

    @Nested
    @DisplayName("2. VistaNuevasComandas ausente")
    class CasoDePrueba2 {
        @BeforeEach
        void setUp() {
        }

        @AfterEach
        void tearDown() {
        }

        @Test
        void altaComandaTest1() {
        }
    }

    @Test
    @DisplayName("3. Empresa ausente causa falla de ejecucion lanzando una excepcion")
    void altaComandaTest3() {
        try {
            Empresa empresa = null;
            Mesa mesa = new Mesa(10);
            Mozo mozo = new Mozo("mozoPrueba", null, 2, 0);
            Producto producto = new Producto("productoPrueba", 100, 150, 100);
            Pedido pedido = new Pedido(producto, 10);

            assertThrows(NullPointerException.class, () -> empresa.altaComanda(mesa, mozo, pedido));
        } catch (Exception e) {
            fail("Esta prueba no deberia disparar una excepcion");
        }
    }

    @Nested
    @DisplayName("4. Mesa ausente causa falla de ejecucion lanzando una excepcion")
    class CasoDePrueba4 {
        @BeforeEach
        void setUp() {
            TreeSet<Operario> operarios = new TreeSet<>();
            TreeSet<Mozo> mozos = new TreeSet<>();
            TreeSet<Producto> productos = new TreeSet<>();
            TreeSet<Mesa> mesas = new TreeSet<>();

            empresa = new Empresa("NombrePrueba", mozos, mesas, productos, operarios);
        }

        @AfterEach
        void tearDown() {
            empresa = null;
        }

        @Test
        void altaComandaTest4() {
            try {
                Mesa mesa = null;
                Mozo mozo = new Mozo("mozoPrueba", null, 2, 0);
                Producto producto = new Producto("productoPrueba", 100, 150, 100);
                Pedido pedido = new Pedido(producto, 10);

                assertThrows(NullPointerException.class, () -> empresa.altaComanda(mesa, mozo, pedido));
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }
    }
}