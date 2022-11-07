package modelo;

import excepciones.MozoIncorrecto;

import java.util.Date;

public class Mozo {
    private static Integer cont=0;
    private Integer id;
    private String nombreYApellido;
    private Date fechaNacimiento;
    private double cantHijos;
    private int estado;

    public Mozo(String nombreYApellido, Date fechaNacimiento, double cantHijos, int estado) throws MozoIncorrecto {
        this.setNombreYApellido(nombreYApellido);
        this.setFechaNacimiento(fechaNacimiento);
        this.setCantHijos(cantHijos);
        this.setEstado(estado);
        cont++;
        this.setId(cont);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setFechaNacimiento(Date fechaNacimiento) throws MozoIncorrecto{
        Date fechaactual = new Date(System.currentTimeMillis());
        int milisecondsByDay = 86400000;
        if((fechaactual.getTime()-fechaNacimiento.getTime())/(milisecondsByDay*365L)>=18){
            this.fechaNacimiento = fechaNacimiento;
        }
        else throw new MozoIncorrecto("La edad es menor a 18 anios");
    }

    public double getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(double cantHijos) throws MozoIncorrecto {
        if(cantHijos>=0)
            this.cantHijos = cantHijos;
        else throw new MozoIncorrecto("La cantidad de hijos ingresada es menor o igual a cero");
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
