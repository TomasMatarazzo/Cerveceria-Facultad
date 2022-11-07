package modelo;

import java.util.Date;

public class Mozo {
    private String nombreYApellido;
    private Date fechaNacimiento;
    private double cantHijos;
    private int estado;

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(double cantHijos) {
        this.cantHijos = cantHijos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
