package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("La empresa ")
class ProductoTest {
    Empresa empresa;

    @Test
    @DisplayName("es inicializada")
    public void testConstructor() {
        new Empresa();
    }

    @Nested
    @DisplayName("Un operario que intenta registrarse en el sistema ")
    class productoTest {

        @BeforeEach
        void setUp() {
            TreeSet<Producto> productos= new TreeSet<>();

            empresa = new Empresa("Cerveceria", null, null, productos, null);

            try {
                empresa.signup("Messi", "Messi10", "Messi123", true);
            } catch (Exception e) {
                fail("ERROR registrando");
            }
        }

        @Test
        @DisplayName("")
        void name() {
        }
    }
}