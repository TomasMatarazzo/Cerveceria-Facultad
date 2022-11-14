package modelo;

import org.junit.jupiter.api.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class MozoTest {
    Empresa empresa;
    Mozo mozo1;
    Mozo mozo2;

    @Nested
    @DisplayName("AGREGAR UN NUEVO MOZO AL SISTEMA")
    class mozoTest {

        @BeforeEach
        void setUp() {
            TreeSet<Mozo> mozos = new TreeSet<>();
            mozo1 = new Mozo("Matias", new GregorianCalendar(2000,12,12),0,1);
            mozo2 = new Mozo("Tomas", new GregorianCalendar(2000,12,12),0,1);
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
        void agregarMozo4() {
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

        /**
         * metodo BAJA MOZO clase Empresa
         *
         * PRECONDICIONES
         * MOZO distinto de null
         *
         * Se da de baja un mozo presente en la coleccion de mozos
         */
        @Test
        void bajaMozo1() {
            empresa.getMozos().add(mozo1);
            try {
                empresa.bajaMozo(mozo1);
                assertTrue(empresa.getMozos().size()==0,"ERROR AL BORRAR UNA MESA EXISTENTE");
            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }
        }

        /**
         * Se da de baja una mesa NO presente en la coleccion de mesas
         */
        @Test
        void bajaMozo2() {

            empresa.getMozos().add(mozo1);
            try {
                empresa.bajaMozo(mozo2);
                fail("DEBERIA LANZAR EXCEPCION");

            } catch (Exception e) {
                final String msg = "No existe mozo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere dar de baja una mesa. COLECCION DE MESAS VACIA
         */
        @Test
        void bajaMesa3() {
            try {
                empresa.bajaMozo(mozo1);
                fail("DEBERIA LANZAR EXCEPCION");

            } catch (Exception e) {
                final String msg = "No existe mozo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * metodo MODIFICAR MOZO clase Empresa
         * <p>
         * PRECONDICIONES
         * nombreYApellido distinto de vacio y null
         * fecha de Nacimiento distinto de null
         * Estado solo validos ( 1, 2, 3 )
         * <p>
         * <p>
         * Se quiere modificar un mozo correcto
         */
        @Test
        void modificaMozo1() {
            mozo1 = new Mozo("Lautaro",new GregorianCalendar(1990,11,11),1,1);
            empresa.getMozos().add(mozo1);
            String nombreNuevo = "Matias Angelico";
            Calendar fechaNacNueva = new GregorianCalendar(1996,12,12);
            int hijosNuevo = 0;
            int estadoNuevo = 0;
            try {
                empresa.modificaMozo(mozo1,nombreNuevo,fechaNacNueva,hijosNuevo,estadoNuevo);
                assertTrue(mozo1.getEstado()==estadoNuevo && mozo1.getNombreYApellido().equalsIgnoreCase(nombreNuevo)&& mozo1.getFechaNacimiento()==fechaNacNueva&&mozo1.getCantHijos()==estadoNuevo,"ERROR AL MODIFICAR MOZO VALIDO");
            } catch (Exception e) {
                fail("NO DEBERIA LANZAR EXCEPCION");
            }

        }

        /**
         * Se quiere agregar un mozo con cantidad de hijos menor a cero
         */
        @Test
        void modificarMozo2() {
            mozo1 = new Mozo("Lautaro",new GregorianCalendar(1990,11,11),1,1);
            empresa.getMozos().add(mozo1);
            String nombreNuevo = "Matias Angelico";
            Calendar fechaNacNueva = new GregorianCalendar(1996,12,12);
            int hijosNuevo = -1;
            int estadoNuevo = 0;
            try {
                empresa.modificaMozo(mozo1,nombreNuevo,fechaNacNueva,hijosNuevo,estadoNuevo);
                fail("MODIFICAR UN MOZO CON CANTIDAD DE HIJOS MENOR A CERO NO LANZA EXCEPCION");
            } catch (Exception e) {
                final String msg = "Cant de hijos menor a cero";
                assertEquals(msg, e.getMessage());
            }

        }

        /**
         * Se quiere modificar un mozo con estado Invalido ( int > 3 )
         */
        @Test
        void modificarMozo3() {
            mozo1 = new Mozo("Lautaro",new GregorianCalendar(1990,11,11),1,1);
            empresa.getMozos().add(mozo1);
            String nombreNuevo = "Matias Angelico";
            Calendar fechaNacNueva = new GregorianCalendar(1996,12,12);
            int hijosNuevo = 0;
            int estadoNuevo = 4;
            try {
                empresa.modificaMozo(mozo1,nombreNuevo,fechaNacNueva,hijosNuevo,estadoNuevo);
                fail("AGREGAR UN MOZO CON ESTADO INVALIDO NO LANZA EXCEPCION");
            } catch (Exception e) {
                final String msg = "Estado Invalido";
                assertEquals(msg, e.getMessage());
            }

        }

        /**
         * se quiere modificar un mozo menor de edad
         */
        @Test
        void modificarMozo4() {
            mozo1 = new Mozo("Lautaro",new GregorianCalendar(1990,11,11),1,1);
            empresa.getMozos().add(mozo1);
            String nombreNuevo = "Matias Angelico";
            Calendar fechaNacNueva = new GregorianCalendar(2014,12,12);
            int hijosNuevo = 0;
            int estadoNuevo = 0;
            try {
                empresa.modificaMozo(mozo1,nombreNuevo,fechaNacNueva,hijosNuevo,estadoNuevo);
                fail("AGREGAR UN MOZO MENOR DE EDAD NO LANZA EXCEPCION");
            } catch (Exception e) {
                final String msg = "Edad menor a 18 anos";
                assertEquals(msg, e.getMessage());
            }
        }

    }
}