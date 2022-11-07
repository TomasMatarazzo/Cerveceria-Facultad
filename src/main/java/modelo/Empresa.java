package modelo;


import excepciones.MozoIncorrecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

public class Empresa {
    private String nombreEmpresa;
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private TreeSet<Mesa> mesas = new TreeSet<>();;
    private TreeSet<Producto> productos= new TreeSet<>();
    private TreeSet<Operario> operarios= new TreeSet<>();

    public Empresa(String nombreEmpresa, ArrayList<Mozo> mozos, TreeSet<Mesa> mesas, TreeSet<Producto> productos, TreeSet<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
    }

    // --------- OPERARIOS ----------

    public void agregaMozo(String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto {
        try{
            this.mozos.add(new Mozo(nombreYApellido,fechaNacimiento,cantHijos,estado));
        }
        catch (MozoIncorrecto e){
            System.out.println(e.getMessage());
        }
    }

    public void modificaMozo(Mozo mozo,String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto{
        try{
            mozo.setNombreYApellido(nombreYApellido);
            mozo.setFechaNacimiento(fechaNacimiento);
            mozo.setCantHijos(cantHijos);
            mozo.setEstado(estado);
        }
        catch (MozoIncorrecto e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminaMozo(Mozo mozo){
        this.mozos.remove(mozo);
    }

    // Un operario se registra dentro del sistema
    public boolean Login( String usuario, String password) throws Exception{
        for (Operario op:operarios ){
            if ( op.getUsuario().equals(usuario) && op.getPassword() == password ){
                return true;
            }
            else{
                throw new Exception();
            }
        }

    }

    public void Logout{


    }

    
    public void Signup( String apellido, String usuario, String password, boolean activo){
        try {
            Operario operario = new Operario(apellido, usuario, password, activo);
            operarios.add(operario);
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
    }

    // --------- PRODUCTOS ------------

    public void altaProductos(int id, String nombre, double precioCosto, double precioVenta, int stockInicial){
        try{
            Producto prod = new Producto(id,nombre,precioCosto,precioVenta,stockInicial);
            productos.add(prod);
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

    public void bajaProductos( Producto producto){
        try{
            // chequear que el producto no se encuentre asociado a una comanda
            productos.remove(producto);
        }catch( Exception e){
            System.out.printf(e.getMessage());
        }
    }

    public void modificarProducto(String nombre, double precioCosto, double precioVenta, int stockInicial, Producto producto){
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

    public void altaMesas(int cantidadPersonas, String estado){
        try{
            Mesa mesa = new Mesa(cantidadPersonas,estado);
            mesas.add(mesa);
        }
        catch(Exception exception){
            System.out.printf(exception.getMessage());
        }
    }

    public void bajaMesass(Mesa mesa){
        try{
            mesas.remove(mesa);
        }
        catch(Exception exception){
            System.out.printf(exception.getMessage());
        }
    }

    public void modificaMesas(int cantidadPersonas, String estado, Mesa mesa){
        try{
            mesa.setEstado(estado);
            mesa.setCantidadPersonas(cantidadPersonas);
        }catch(Exception e){
            System.out.printf(e.getMessage());
        }

    }

    // ------- COMANDAS ---------

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



