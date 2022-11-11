package modelo;


import excepciones.MozoIncorrecto;
import excepciones.StockNoDisponible;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa {
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

    public Empresa(){}

    public Empresa(String nombreEmpresa, TreeSet<Mozo> mozos, TreeSet<Mesa> mesas,TreeSet<Producto> productos, TreeSet<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
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

    /*public void Logout{

    }*/

    
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
        }
        else {
            throw new Exception();
        }
    }

    // --------- MOZOS ----------


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

    public void modificaMozo(Mozo mozo,String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado){
        System.out.printf(mozo.toString());
        mozo.setNombreYApellido(nombreYApellido);
        mozo.setFechaNacimiento(fechaNacimiento);
        mozo.setCantHijos(cantHijos);
        mozo.setEstado(estado);
        System.out.printf(mozo.toString());
    }

    public void bajaMozo(Mozo mozo){
        this.mozos.remove(mozo);
    }



    // --------- PRODUCTOS ------------

    public void altaProducto(int id, String nombre, double precioCosto, double precioVenta, int stockInicial){
        try{
            Producto prod = new Producto(id,nombre,precioCosto,precioVenta,stockInicial);
            productos.add(prod);
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

    public void bajaProducto( Producto producto){
        try{
            // chequear que el producto no se encuentre asociado a una comanda
            productos.remove(producto);
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

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

    public void altaMesa(int cantidadPersonas) throws Exception{
        if (cantidadPersonas >= 2 ){
            Mesa mesa = new Mesa(cantidadPersonas);
            mesas.add(mesa);
        }
        else{
            throw new Exception();
        }
    }

    public void bajaMesa(Mesa mesa){
        try{
            mesas.remove(mesa);
        }
        catch(Exception exception){
            System.out.printf(exception.getMessage());
        }
    }

    public void modificaMesa(int cantidadPersonas, String estado, Mesa mesa){
        try{
            mesa.setEstado(estado);
            mesa.setCantidadPersonas(cantidadPersonas);
        }catch(Exception e){
            System.out.printf(e.getMessage());
        }

    }

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

    public void altaPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    // ------- COMANDAS ---------

    // asigno el mozo a la mesa
    public void altaComanda( Mesa mesa, ArrayList<Pedido> pedidos, Mozo mozo) throws Exception {

        boolean libre = false;
        if (mesa.getEstado().equalsIgnoreCase("libre") && mesa.getMozo() != null && this.productos.size() !=0){
            mesa.setMozo(mozo);
            mesa.setEstado("ocupada");
            Comanda comanda = new Comanda(mesa,pedidos,"abierta");
        }
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

    public double calculaSueldo(Mozo mozo){
        return this.getSueldoBasico()*(1+0.05* mozo.getCantHijos());
    }
        //agregar factura al mozo


    public TreeSet<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(TreeSet<Mesa> mesas) {
        this.mesas = mesas;
    }

    public TreeSet<Producto> getProductos() {
        return productos;
    }

    public void setProductos(TreeSet<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(ArrayList<Comanda> comandas) {
        this.comandas = comandas;
    }

    public TreeSet<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(TreeSet<Operario> operarios) {
        this.operarios = operarios;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}



