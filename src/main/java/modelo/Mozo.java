package modelo;

import excepciones.MozoIncorrecto;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Mozo implements Comparable<Mozo> {
    private String nombreYApellido;
    private Calendar fechaNacimiento;
    private double cantHijos;
    private int estado; // 0 --> activo
                        // 1 --> ausente
                        // 2 --> franco
    private double ventas;

    public Mozo(String nombreYApellido, Calendar fechaNacimiento, double cantHijos, int estado){
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

    public String estadoToString(){
        switch (this.estado){
            case 0->{
                return "Activo";
            }
            case 1->{
                return "Ausente";
            }
            case 2->{
                return "Franco";
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return
                "Nombre y Apellido: " + nombreYApellido + '\'' + + '\'' +
                "           Estado: " + estadoToString() +
                ",          Cant Hijos: " + ventas
                ;
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
