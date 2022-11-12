package modelo;

import org.junit.jupiter.api.*;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("La empresa ")
class EmpresaTest {
    Empresa empresa;

    @BeforeEach
    void setUp() {
        Empresa emprese = new Empresa();


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
            TreeSet<Producto> productos= new TreeSet<>();

            empresa = new Empresa("Cerveceria", null, null, productos, operarios);

//            try {
//                empresa.signup("Messi", "Messi10", "Messi123", true);
//            } catch (Exception e) {
//                fail("ERROR");
//            }
        }

        @Test
        @DisplayName(" lanza excepcion con contrasena NULL")
        void signUpTest1() {
            String apellido = "Messi";
            String username = "Messi10";
            String passwordIncorrecta = null;


            assertThrows(Exception.class, () -> empresa.signup(apellido, username, passwordIncorrecta, true));
        }

        @Test
        @DisplayName(" ")
        void signUpTest2() {
        }

        @Test
        @DisplayName()
        void signUpTest3() {
        }

        @Test
        @DisplayName()
        void signUpTest4() {
        }

        @Nested
        @DisplayName("Un operario que intenta loguearse")
        class LoginTests {

            @BeforeEach
            void setUp() {

            }

            @Test
            @DisplayName(" lanza excepcion si el nombre de usuario no existe en el sistema")
            void loginTest1() {
                String usernameInvalido = "Maradona";
                String password = "Maradona123";

                assertThrows(Exception.class, () -> empresa.login(usernameInvalido, password));
            }

            @Test
            @DisplayName(" lanza excepcion si la contrasena no coincide")
            void loginTest2() {
                String username = "Messi10";
                String passwordInvalida = "NoFueCampeon123";

                assertThrows(Exception.class, () -> empresa.login(username, passwordInvalida));
            }

            @Test
            @DisplayName(" retorna NULL si no esta registrado en el sistema")
            void loginTest3() {
                String username = "Diego86";
                String password = "FuaElDiego10";

                assertThrows(Exception.class, () -> assertEquals(null, empresa.login(username, password)));
            }

            @Test
            @DisplayName(" correctamente retorna una instancia del Operario")
            void loginTest4() {
                String username = "Messi10";
                String password= "Messi123";

                Operario respuestaEsperada = empresa.getOperarios().first();

                try {
                    assertEquals(respuestaEsperada, empresa.login(username, password));
                } catch (Exception e) {
                    fail("Esta prueba no deberia largar excepcion");
                }
            }
        }

    }



//    @Test
//    @DisplayName()
//    void loginTest1() {
//
//    }
//
//    @Test
//    @DisplayName()
//    void loginTest1() {
//
//    }
//
//    @Test
//    void signup() {
//
//    }
//
//    @Test
//    void modificarPassword() {
//
//    }
//
//    @Test
//    void altaProducto() {
//
//    }
}