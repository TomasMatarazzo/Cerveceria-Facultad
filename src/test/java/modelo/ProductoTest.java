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
    @DisplayName("Un producto ")
    class productoTest {

        @BeforeEach
        void setUp() {
            TreeSet<Producto> productos= new TreeSet<>();

            empresa = new Empresa("Cerveceria", null, null, productos, null);
        }

        @Test
        @DisplayName("es eliminado de un arbol vacio")
        void productoTest1() {
            try {
                Producto producto = new Producto("Prueba", 100, 150, 100);

                empresa.bajaProducto(producto);
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }
    }
}