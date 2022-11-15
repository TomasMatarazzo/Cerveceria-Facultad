package modelo;

import org.junit.jupiter.api.*;

import java.util.GregorianCalendar;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class EstadisticasTest {
    Mozo mozo1;
    TreeSet<Mozo> mozos;
    TreeSet<Mesa> mesas;
    Mozo mozo2;
    Mesa mesa1;
    Mesa mesa2;

    @Nested
    @DisplayName("test estadisticas conjunto vacio")
    class estadisticasConjuntoVacioTest {
        @BeforeEach
        void setUp() throws Exception {
            mozos = new TreeSet<>();
            mesas = new TreeSet<>();
            mozo1 = new Mozo("Tomas", new GregorianCalendar(2000, 12, 12), 0, 1);
            mozo2 = new Mozo("Matias", new GregorianCalendar(2000, 12, 12), 0, 1);
            mesa1 = new Mesa(3);
            mesa2 = new Mesa(3);
        }

        @AfterEach
        void tearDown() {
        }

        /**
         * metodo MAYOR VOLUMEN VENTA clase ESTADISTICAS
         * <p>
         * PRECONDICIONES
         * Coleccion de mozo distinto NULL
         * <p>
         * Se quiere mostrar el mozo con mayor volumen de ventas en una coleccion vacia
         */
        @Test
        void mayorVolumenVenta1() {
            String respuesta;
            try {
                respuesta = Estadisticas.mayorVolumenVenta(mozos);
                assertTrue(respuesta == null, "ERROR AL CALCULAR MOZO CON MAYOR VENTAS");

            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }
        /**
         * metodo MENOR VOLUMEN VENTA clase ESTADISTICAS
         * <p>
         * PRECONDICIONES
         * Coleccion de mozo distinto null
         * <p>
         * Se quiere mostrar el mozo con menor volumen de ventas en una coleccion vacia
         */
        @Test
        void menorVolumenVenta1() {
            String respuesta;
            try {
                respuesta = Estadisticas.menorVolumenVenta(mozos);
                assertTrue(respuesta == null, "ERROR AL CALCULAR MOZO CON MAYOR VENTAS");

            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }

        /**
         * metodo PROMEDIO  VENTAS MESAS clase ESTADISTICAS
         * <p>
         * PRECONDICIONES
         * Coleccion de mesas distinto null
         * <p>
         * Se quiere mostrar el promedio de ventas de las mesas en una coleccion vacia
         */
        @Test
        void promedioPorMesas1() {
            double respuesta;
            try {
                respuesta = Estadisticas.promedioPorMesa(mesas);
                assertTrue(respuesta == 0., "ERROR AL CALCULAR PROMEDIO DE VENTAS POR MESA");

            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }

    }
    @Nested
    @DisplayName("test estadisticas conjunto lleno")
    class estadisticasConjuntoLlenoTest {
        @BeforeEach
        void setUp() throws Exception {
            mozos = new TreeSet<>();
            mesas = new TreeSet<>();
            mozo1 = new Mozo("Tomas", new GregorianCalendar(2000, 12, 12), 0, 1);
            mozo2 = new Mozo("Matias", new GregorianCalendar(2000, 12, 12), 0, 1);
            mesa1 = new Mesa(3);
            mesa2 = new Mesa(3);
            mesa1.setCantComandas(1);
            mesa2.setCantComandas(1);
            mesa1.setTotalComandas(1000);
            mesa2.setTotalComandas(1000);
            mozo1.setVentas(10);
            mozo2.setVentas(100);
            mozos.add(mozo1);
            mozos.add(mozo2);
            mesas.add(mesa1);
            mesas.add(mesa2);
        }

        @AfterEach
        void tearDown() {
        }

        /**
         * Se quiere mostrar el mozo con menor volumen de ventas entre dos mozos
         */
        @Test
        void menorVolumenVenta2() {
            String respuesta;
            try {
                respuesta = Estadisticas.menorVolumenVenta(mozos);
                assertTrue(respuesta.equalsIgnoreCase(mozo1.getNombreYApellido()), "ERROR AL CALCULAR MOZO CON MAYOR VENTAS");

            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }

        /**
         * Se quiere mostrar el promedio de ventas de las mesas en una coleccion con dos mesas
         */
        @Test
        void promedioPorMesas2() {
            double respuesta;
            try {
                respuesta = Estadisticas.promedioPorMesa(mesas);
                assertTrue(respuesta == 1000, "ERROR AL CALCULAR PROMEDIO DE  VENTAS POR MESA");

            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }
        /**
         * Se quiere mostrar el mozo con mayor volumen de ventas entre dos mozos
         */
        @Test
        void mayorVolumenVenta2() {
            String respuesta;
            try {
                respuesta = Estadisticas.mayorVolumenVenta(mozos);
                assertTrue(respuesta.equalsIgnoreCase(mozo2.getNombreYApellido()), "ERROR AL CALCULAR MOZO CON MAYOR VENTAS");

            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }
    }
}