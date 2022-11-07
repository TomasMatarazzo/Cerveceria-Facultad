package modelo;

import excepciones.MozoIncorrecto;

import java.util.ArrayList;
import java.util.Date;

public class Empresa {

    private String nombreEmpresa;
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();;
    private ArrayList<Producto> productos= new ArrayList<>();
    private ArrayList<Operario> operarios= new ArrayList<>();

    public Empresa(String nombreEmpresa, ArrayList<Mozo> mozos, ArrayList<Mesa> mesas, ArrayList<Producto> productos, ArrayList<Operario> operarios) {
        this.nombreEmpresa = nombreEmpresa;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
    }

    //Funciones


    //ABM MOZOS

    public void agregaMozo(String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto {
        try {
            this.mozos.add(new Mozo(nombreYApellido,fechaNacimiento,cantHijos,estado));
        }
        catch (MozoIncorrecto e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminaMozo(){

    }

    public void modificaMozo(String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado){
    }


    // Un operario se registra dentro del sistema
    public void Login{


    }

    // Un operario sale del sistema
    public void Logout{


    }

    //Agregamos un operario al sistema
    // Aca verificamos el contrato del operario
    
    public void Signup(){


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
}
