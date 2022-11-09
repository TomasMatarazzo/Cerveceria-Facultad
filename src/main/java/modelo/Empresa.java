package modelo;


import excepciones.MozoIncorrecto;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa {
    public static Empresa instance = null;
    private String nombreEmpresa;
    private TreeSet<Mozo> mozos = new TreeSet<>();
    private TreeSet<Mesa> mesas = new TreeSet<>();;
    private TreeSet<Producto> productos= new TreeSet<>();
    private TreeSet<Operario> operarios= new TreeSet<>();

    public Empresa(){

    }

    public Empresa(String nombreEmpresa, TreeSet<Mozo> mozos, TreeSet<Mesa> mesas, TreeSet<Producto> productos, TreeSet<Operario> operarios) throws Exception{
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
    }

    public static Empresa getInstance() throws Exception{
            if (instance == null)
                instance = new Empresa();
            return instance;
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
        return null;
    }

//    public void Logout{
//
//
//    }

    
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

    public void agregaMozo(String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto {
        // VERIFICAR LA EDAD
        System.out.printf("hola");
        Date fechaactual = new Date(System.currentTimeMillis());
        int milisecondsByDay = 86400000;
        System.out.printf("\n El nombre es " + nombreYApellido + fechaNacimiento + cantHijos + estado);
            if( cantHijos >= 0 ){
                this.mozos.add(new Mozo(nombreYApellido,fechaNacimiento,cantHijos,estado));
            }
            else{
                throw new MozoIncorrecto("Cant de hijos menor a cero");
            }
    }

    public void modificaMozo(Mozo mozo,String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado){
        mozo.setNombreYApellido(nombreYApellido);
        mozo.setFechaNacimiento(fechaNacimiento);
        mozo.setCantHijos(cantHijos);
        mozo.setEstado(estado);
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

//    public void altaComanda( Mesa mesa, ArrayList<Producto> productos, String estado){
//        // creo el array de pedidos
//        boolean libre = false;
//        if (mesa.getEstado().equalsIgnoreCase("libre") && mesa.getMozo() != null && this.productos.size() !=0){
//            // chequear promocion
//            libre = true
//        }
//        }
//        if (libre){
//            // revisar esto
//            mesa.setEstado("ocupada");
//            Comanda comanda = new Comanda(mesa,productos,estado);
//        }
//    }

    // ----- GET Y SET ----


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

    public TreeSet<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(TreeSet<Operario> operarios) {
        this.operarios = operarios;
    }
}


