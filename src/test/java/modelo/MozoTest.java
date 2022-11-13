package modelo;

import excepciones.MozoIncorrecto;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class MozoTest {

    Empresa empresa;

    @Nested
    @DisplayName("AGREGAR UN NUEVO MOZO AL SISTEMA")
    class mozoTest {
        @BeforeEach
        void setUp() {
            TreeSet<Mozo> mozos = new TreeSet<>();

            empresa = new Empresa("Cerveceria", mozos, null, null, null);

        }

        @AfterEach
        void tearDown() {
            empresa.getMozos().clear();
        }

        /**
         * metodo AGREGAR MOZO clase Empresa
         * <p>
         * PRECONDICIONES
         * nombreYApellido distinto de vacio y null
         * fecha de Nacimiento distinto de null
         * Estado solo validos ( 1, 2, 3 )
         * <p>
         * <p>
         * Se quiere agregar un mozo correcto
         */
        @Test
        void agregarMozo1() {
            String nombre = "Matias Angelico";
            Calendar fechaNac = new GregorianCalendar(1996,12,12);
            int hijos = 0;
            int estado = 0;

            try {
                empresa.agregaMozo(nombre,fechaNac,hijos,estado);
                assertTrue(empresa.getMozos().size()==1,"ERROR AL AGREGAR UN MOZO VALIDO");
            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }

        /**
         * Se quiere agregar un mozo con cantidad de hijos menor a cero
         */
        @Test
        void agregarMozo2() {
            String nombre = "Matias Angelico";
            Calendar fechaNac = new GregorianCalendar(1996,12,12);
            int hijos = -1;
            int estado = 0;

            try {
                empresa.agregaMozo(nombre,fechaNac,hijos,estado);
                fail("AGREGAR UN MOZO CON CANTIDAD DE HIJOS MENOR A CERO NO LANZA EXCEPCION");
            } catch (Exception e) {
                final String msg = "Cant de hijos menor a cero";
                assertEquals(msg, e.getMessage());
            }

        }

        /**
         * Se quiere agregar un mozo con estado Invalido ( int > 3 )
         */
        @Test
        void agregarMozo3() {
            String nombre = "Matias Angelico";
            Calendar fechaNac = new GregorianCalendar(1996,12,12);
            int hijos = 1;
            int estado = 4;

            try {
                empresa.agregaMozo(nombre,fechaNac,hijos,estado);
                fail("AGREGAR UN MOZO CON ESTADO INVALIDO NO LANZA EXCEPCION");
            } catch (Exception e) {
                final String msg = "Estado Invalido";
                assertEquals(msg, e.getMessage());
            }

        }

        /**
         * se quiere agregar un mozo menor de edad
         */
        @Test
        void agregarMozo5() {
            String nombre = "Matias Angelico";
            Calendar fechaNac = new GregorianCalendar(2014,12,1);
            int hijos = 1;
            int estado = 1;

            try {
                empresa.agregaMozo(nombre,fechaNac,hijos,estado);
                fail("AGREGAR UN MOZO MENOR DE EDAD NO LANZA EXCEPCION");
            } catch (Exception e) {
                final String msg = "Edad menor a 18 anos";
                assertEquals(msg, e.getMessage());
            }
        }
    }
}