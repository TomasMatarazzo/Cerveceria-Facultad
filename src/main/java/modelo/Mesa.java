package modelo;

public class Mesa {
    private static int id;
    private int nro;
    private int cantidadPersonas;
    private String estado;
    private Mozo mozo;
    private Pedido pedido;

    public Mesa( int cantidadPersonas, String estado) throws Exception{
        this.nro = Mesa.id++;
        this.setCantidadPersonas(cantidadPersonas);
        this.setEstado(estado);
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas){
            this.cantidadPersonas = cantidadPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if (this.estado.equalsIgnoreCase("libre") || this.estado.equalsIgnoreCase("ocupada"))
            this.estado = estado;
        else
            throw new Exception();
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "nro=" + nro +
                ", cantidadPersonas=" + cantidadPersonas +
                ", estado='" + estado + '\'' +
                ", mozo=" + mozo +
                ", pedido=" + pedido +
                '}';
    }
}
