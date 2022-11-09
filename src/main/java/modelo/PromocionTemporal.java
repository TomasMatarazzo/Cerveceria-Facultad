package modelo;

public class PromocionTemporal {
    private String nombre;
    private String formaDePago;
    private int porcentajeDescuento;
    private int diaDePromo;
    private boolean activo;
    private boolean esAcumulable;

    public PromocionTemporal(String nombre, String formaDePago, int porcentajeDescuento, int diaDePromo, boolean activo, boolean esAcumulable) {
        this.nombre = nombre;
        this.formaDePago = formaDePago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.diaDePromo = diaDePromo;
        this.activo = activo;
        this.esAcumulable = esAcumulable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getDiasDePromo() {
        return diaDePromo;
    }

    public void setDiasDePromo(int diaDePromo) {
        this.diaDePromo = diaDePromo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isEsAcumulable() {
        return esAcumulable;
    }

    public void setEsAcumulable(boolean esAcumulable) {
        this.esAcumulable = esAcumulable;
    }
}
