package modelo;


import excepciones.MozoIncorrecto;
import excepciones.StockNoDisponible;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa implements Serializable {
    private String nombreEmpresa;
    private double sueldoBasico;
    private TreeSet<Mozo> mozos = new TreeSet<>();
    private TreeSet<Mesa> mesas = new TreeSet<>();;
    private TreeSet<Producto> productos= new TreeSet<>();
    private ArrayList<Comanda> comandas=new ArrayList<>();
    private TreeSet<Operario> operarios= new TreeSet<>();
    private ArrayList<ProductoEnPromocion> promocionesProductos;
    private ArrayList<PromocionTemporal> promocionesTemporales;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private boolean arrancoJornada;

    public Empresa(String nombreEmpresa, TreeSet<Mozo> mozos, TreeSet<Mesa> mesas,TreeSet<Producto> productos, TreeSet<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
        this.arrancoJornada = false;
    }

    // --------- OPERARIOS ----------
    public Operario login( String usuario, String password) throws Exception{
        for (Operario op:operarios ){
            System.out.printf("hola");
            System.out.printf(op.getUsuario() + op.getPassword());
            if ( op.getUsuario().equals(usuario) && op.getPassword().equals(password) ){
                System.out.printf("hola1");
                if (op.isActivo())
                    System.out.printf("hola3");
                    return op;
            }
            else{
                throw new Exception();
            }
        }
        return null;
    }

    public void signup( String apellido, String usuario, String password, boolean activo) throws Exception{
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
        if (password == null) {
            throw new Exception();
        }

        Matcher m = p.matcher(password);
        System.out.printf("\nholaa2");

        if (true) {
            System.out.printf("\nholaa4");
            Operario operario = new Operario(apellido, usuario, password, activo);
            this.operarios.add(operario);
        }

        else {
            System.out.printf("\n"+ apellido.length());
            System.out.printf("\n"+ usuario.length());
            throw new Exception();
        }
    }

    public void modificarPassword( Operario op,String password) throws Exception {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
        if (password == null) {
            throw new Exception();
        }

        Matcher m = p.matcher(password);

        if (true) {
            op.setPassword(password);
        } else {
            throw new Exception();
        }
    }

    // --------- MOZOS ----------
    /**
     * Este metodo permite agregar un nuevo mozo
     * <pre> la edad ingresada sera mayor o igual a 18
     * <pre> la cantidad de hijos debera ser mayor o igual a cero
     * @param nombreYApellido nombre y apellido del mozo a registrar, distinto de vacio
     * @param fechaNacimiento fecha de nacimiento del mozo, no puede ser null
     * @param cantHijos cantidad de hijos del mozo a registrar
     * @param estado estado del mozo, entero que toma los valores 1,2 y 3 representan activo, de franco y ausente respectivamente
     * @throws MozoIncorrecto se lanza en caso de ingresar cantidad de hijos menor a cero o una edad menor a 18 anios
     */
    public void agregaMozo(String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto {
        // VERIFICAR LA EDAD
        Calendar fecha = new GregorianCalendar();
        fecha.add(Calendar.YEAR, -18);
        if(fecha.after(fechaNacimiento)){
            if( cantHijos >= 0 ){
                this.mozos.add(new Mozo(nombreYApellido,fechaNacimiento,cantHijos,estado));
            }
            else{
                throw new MozoIncorrecto("Cant de hijos menor a cero");
            }
        }
        else{
            throw new MozoIncorrecto("Edad menor a 18 anos");
        }
    }

    /**
     * Este metodo permite modificar la informacion de un mozo existente
     * <pre> la edad ingresada sera mayor o igual a 18
     * <pre> la cantidad de hijos debera ser mayor o igual a cero
     * @param mozo mozo a modificar, distinto de null
     * @param nombreYApellido nuevo nombre y apellido, distinto de null
     * @param fechaNacimiento fecha de nacimiento del mozo, no puede ser null
     * @param cantHijos cantidad de hijos del mozo a registrar
     * @param estado estado del mozo, entero que toma los valores 1,2 y 3 representan activo, de franco y ausente respectivamente
     */
    public void modificaMozo(Mozo mozo,String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto{
        Calendar fecha = new GregorianCalendar();
        fecha.add(Calendar.YEAR, -18);
        if(fecha.after(fechaNacimiento)){
            if( cantHijos >= 0 ){
                mozo.setNombreYApellido(nombreYApellido);
                mozo.setFechaNacimiento(fechaNacimiento);
                mozo.setCantHijos(cantHijos);
                mozo.setEstado(estado);
            }
            else{
                throw new MozoIncorrecto("Cant de hijos menor a cero");
            }
        }
        else{
            throw new MozoIncorrecto("Edad menor a 18 anos");
        }
    }

    /**
     * @param mozo debera ser distinto de null
     */
    public void bajaMozo(Mozo mozo){
        this.mozos.remove(mozo);
    }

    // --------- PRODUCTOS ------------
    /**
     * Permite agregar un nuevo producto a nuestro inventario
     * @param nombre nombre del producto, no podra estar vacio
     * @param precioCosto flotante menor a cero
     * @param precioVenta
     * @param stockInicial
     */
    public void altaProducto( String nombre, double precioCosto, double precioVenta, int stockInicial){
        try{
            Producto prod = new Producto(nombre,precioCosto,precioVenta,stockInicial);
            System.out.printf("EL PRODUCTO ES");
            System.out.printf(prod.toString());
            this.productos.add(prod);
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

    /**
     * Permite dar de baja un producto que no esta asociado a una comanda
     * @param producto el producto a eliminar debe ser distinto de null y no puede estar asociado a una comanda
     */
    public void bajaProducto( Producto producto){
        try{
            System.out.printf("el producto es\n" );
            System.out.printf(producto.toString());
            System.out.printf("\n" + this.productos.toString());
            this.productos.remove(producto);
            System.out.printf("\n " + this.productos.toString());
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

    /**
     * Permite modificar la informacion de un producto
     * @param nombre el nombre del producto no puede estar vacio
     * @param precioCosto flotante mayor a cero y menor o igual que el precio de venta
     * @param precioVenta flotante mayor a cero y mayor o igual que el precio de costo
     * @param stockInicial entero mayor o igual a cero
     * @param producto producto a modificar, debera ser distinto de null
     */
    public void modificaProducto(String nombre, double precioCosto, double precioVenta, int stockInicial, Producto producto){
        try{
            producto.setNombre(nombre);
            producto.setPrecioCosto(precioCosto);
            producto.setPrecioVenta(precioVenta);
            producto.setStockInicial(stockInicial);
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

    // -------- MESAS ----------
    /**
     * Permite dar de alta una nueva mesa
     * @param cantidadPersonas entero mayor a cero, en caso de ser una sola persona va a la barra, mesa numero cero
     * @throws Exception si el numero de personas es incorrecto, menor a 1
     */
    public void altaMesa(int cantidadPersonas) throws Exception{
        if (cantidadPersonas >= 2 ){
            Mesa mesa = new Mesa(cantidadPersonas);
            this.mesas.add(mesa);
        }
        else if (cantidadPersonas<1){
            throw new Exception();
        }
    }

    /**
     * Permite dar de baja una mesa registrada en el sistema
     * @param mesa la mesa a eliminar debera ser distinto de null
     */
    public void bajaMesa(Mesa mesa){
        try{
            this.mesas.remove(mesa);
        }
        catch(Exception exception){
            System.out.printf(exception.getMessage());
        }
    }

    /**
     * Permite modificar una mesa
     * @param cantidadPersonas debera ser entero mayor a cero
     * @param estado string que toma solo valores libre u ocupada
     * @param mesa debera ser distinto de null
     */
    public void modificaMesa(int cantidadPersonas, String estado, Mesa mesa){
        try{
            mesa.setEstado(estado);
            mesa.setCantidadPersonas(cantidadPersonas);
        }catch(Exception e){
            System.out.printf(e.getMessage());
        }

    }

    /**
     * Crea un nuevo pedido
     * @param producto el producto solicitado debera ser distinto de null
     * @param cantidad debera ser mayor a cero
     * @return devuelve el nuevo pedido creado
     */
    public Pedido realizarPedido(Producto producto, int cantidad){
        Pedido pedido=null;
        try {
            pedido=new Pedido(producto,cantidad);
        } catch (StockNoDisponible e) {
            e.printStackTrace();
        }

        return pedido;
    }
    // ------- PEDIDOS ---------

    /**
     * Da de alta un nuevo pedido
     * @param pedido debe ser distinto de null
     */
    public void altaPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    // ------- COMANDAS ---------
    /**
     * El metodo permite dar de alta una comanda
     * @param mesa
     * @param pedido
     * @param mozo
     * @throws Exception si el estado es incorrecto
     */
    public void altaComanda( Mesa mesa, Mozo mozo, Pedido pedido) throws Exception {

        boolean libre = false;
        if (mesa.getEstado().equalsIgnoreCase("libre") ){
            mesa.setEstado("ocupada");
            mesa.setMozo(mozo);
            Comanda comanda = new Comanda(mesa,mozo);
            comanda.agregarPedido(pedido);
            this.comandas.add(comanda);
        }
    }

    public void agregarPedidoAComanda( Pedido ped , Comanda comanda){
        for (Comanda com:this.comandas) {
            if (comanda.equals(com))
                com.agregarPedido(ped);
        }
    }

    public double generarFactura( Comanda comanda) throws Exception {
        for (Comanda com:this.comandas) {
            if (comanda.equals(com)) {
                comanda.getMesa().setEstado("libre");
                Factura factura = new Factura(new Date() ,comanda.getMesa(),comanda.getPedidos(),"Efectivo",null,null);

                return factura.getTotal();
            }
        }
        return 0;
    }

    // ----- GET Y SET ----
    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public ArrayList<ProductoEnPromocion> getPromocionesProductos() {
        return promocionesProductos;
    }

    public void setPromocionesProductos(ArrayList<ProductoEnPromocion> promocionesProductos) {
        this.promocionesProductos = promocionesProductos;
    }

    public ArrayList<PromocionTemporal> getPromocionesTemporales() {
        return promocionesTemporales;
    }

    public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
        this.promocionesTemporales = promocionesTemporales;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public TreeSet<Mozo> getMozos() {
        return mozos;
    }

    public void setMozos(TreeSet<Mozo> mozos) {
        this.mozos = mozos;
    }

    /**
     * El metodo permite crear una factura para cerrar la mesa, se actualizan valores para el calculo de estadisticas y se elimina la comanda
     * @param mesa debera ser distinta de nula
     * @param formaDePago debera tomar uno de los siguientes valores efectivo - tarjeta - mercPago - ctaDNI
     */
    public void crearFactura(Mesa mesa,String formaDePago){
        Comanda comanda = null;
        for (int i = 0; i < this.comandas.size(); i++){
            if(this.comandas.get(i).getMesa()==mesa){
                comanda=this.comandas.get(i);
            }
        }
        assert comanda != null;
        Factura factura=new Factura(Date.from(Instant.now()),mesa,comanda.getPedidos(),formaDePago, this.promocionesProductos, this.promocionesTemporales);

        //para estadisticas
        mesa.getMozo().setVentas(mesa.getMozo().getVentas()+ factura.getTotal());
        mesa.setCantComandas(mesa.getCantComandas()+1);
        mesa.setTotalComandas(mesa.getTotalComandas()+ factura.getTotal());

        this.comandas.remove(comanda);
    }

    /**
     * Permite calcular el sueldo de cada mozo, a partir del sueldo base y un extra por cada hijo
     * @param mozo debera ser distinto de nulo
     * @return un flotante con el sueldo correspondiente a dicho mozo
     */
    public double calculaSueldo(Mozo mozo){
        return this.getSueldoBasico()*(1+0.05* mozo.getCantHijos());
    }

    //agregar factura al mozo

    public TreeSet<Mesa> getMesas() {
        return this.mesas;
    }

    public void setMesas(TreeSet<Mesa> mesas) {
        this.mesas = mesas;
    }

    public TreeSet<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(TreeSet<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Comanda> getComandas() {
        return this.comandas;
    }

    public void setComandas(ArrayList<Comanda> comandas) {
        this.comandas = comandas;
    }

    public TreeSet<Operario> getOperarios() {
        return this.operarios;
    }

    public void setOperarios(TreeSet<Operario> operarios) {
        this.operarios = operarios;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}



