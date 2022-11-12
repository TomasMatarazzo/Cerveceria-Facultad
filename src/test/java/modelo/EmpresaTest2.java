package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import

class EmpresaTest {

    Empresa empresa

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    /**
     * metodo AGREGAR MOZO clase Empresa
     *
     * PRECONDICIONES
     * nombreYApellido distinto de vacio y null
     * fecha de Nacimiento distinto de null
     * Estado solo validos ( 1, 2, 3 )
     *
     *
     * Se quiere agregar un mozo correcto
     */
    @Test
    void agregarMozo1() {
    }

    /**
     * Se quiere agregar un mozo con cantidad de hijos menor a cero
     */
    @Test
    void agregarMozo2() {
    }

    /**
     * Se quiere agregar un mozo con estado Invalido ( int > 3 )
     */
    @Test
    void agregarMozo3() {
    }

    /**
     * Se quiere agregar un mozo con una fecha invalida
     */
    @Test
    void agregarMozo4() {
    }

    /**
     * se quiere agregar un mozo menor de edad
     */
    @Test
    void agregarMozo5() {
    }

    /**
     * metodo BAJA MESA clase Empresa
     *
     * PRECONDICIONES
     * Mesa distinto de null
     *
     * Se da de baja una mesa presente en la coleccion de mesas
     */
    @Test
    void bajaMesa1() {
    }

    /**
     * Se da de baja una mesa NO presente en la coleccion de mesas
     */
    @Test
    void bajaMesa2() {
    }

    /**
     * Se quiere dar de baja una mesa. COLECCION DE MESAS VACIA
     */
    @Test
    void bajaMesa3() {
    }

    /**
     * metodo REALIZAR PEDIDO  clase Empresa
     *
     * PRECONDICIONES
     * producto distinto de null
     * cantidad mayor a cero
     *
     * Se quiere realizar un pedido valido
     */
    @Test
    void realizarPedido1() {
    }

     /**
      * Se quiere realizar un pedido con una cantidad mayor al stock disponible
     */
    @Test
    void realizarPedido2() {
    }

    /**
     * metodo AlTA COMANDA  clase Empresa
     *
     * PRECONDICIONES
     * pedido distinto de vacio y null
     * mozo distinto vacio y null
     * mesa distinto vacio y null
     *
     * Se quiere agregar una comanda valida valido
     */
    @Test
    void altaComanda1() {
    }

    /**
     * Se quiere realizar una comanda sobre una mesa ocupada
     */
    @Test
    void altaComanda2() {
    }


    /**
     * metodo CREAR FACTURA clase Empresa
     *
     * PRECONDICIONES
     * mozo distinto vacio y null
     * Forma de Pago datos validos
     *
     * Se quiere crear una factura valida
     */
    @Test
    void crearFactura1() {
    }

    /**
     * Se quiere crear una factura con una mesa Libre
     */
    @Test
    void crearFactura2() {
    }


}