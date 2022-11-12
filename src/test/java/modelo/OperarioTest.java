package modelo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("La empresa ")
class OperarioTest {
    Empresa empresa;

    @Test
    @DisplayName("es inicializada")
    public void testConstructor() {
        new Empresa();
    }

    @Nested
    @DisplayName("Un operario que intenta registrarse en el sistema ")
    class operarioTests {

        @BeforeEach
        void setUp() {
            TreeSet<Operario> operarios= new TreeSet<>();

            empresa = new Empresa("Cerveceria", null, null, null, operarios);
        }

        @Test
        @DisplayName(" lanza excepcion con contrasena incorrecta")
        void signUpTest1() {
            String apellido = "Messi";
            String username = "Messi10";

            assertAll(
                    () -> assertThrows(Exception.class, () -> empresa.signup(apellido, username, null, true)),
                    () -> assertThrows(Exception.class, () -> empresa.signup(apellido, username, "", true))
            );
        }

        @Test
        @DisplayName(" lanza excepcion con username incorrecto")
        void signUpTest2() {
            String apellido = "Messi";
            String password = "Messi1234";

            assertAll(
                    () -> assertThrows(Exception.class, () -> empresa.signup(apellido, null, password, true)),
                    () -> assertThrows(Exception.class, () -> empresa.signup(apellido, "", password, true))
            );
        }

        @Test
        @DisplayName(" es anadido al sistema")
        void signUpTest3() {
            String apellido = "Messi";
            String username = "Messi10";
            String password = "Messi#123";

            try {
                empresa.signup(apellido, username, password, true);
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }

            assertEquals(1, empresa.getOperarios().size(), "Error al agregar un operario");
        }

        @Nested
        @DisplayName("El operario que intenta loguearse en el sistema ")
        class LoginTests {

            @BeforeEach
            void setUp() {
                String apellido = "Inactivo";
                String username = "Inactivo11";
                String password = "Inactivo#123";

                try {
                    empresa.signup(apellido, username, password, false);
                } catch (Exception e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }

            @AfterEach
            void tearDown() {
                empresa.getOperarios().clear();
            }

            @Test
            @DisplayName(" lanza excepcion si el nombre de usuario no existe en el sistema")
            void loginTest1() {
                String usernameInvalido = "Maradona";
                String password = "ElDiego%23";

                assertThrows(Exception.class, () -> empresa.login(usernameInvalido, password));
            }

            @Test
            @DisplayName(" lanza excepcion si la contrasena no coincide")
            void loginTest2() {
                String username = "Messi10";
                String passwordInvalida = "xxxxx#123";

                assertThrows(Exception.class, () -> empresa.login(username, passwordInvalida));
            }

            @Test
            @DisplayName(" retorna NULL si no esta registrado en el sistema")
            void loginTest3() {
                String username = "Diego86";
                String password = "FuaElDiego10";

                try {
                    assertNull(empresa.login(username, password));
                } catch (Exception e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }

            @Test
            @DisplayName(" lanza excepcion porque no se encuentra activo")
            void loginTest4() {
                String username = "Inactivo";
                String password= "Inactivo11";

                Operario respuestaEsperada = empresa.getOperarios().last();

                try {
                    assertEquals(respuestaEsperada, empresa.login(username, password));
                } catch (Exception e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }

            @Test
            @DisplayName(" correctamente retorna una instancia del Operario")
            void loginTest5() {
                String username = "Messi10";
                String password= "Messi#123";

                Operario respuestaEsperada = empresa.getOperarios().first();

                try {
                    assertEquals(respuestaEsperada, empresa.login(username, password));
                } catch (Exception e) {
                    fail("Esta prueba no deberia disparar una excepcion");
                }
            }
        }
    }

    @DisplayName("El administrador que intenta ")
    class administradorTest {

    }
}