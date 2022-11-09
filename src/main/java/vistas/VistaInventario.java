package vistas;
import com.sun.source.tree.Tree;
import controladores.ControladorInventario;
import controladores.ControladorRegistrarse;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class VistaInventario extends JFrame {

    private JPanel contentPane;
    private JLabel lblRegistreOperario;
    private JButton botonIngresarProducto;
    private JButton botonEliminarProducto;
    private JButton botonModificarProducto;
    private JButton botonIngresarMozo;
    private JButton botonEliminarMozo;
    private JButton botonModificarMozo;
    private JButton botonIngresarMesa;
    private JButton botonEliminarMesa;
    private JButton botonModificarMesa;
    private JButton botonRegistrarse;
    private JList<Mozo> listaMozos;
    private JList<Mesa> listaMesas;
    private JList<Producto> listaProductos;
    private FormMesa formMesa;
    private FormMozo formMozo;
    private FormProducto formProducto;


    public void setActionListener(ActionListener controlador) {
        this.botonIngresarProducto.addActionListener(controlador);
        this.botonEliminarProducto.addActionListener(controlador);
        this.botonModificarProducto.addActionListener(controlador);
        this.botonIngresarMozo.addActionListener(controlador);
        this.botonEliminarMozo.addActionListener(controlador);
        this.botonModificarMozo.addActionListener(controlador);
        this.botonIngresarMesa.addActionListener(controlador);
        this.botonEliminarMesa.addActionListener(controlador);
        this.botonModificarMesa .addActionListener(controlador);
        this.formMozo.botonAgregar.addActionListener(controlador);
        this.formMesa.botonNuevaMesa.addActionListener(controlador);
        this.formProducto.botonAgregar.addActionListener(controlador);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mozo mozo1 = new Mozo("ignacitoo", Date.from(Instant.now()),3,0);
                    Mozo mozo2 = new Mozo("ignacito1o",Date.from(Instant.now()),3,1);
                    Mozo mozo3 = new Mozo("ignacito2o",Date.from(Instant.now()),3,2);

                    TreeSet<Mozo> mozos = new TreeSet<>();
                    mozos.add(mozo1);
                    mozos.add(mozo2);
                    mozos.add(mozo3);
                    VistaInventario frame = new VistaInventario(mozos);
                    ControladorInventario controlador = new ControladorInventario(frame);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VistaInventario( TreeSet<Mozo> mozos) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1013, 798);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        botonRegistrarse = new JButton("Ingresar");
        botonRegistrarse.setActionCommand("REGISTRARSE");
        botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 21));
        botonRegistrarse.setBounds(264, 703, 132, 33);
        contentPane.add(botonRegistrarse);

        lblRegistreOperario = new JLabel("Registre operario");
        lblRegistreOperario.setFont(new Font("Arial", Font.PLAIN, 21));
        lblRegistreOperario.setBounds(211, 20, 174, 33);
        contentPane.add(lblRegistreOperario);

        listaProductos = new JList();
        listaProductos.setBounds(10, 550, 979, 143);
        contentPane.add(listaProductos);

        botonIngresarProducto = new JButton("INGRESAR_PRODUCTO");
        botonIngresarProducto.setFont(new Font("Arial", Font.PLAIN, 21));
        botonIngresarProducto.setActionCommand("INGRESAR_PRODUCTO");
        botonIngresarProducto.setBounds(10, 507, 132, 33);
        contentPane.add(botonIngresarProducto);

        botonEliminarProducto = new JButton("ELIMINAR_PRODUCTO");
        botonEliminarProducto.setFont(new Font("Arial", Font.PLAIN, 21));
        botonEliminarProducto.setActionCommand("ELIMINAR_PRODUCTO");
        botonEliminarProducto.setBounds(152, 507, 132, 33);
        contentPane.add(botonEliminarProducto);

        botonModificarProducto = new JButton("MODIFICAR_PRODUCTO");
        botonModificarProducto.setFont(new Font("Arial", Font.PLAIN, 21));
        botonModificarProducto.setActionCommand("MODIFICAR_PRODUCTO");
        botonModificarProducto.setBounds(294, 507, 132, 33);
        contentPane.add(botonModificarProducto);

        botonIngresarMesa = new JButton("INGRESAR_MESA");
        botonIngresarMesa.setFont(new Font("Arial", Font.PLAIN, 21));
        botonIngresarMesa.setActionCommand("INGRESAR_MESA");
        botonIngresarMesa.setBounds(10, 306, 132, 33);
        contentPane.add(botonIngresarMesa);

        botonEliminarMesa = new JButton("ELIMINAR_MESA");
        botonEliminarMesa.setFont(new Font("Arial", Font.PLAIN, 21));
        botonEliminarMesa.setActionCommand("ELIMINAR_MESA");
        botonEliminarMesa.setBounds(152, 306, 132, 33);
        contentPane.add(botonEliminarMesa);

        botonModificarMesa = new JButton("MODIFICAR_MESA");
        botonModificarMesa.setFont(new Font("Arial", Font.PLAIN, 21));
        botonModificarMesa.setActionCommand("MODIFICAR_MESA");
        botonModificarMesa.setBounds(294, 306, 132, 33);
        contentPane.add(botonModificarMesa);

        listaMesas = new JList();
        listaMesas.setBounds(10, 349, 979, 143);
        contentPane.add(listaMesas);

        listaMozos = new JList();
        listaMozos.setBounds(10, 153, 979, 143);
        this.renderListaMozos(mozos);
        botonIngresarMozo = new JButton("INGRESAR_MOZO");
        botonIngresarMozo.setFont(new Font("Arial", Font.PLAIN, 21));
        botonIngresarMozo.setActionCommand("INGRESAR_MOZO");
        botonIngresarMozo.setBounds(10, 110, 132, 33);
        contentPane.add(botonIngresarMozo);

        botonEliminarMozo = new JButton("ELIMINAR_MOZO");
        botonEliminarMozo.setFont(new Font("Arial", Font.PLAIN, 21));
        botonEliminarMozo.setActionCommand("ELIMINAR_MOZO");
        botonEliminarMozo.setBounds(152, 110, 132, 33);
        contentPane.add(botonEliminarMozo);

        botonModificarMozo = new JButton("MODIFICAR_MOZO");
        botonModificarMozo.setFont(new Font("Arial", Font.PLAIN, 21));
        botonModificarMozo.setActionCommand("INGRESAR_MOZO");
        botonModificarMozo.setBounds(294, 110, 132, 33);
        contentPane.add(botonModificarMozo);

        JLabel lblMozos = new JLabel("Mozos");
        lblMozos.setFont(new Font("Arial", Font.BOLD, 30));
        lblMozos.setBounds(758, 110, 174, 33);
        contentPane.add(lblMozos);

        JLabel lblMesas = new JLabel("Mesas");
        lblMesas.setFont(new Font("Arial", Font.BOLD, 30));
        lblMesas.setBounds(758, 306, 174, 33);
        contentPane.add(lblMesas);

        JLabel lblProductos = new JLabel("Productos");
        lblProductos.setFont(new Font("Arial", Font.BOLD, 30));
        lblProductos.setBounds(758, 507, 174, 33);
        contentPane.add(lblProductos);

        formMesa = new FormMesa();
        formMesa.setVisible(false);
        formMozo = new FormMozo();
        formMozo.setVisible(false);
        formProducto = new FormProducto();
        formProducto.setVisible(false);
    }

    public void showFormMesa(){
        this.formMesa.setVisible(true);
    }

    public void showFormMozo(){
        this.formMozo.setVisible(true);
    }

    public void showFormProducto(){
        this.formProducto.setVisible(true);
    }

    public void hideFormMesa(){
        this.formMesa.setVisible(false);
    }

    public void hideFormMozo(){
        this.formMozo.setVisible(false);
    }

    public void hideFormProducto(){
        this.formProducto.setVisible(false);
    }

    public FormMesa getFormMesa(){
        return this.formMesa;
    }

    public FormMozo getFormMozo(){
        return this.formMozo;
    }

    public FormProducto getFormProducto(){
        return this.formProducto;
    }

    public Mozo getSelectedMozo(){
        return this.listaMozos.getSelectedValue();
    }
    public Producto getSelectedProducto(){
        return this.listaProductos.getSelectedValue();
    }
    public Mesa getSelectedMesas(){
        return this.listaMesas.getSelectedValue();
    }

    public void renderListaMozos(TreeSet<Mozo> mozos){
            DefaultListModel<Mozo> listaContratoDefault = new DefaultListModel<>();

            for (Mozo mozo : mozos) {
                listaContratoDefault.addElement(mozo);
            }
            this.listaMozos.setModel(listaContratoDefault);
            contentPane.add(listaMozos);
    }

    public void renderListaMesas(TreeSet<Mesa> mesas){
        DefaultListModel<Mesa> listaContratoDefault = new DefaultListModel<>();

        for (Mesa mesa : mesas) {
            listaContratoDefault.addElement(mesa);
        }
        this.listaMesas.setModel(listaContratoDefault);
        contentPane.add(listaMozos);
    }

    public void renderListaProductos(TreeSet<Producto> productos){
        DefaultListModel<Producto> listaContratoDefault = new DefaultListModel<>();

        for (Producto producto : productos) {
            listaContratoDefault.addElement(producto);
        }
        this.listaProductos.setModel(listaContratoDefault);
        contentPane.add(listaMozos);
    }
}
