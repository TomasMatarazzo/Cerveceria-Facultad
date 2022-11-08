package modelo;

public class PromocionTemporal {
    private String nombre;
    private String formaDePago;
    private int porcentajeDescuento;
    private String diasDePromo;
    private boolean activo;
    private boolean esAcumulable;

    public PromocionTemporal(String nombre, String formaDePago, int porcentajeDescuento, String diasDePromo, boolean activo, boolean esAcumulable) {
        this.nombre = nombre;
        this.formaDePago = formaDePago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.diasDePromo = diasDePromo;
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

    public String getDiasDePromo() {
        return diasDePromo;
    }

    public void setDiasDePromo(String diasDePromo) {
        this.diasDePromo = diasDePromo;
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
