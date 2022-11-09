package modelo;


import excepciones.MozoIncorrecto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa {
    private String nombreEmpresa;
    private int sueldoBasico;
    private TreeSet<Mozo> mozos = new TreeSet<>();
    private TreeSet<Mesa> mesas = new TreeSet<>();;
    private ArrayList<Producto> productos= new ArrayList<>();
    private ArrayList<Comanda> comandas=new ArrayList<>();
    private TreeSet<Operario> operarios= new TreeSet<>();
    private ArrayList<ProductoEnPromocion> promocionesProductos;
    private ArrayList<PromocionTemporal> promocionesTemporales;

    public Empresa(String nombreEmpresa, TreeSet<Mozo> mozos, TreeSet<Mesa> mesas, ArrayList<Producto> productos, TreeSet<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
    }

    // --------- OPERARIOS ----------

    public Operario Login( String usuario, String password) throws Exception{
        for (Operario op:operarios ){
            if ( op.getUsuario().equals(usuario) && op.getPassword().equals(password) ){
                if (op.isActivo())
                    return op;
            }
            else{
                throw new Exception();
            }
        }

    }

    public void Logout{


    }

    
    public void Signup( String apellido, String usuario, String password, boolean activo) throws Exception{
        String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            throw new Exception();
        }
        Matcher m = p.matcher(password);
        if (m.matches() && apellido.length() >= 6 && apellido.length() <= 12 && usuario.length() <= 10) {
            Operario operario = new Operario(apellido, usuario, password, activo);
            operarios.add(operario);
        }
        else
            throw  new Exception();

    }

    // --------- MOZOS ----------

    public void agregaMozo(String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto {
        // VERIFICAR LA EDAD
        Date fechaactual = new Date(System.currentTimeMillis());
        int milisecondsByDay = 86400000;
        if((fechaactual.getTime()-fechaNacimiento.getTime())/(milisecondsByDay*365L)>=18){
            if( cantHijos >= 0 ){
                this.mozos.add(new Mozo(nombreYApellido,fechaNacimiento,cantHijos,estado));
            }
            else{
                throw new MozoIncorrecto("Cant de hijos menor a cero");
            }
        }
        else{
            throw  new MozoIncorrecto("Edad menor a 18 anos");
        }
    }

    public void modificaMozo(Mozo mozo,String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado){
        mozo.setNombreYApellido(nombreYApellido);
        mozo.setFechaNacimiento(fechaNacimiento);
        mozo.setCantHijos(cantHijos);
        mozo.setEstado(estado);
    }

    public void eliminaMozo(Mozo mozo){
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

    public void altaMesa(int cantidadPersonas, String estado) throws Exception{
        if (cantidadPersonas >= 2 ){
            Mesa mesa = new Mesa(cantidadPersonas,estado);
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

    // ------- COMANDAS ---------
    /*
    public void altaComanda( Mesa mesa, ArrayList<Producto> productos, String estado){
        // creo el array de pedidos
        boolean libre = false;
        if (mesa.getEstado().equalsIgnoreCase("libre") && mesa.getMozo() != null && this.productos.size() !=0){
            // chequear promocion
            libre = true
        }
        }
        if (libre){
            // revisar esto
            mesa.setEstado("ocupada");
            Comanda comanda = new Comanda(mesa,productos,estado);
        }
    }
    */
    // ----- GET Y SET ----


    public int getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(int sueldoBasico) {
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
        mesa.getMozo().setVentas(mesa.getMozo().getVentas()+ factura.getTotal());
        mesa.setCantComandas(mesa.getCantComandas()+1);
        mesa.setTotalComandas(mesa.getTotalComandas()+ factura.getTotal());
        this.comandas.remove(comanda);
    }

    public double calculaSueldo(Mozo mozo){
        return this.getSueldoBasico()*(1+0.05* mozo.getCantHijos());
    }
        //agregar factura al mozo
}



