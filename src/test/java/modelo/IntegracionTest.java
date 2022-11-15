package modelo;

import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de integracion. Casos de prueba:")
class IntegracionTest {
    Empresa empresa;

    @Test
    @DisplayName("6. Empresa ausente causa falla de ejecucion lanzando una excepcion")
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
        @DisplayName("7. Mesa ausente causa falla de ejecucion lanzando una excepcion")
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

        @Test
        @DisplayName("8-9. Mozo de Franco o Ausente lanza una excepcion")
        void altaComandaTest5() {
            try {
                Mesa mesa1 = new Mesa(10);
                Mesa mesa2 = new Mesa(5);
                Mozo mozoDeFranco = new Mozo("mozoPrueba1", null, 2, 2);
                Mozo mozoAusente = new Mozo("mozoPrueba2", null, 2, 1);
                Producto producto = new Producto("productoPrueba", 100, 150, 100);
                Pedido pedido = new Pedido(producto, 10);

                assertAll(
                        () -> assertThrows(Exception.class, () -> empresa.altaComanda(mesa1, mozoDeFranco, pedido)),
                        () -> assertThrows(Exception.class, () -> empresa.altaComanda(mesa2, mozoAusente, pedido))
                );
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }
    }
}