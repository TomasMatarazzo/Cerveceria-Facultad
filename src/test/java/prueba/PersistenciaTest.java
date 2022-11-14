package prueba;

import modelo.*;
import org.junit.jupiter.api.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("La empresa")
class PersistenciaTest {
    Empresa empresa;

    @Test
    @DisplayName("es inicializada")
    public void testConstructor() {
        new Empresa();
    }

    @Nested
    @DisplayName("Si no existe el archivo binario")
    class archivoNullTest {

        @BeforeEach
        void setUp() {
            empresa = new Empresa("Cerveceria", null, null, null, null);
            File archivo = new File("Cerveceria.bin");
            if (archivo.exists()) {
                archivo.delete();
            }
        }

        @Test
        @DisplayName("La clase persistir crea un archivo")
        void persistenciaTest1() {
            try {
                IPersistencia persistencia = new PersistenciaBIN();
                persistencia.abrirOutput("Cerveceria.bin");
                persistencia.cerrarOutput();

                File archivo = new File("Cerveceria.bin");

                assertEquals(true, archivo.exists());
            } catch (IOException e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }

        @Test
        @DisplayName("La clase persistir lanza excepcion si se intenta escribir el archivo inexistente")
        void persistenciaTest2() {
            IPersistencia persistencia = new PersistenciaBIN();


            assertThrows(IOException.class, () -> persistencia.abrirOutput("Cerveceria.bin"));
            assertThrows(IOException.class, () -> persistencia.escribir(empresa));
        }

        @Test
        @DisplayName("La clase persistir lanza excepcion si se intenta escribir el archivo inexistente")
        void persistenciaTest3() {
            IPersistencia persistencia = new PersistenciaBIN();

            assertThrows(IOException.class, () -> persistencia.abrirInput("Cerveceria.bin"));
            assertThrows(IOException.class, () -> persistencia.leer());
        }
    }

    @Nested
    @DisplayName("El archivo binario existe")
    class archivoTest {

        @Nested
        @DisplayName("y la empresa esta vacia")
        class empresaEmptyTest {

            @BeforeEach
            void setUp() {
                empresa = new Empresa("Cerveceria", null, null, null, null);
            }

            @AfterEach
            void tearDown() {
                File archivo = new File("Cerveceria.bin");
                if (archivo.exists()) {
                    archivo.delete();
                }
            }

            @Test
            @DisplayName("La clase persistir lee y escribe la empresa vacia")
            void persistenciaTest4() {
                PersistenciaBIN persistencia = new PersistenciaBIN();
                try {
                    persistencia.abrirOutput("Cerveceria.bin");
                    persistencia.escribir(empresa);
                    persistencia.cerrarOutput();
                    persistencia.abrirInput("Cerveceria.bin");
                    Empresa empresa2 = (Empresa) persistencia.leer();
                    persistencia.cerrarInput();

                    assertEquals(empresa, empresa2);
                } catch (IOException e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                } catch (ClassNotFoundException e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }
        }

        @Nested
        @DisplayName("y la empresa esta tiene datos dentro")
        class EmpresaFullTest {

            @BeforeEach
            void setUp() {
                TreeSet<Operario> operarios = new TreeSet<>();
                TreeSet<Mozo> mozos = new TreeSet<>();
                TreeSet<Producto> productos = new TreeSet<>();
                TreeSet<Mesa> mesas = new TreeSet<>();

                try {
                    operarios.add(new Operario("prueba", "prueba", "prueba", true));
                    mozos.add(new Mozo("prueba", null, 1, 0));
                    productos.add(new Producto("prueba", 100, 999, 999));
                    mesas.add(new Mesa(9));

                    empresa = new Empresa("Cerveceria", mozos, mesas, productos, operarios);
                } catch (Exception e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }

            @Test
            @DisplayName("La clase persistir lee y escribe la empresa llena")
            void persistenciaTest5() {
                PersistenciaBIN persistencia = new PersistenciaBIN();
                try {
                    persistencia.abrirOutput("Cerveceria.bin");
                    persistencia.escribir(empresa);
                    persistencia.cerrarOutput();
                    persistencia.abrirInput("Cerveceria.bin");
                    Empresa empresa2 = (Empresa) persistencia.leer();
                    persistencia.cerrarInput();

                    assertEquals(empresa, empresa2);
                } catch (IOException e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                } catch (ClassNotFoundException e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }
        }
    }
}