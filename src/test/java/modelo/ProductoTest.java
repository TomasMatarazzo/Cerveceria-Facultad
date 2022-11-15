package modelo;

import org.junit.jupiter.api.*;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("La empresa ")
class ProductoTest {
    Empresa empresa;
    Producto producto;

    @Nested
    @DisplayName("test producto  conjunto vacio")
    class productoConjuntoVacioTest {

        @BeforeEach
        void setUp() throws Exception {
            TreeSet<Producto> productos= new TreeSet<>();
            producto = new Producto("Coca",100,200,20);
            empresa = new Empresa("Cerveceria", null, null, productos, null);
        }

        @AfterEach
        void tearDown() {
            empresa.getProductos().clear();
        }

        /**
         * Se quiere crear un nuevo producto VALIDO
         */
        @Test
        void altaProductoTest1() {
            String nombre = "Sprite";
            double precioCosto = 100,precioVenta= 200;
            int stock = 10;
            try {
                empresa.altaProducto(nombre,precioCosto,precioVenta,stock);
                assertTrue(empresa.getProductos().size()==1, "ERROR AL AGREGAR UN PRODUCTO");
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }
        /**
         * Se quiere crear un nuevo producto con precio de consto = 0
         */
        @Test
        void agregaProductoTest2() {
            String nombre = "Sprite";
            double precioCosto = 0,precioVenta= 200;
            int stock = 10;
            try {
                empresa.altaProducto(nombre,precioCosto,precioVenta,stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de costo es menor o igual a 0";
                assertEquals(msg, e.getMessage());
            }
        }


        /**
         * Se quiere crear un nuevo producto con precio de VENTA = 0
         */
        @Test
        void agregaProductoTest3() {
            String nombre = "Sprite";
            double precioCosto = 100,precioVenta= 0;
            int stock = 10;
            try {
                empresa.altaProducto(nombre,precioCosto,precioVenta,stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere crear un nuevo producto con precio de venta < precio costo
         */
        @Test
        void agregaProductoTest4() {
            String nombre = "Sprite";
            double precioCosto = 100,precioVenta= 50;
            int stock = 10;
            try {
                empresa.altaProducto(nombre,precioCosto,precioVenta,stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere crear un nuevo producto con stock negativo
         */
        @Test
        void agregaProductoTest5() {
            String nombre = "Sprite";
            double precioCosto = 100,precioVenta= 150;
            int stock = -1;
            try {
                empresa.altaProducto(nombre,precioCosto,precioVenta,stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "Stock menor a cero";
                assertEquals(msg, e.getMessage());
            }
        }
    }

    @Nested
    @DisplayName("test producto  conjunto vacio")
    class productoConjuntoLLenoTest {

        @BeforeEach
        void setUp() throws Exception {
            TreeSet<Producto> productos = new TreeSet<>();
            producto = new Producto("Coca", 100, 200, 20);
            productos.add(producto);
            empresa = new Empresa("Cerveceria", null, null, productos, null);
        }


        @AfterEach
        void tearDown() {
            empresa.getProductos().clear();
        }


        /**
         * Se quiere crear un nuevo producto VALIDO
         */
        @Test
        void altaProductoTest1() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 200;
            int stock = 10;
            try {
                empresa.altaProducto(nombre, precioCosto, precioVenta, stock);
                assertTrue(empresa.getProductos().size() == 2, "ERROR AL AGREGAR UN PRODUCTO");
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }

        /**
         * Se quiere crear un nuevo producto con precio de consto = 0
         */
        @Test
        void agregaProductoTest2() {
            String nombre = "Sprite";
            double precioCosto = 0, precioVenta = 200;
            int stock = 10;
            try {
                empresa.altaProducto(nombre, precioCosto, precioVenta, stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de costo es menor o igual a 0";
                assertEquals(msg, e.getMessage());
            }
        }


        /**
         * Se quiere crear un nuevo producto con precio de VENTA = 0
         */
        @Test
        void agregaProductoTest3() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 0;
            int stock = 10;
            try {
                empresa.altaProducto(nombre, precioCosto, precioVenta, stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere crear un nuevo producto con precio de venta < precio costo
         */
        @Test
        void agregaProductoTest4() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 50;
            int stock = 10;
            try {
                empresa.altaProducto(nombre, precioCosto, precioVenta, stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere crear un nuevo producto con stock negativo
         */
        @Test
        void agregaProductoTest5() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 150;
            int stock = -1;
            try {
                empresa.altaProducto(nombre, precioCosto, precioVenta, stock);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "Stock menor a cero";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere Eliminar producto
         */
        @Test
        void eliminaProductoTest1() {
            try {
                empresa.bajaProducto(producto);
                assertTrue(empresa.getProductos().size() == 0, "ERROR AL ELIMINAR UN PRODUCTO");
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }

        /**
         * Se quiere modificar producto VALIDO
         */
        @Test
        void modificarProductoTest1() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 200;
            int stock = 10;
            try {
                empresa.modificaProducto(nombre, precioCosto, precioVenta, stock,producto);
                assertTrue(empresa.getProductos().first().getNombre().equalsIgnoreCase(nombre), "ERROR AL MODIFICAR UN PRODUCTO");
                assertTrue(empresa.getProductos().first().getStockInicial()==stock, "ERROR AL MODIFICAR UN PRODUCTO");
                assertTrue(empresa.getProductos().first().getPrecioVenta()==precioVenta, "ERROR AL MODIFICAR UN PRODUCTO");
                assertTrue(empresa.getProductos().first().getPrecioCosto()==precioCosto, "ERROR AL MODIFICAR UN PRODUCTO");
            } catch (Exception e) {
                fail("Esta prueba no deberia disparar una excepcion");
            }
        }
        /**
         * Se quiere crear un nuevo producto con precio de consto = 0
         */
        @Test
        void modificarProductoTest2() {
            String nombre = "Sprite";
            double precioCosto = 0, precioVenta = 200;
            int stock = 10;
            try {
                empresa.modificaProducto(nombre, precioCosto, precioVenta, stock,producto);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de costo es menor o igual a 0";
                assertEquals(msg, e.getMessage());
            }
        }


        /**
         * Se quiere crear un nuevo producto con precio de VENTA = 0
         */
        @Test
        void modificarProductoTest3() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 0;
            int stock = 10;
            try {
                empresa.modificaProducto(nombre, precioCosto, precioVenta, stock,producto);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere crear un nuevo producto con precio de venta < precio costo
         */
        @Test
        void modificarProductoTest4() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 50;
            int stock = 10;
            try {
                empresa.modificaProducto(nombre, precioCosto, precioVenta, stock,producto);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }

        /**
         * Se quiere crear un nuevo producto con stock negativo
         */
        @Test
        void modificarProductoTest5() {
            String nombre = "Sprite";
            double precioCosto = 100, precioVenta = 50;
            int stock = -1;
            try {
                empresa.modificaProducto(nombre, precioCosto, precioVenta, stock,producto);
                fail("DEBERIA LANZAR EXCEPCION");
            } catch (Exception e) {
                final String msg = "El precio de venta es menor o igual a 0 o menor al precio de costo";
                assertEquals(msg, e.getMessage());
            }
        }
    }
}