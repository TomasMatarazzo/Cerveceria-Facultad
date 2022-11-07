package modelo;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.TreeSet;

public class Empresa {

    private String nombreEmpresa;
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();;
    private TreeSet<Producto> productos= new ArrayList<>();
    private TreeSet<Operario> operarios= new TreeSet<>();

    public Empresa(String nombreEmpresa, ArrayList<Mozo> mozos, ArrayList<Mesa> mesas, ArrayList<Producto> productos, TreeSet<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
    }

    // --------- OPERARIOS ----------

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


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(ArrayList<Operario> operarios) {
        this.operarios = operarios;
    }
>>>>>>> Stashed changes
}
