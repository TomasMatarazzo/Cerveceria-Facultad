package modelo;

import excepciones.MozoIncorrecto;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Mozo implements Comparable<Mozo> {
    private String nombreYApellido;
    private Calendar fechaNacimiento;
    private double cantHijos;
    private int estado;
    private double ventas;

    public Mozo(String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado){
        this.setNombreYApellido(nombreYApellido);
        this.setFechaNacimiento(fechaNacimiento);
        this.setCantHijos(cantHijos);
        this.setEstado(estado);
    }


    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento){
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

    @Override
    public String toString() {
        return "Mozo{" +
                "nombreYApellido='" + nombreYApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", cantHijos=" + cantHijos +
                ", estado=" + estado +
                ", ventas=" + ventas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mozo mozo = (Mozo) o;
        return Objects.equals(getFechaNacimiento(), mozo.getFechaNacimiento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFechaNacimiento());
    }

    @Override
    public int compareTo(Mozo o) {
        return (this.nombreYApellido.compareTo(o.nombreYApellido));
    }
}
