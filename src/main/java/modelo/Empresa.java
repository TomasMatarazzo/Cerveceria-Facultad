package modelo;

import excepciones.MozoIncorrecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class Empresa {
    private String nombreEmpresa;
    private TreeSet<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();;
    private ArrayList<Producto> productos= new ArrayList<>();
    private TreeSet<Operario> operarios= new TreeSet<>();

    public Empresa(String nombreEmpresa, TreeSet<Mozo> mozos, ArrayList<Mesa> mesas, ArrayList<Producto> productos, TreeSet<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
    }

    //Funciones

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

    // Un operario sale del sistema
    public void Logout{


    }

    //Agregamos un operario al sistema
    // Aca verificamos el contrato del operario
    
    public void Signup( String apellido, String usuario, String password, boolean activo){
        Operario operario = new Operario(apellido, usuario, password, activo);
        operarios.add(operario);
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
