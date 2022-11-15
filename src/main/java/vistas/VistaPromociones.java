package vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.function.DoubleFunction;

import controladores.ControladorPromociones;
import modelo.*;

public class VistaPromociones extends JFrame implements Ivista {

    private JPanel contentPane;
    JList<ProductoEnPromocion> listaPromocionesProductos;
    JList<PromocionTemporal> listaPromocionesTemporales;
    JButton btnEstadoP2;
    JButton btnEstadoP1;
    JButton btnIngresarP2;
    JButton botonIngresarP1;
    JButton btnEliminarP1;
    JButton btnEliminarP2;
    FormPromocionesTemporales formPromocionesTemporales;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayList<PromocionTemporal> promocionTemporals = new ArrayList<>();
                    PromocionTemporal prom = new PromocionTemporal("hola","efectivo",30,1,true,true);
                    promocionTemporals.add(prom);
                    VistaPromociones frame = new VistaPromociones(promocionTemporals);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VistaPromociones( ArrayList<PromocionTemporal> promocionTemporals) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 879, 587);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Promociones temporales");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblNewLabel.setBounds(27, 25, 324, 35);
        contentPane.add(lblNewLabel);

        JLabel lblPromocionesDeProductos = new JLabel("Promociones de productos");
        lblPromocionesDeProductos.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblPromocionesDeProductos.setBounds(27, 280, 324, 35);
        contentPane.add(lblPromocionesDeProductos);

        listaPromocionesTemporales = new JList();
        listaPromocionesTemporales.setBounds(27, 105, 793, 156);
        contentPane.add(listaPromocionesTemporales);

        botonIngresarP1 = new JButton("Ingresar");
        botonIngresarP1.setActionCommand("MOSTRAR_P1");
        botonIngresarP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        botonIngresarP1.setBounds(27, 68, 101, 29);
        contentPane.add(botonIngresarP1);

        btnEliminarP1 = new JButton("Eliminar");
        btnEliminarP1.setActionCommand("ELIMINAR_P1");
        btnEliminarP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEliminarP1.setBounds(136, 68, 101, 29);
        contentPane.add(btnEliminarP1);

        btnEstadoP1 = new JButton("Cambiar estado");
        btnEstadoP1.setActionCommand("ESTADO_P1");
        btnEstadoP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEstadoP1.setBounds(245, 68, 145, 29);
        contentPane.add(btnEstadoP1);

        btnIngresarP2 = new JButton("Ingresar");
        btnIngresarP2.setActionCommand("MOSTRAR_P2");
        btnIngresarP2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnIngresarP2.setBounds(27, 323, 101, 29);
        contentPane.add(btnIngresarP2);

        btnEliminarP2 = new JButton("Eliminar");
        btnEliminarP2.setActionCommand("ELIMINAR_P2");
        btnEliminarP2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEliminarP2.setBounds(136, 323, 101, 29);
        contentPane.add(btnEliminarP2);

        btnEstadoP2 = new JButton("Cambiar estado");
        btnEstadoP2.setActionCommand("ESTADO_P2");
        btnEstadoP2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEstadoP2.setBounds(245, 323, 145, 29);
        contentPane.add(btnEstadoP2);

        listaPromocionesProductos = new JList();
        listaPromocionesProductos.setBounds(27, 360, 793, 156);
        contentPane.add(listaPromocionesProductos);

        formPromocionesTemporales = new FormPromocionesTemporales();
        formPromocionesTemporales.setVisible(false);
        this.renderPromocionesTemporales(promocionTemporals);
    }


    public void setActionListener(ControladorPromociones controlador) {
        this.botonIngresarP1.addActionListener(controlador);
        this.btnIngresarP2.addActionListener(controlador);
        this.btnEliminarP1.addActionListener(controlador);
        this.btnEliminarP2.addActionListener(controlador);
        this.btnEstadoP1.addActionListener(controlador);
        this.btnEstadoP2.addActionListener(controlador);
        this.getFormPromT().btnAgregar.addActionListener(controlador);
    }
    public FormPromocionesTemporales getFormPromT(){
        return this.formPromocionesTemporales;
    }

    public PromocionTemporal getPromocionTemporal(){
        return this.listaPromocionesTemporales.getSelectedValue();
    }

    public void renderPromocionesTemporales(ArrayList<PromocionTemporal> promos){
        DefaultListModel<PromocionTemporal> listaContratoDefault = new DefaultListModel<>();
        this.listaPromocionesTemporales.setModel(listaContratoDefault);
        for (PromocionTemporal promo : promos) {
            System.out.printf(promo.toString());
            listaContratoDefault.addElement(promo);
        }
        this.listaPromocionesTemporales.setModel(listaContratoDefault);
        contentPane.add(listaPromocionesTemporales);
        this.listaPromocionesTemporales.clearSelection();
    }

    public void ejecutar() {
        this.setVisible(true);
    }
}