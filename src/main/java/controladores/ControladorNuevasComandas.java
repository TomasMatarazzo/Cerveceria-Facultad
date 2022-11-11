package controladores;

import modelo.Empresa;
import vistas.VistaNuevaComandas;
import vistas.VistaRegistrarse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorNuevasComandas implements ActionListener{
    private VistaNuevaComandas vista;
    private Empresa modelo;

    public ControladorNuevasComandas(VistaNuevaComandas vista, Empresa modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "MODIFICAR_COMANDA":
                System.out.printf("MODIFICAR COMANDA");
                this.vista.hideVista();
                break;
            case "CREAR_FACTURA":
                System.out.printf("CREAR FACTURA");
                this.vista.hideVista();
                break;
        }
    }


}