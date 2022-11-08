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

    public void setCantidadPersonas(int cantidadPersonas) throws Exception{
        if (cantidadPersonas >= 2 && this.nro >= 1)
            this.cantidadPersonas = cantidadPersonas;
        else{
            throw new Exception();
        }
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

    public void cerrarMesa(){
        this.estado="libre";

    }
}
