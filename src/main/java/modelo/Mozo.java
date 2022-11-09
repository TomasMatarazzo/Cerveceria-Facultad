package modelo;

import excepciones.MozoIncorrecto;

import java.util.Date;

public class Mozo {
    private String nombreYApellido;
    private Date fechaNacimiento;
    private double cantHijos;
    private int estado;
    private double ventas;

    public Mozo(String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado){
        this.setNombreYApellido(nombreYApellido);
        this.setFechaNacimiento(fechaNacimiento);
        this.setCantHijos(cantHijos);
        this.setEstado(estado);
        this.ventas=0;
    }


    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento){
            this.fechaNacimiento = fechaNacimiento;
    }

    public double getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(double cantHijos){
            this.cantHijos = cantHijos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }
}
