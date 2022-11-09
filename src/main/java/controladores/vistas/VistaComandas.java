package controladores.vistas;
import controladores.ControladorComandas;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import modelo.Producto;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

public class VistaComandas extends JFrame {

    private JPanel contentPane;
    private JLabel lblRegistreOperario;
    private JButton botonIngresarProducto;
    private JButton botonRegistrarse;
    private JList<Mozo> listaMozos;
    private JList<Mesa> listaMesas;
    private JList<Pedido> listaProductos;
    private FormPedido formPedido;



    public void setActionListener(ActionListener controlador) {
        this.botonIngresarProducto.addActionListener(controlador);
        this.formPedido.botonModificar.addActionListener(controlador);
    }
    public void ejecutar(){
                try {
                    this.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }

    /**
     * Create the frame.
     */
    public VistaComandas( TreeSet<Mozo> mozos , TreeSet<Producto> productos) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 1013, 798);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        botonRegistrarse = new JButton("Crear comanda");
        botonRegistrarse.setActionCommand("CREAR_COMANDO");
        botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 21));
        botonRegistrarse.setBounds(445, 703, 214, 33);
        contentPane.add(botonRegistrarse);

        lblRegistreOperario = new JLabel("Nueva comanda");
        lblRegistreOperario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lblRegistreOperario.setBounds(211, 20, 287, 33);
        contentPane.add(lblRegistreOperario);

        listaProductos = new JList();
        listaProductos.setBounds(10, 550, 979, 143);
        contentPane.add(listaProductos);

        botonIngresarProducto = new JButton("CREAR PEDIDO");
        botonIngresarProducto.setFont(new Font("Arial", Font.PLAIN, 21));
        botonIngresarProducto.setActionCommand("FORM_PEDIDO");
        botonIngresarProducto.setBounds(10, 507, 241, 33);
        contentPane.add(botonIngresarProducto);

        listaMesas = new JList();
        listaMesas.setBounds(10, 349, 979, 143);
        contentPane.add(listaMesas);

        listaMozos = new JList();
        listaMozos.setBounds(10, 153, 979, 143);
        this.renderListaMozos(mozos);

        JLabel lblMozos = new JLabel("Mozos");
        lblMozos.setFont(new Font("Arial", Font.BOLD, 30));
        lblMozos.setBounds(758, 110, 174, 33);
        contentPane.add(lblMozos);

        JLabel lblMesas = new JLabel("Mesas");
        lblMesas.setFont(new Font("Arial", Font.BOLD, 30));
        lblMesas.setBounds(758, 306, 174, 33);
        contentPane.add(lblMesas);

        JLabel lblProductos = new JLabel("Pedidos");
        lblProductos.setFont(new Font("Arial", Font.BOLD, 30));
        lblProductos.setBounds(758, 507, 174, 33);
        contentPane.add(lblProductos);

        formPedido = new FormPedido(productos);
        formPedido.setVisible(false);
    }

    public void hideFormPedido(){
        this.formPedido.setVisible(false);
    }

    public void showFormPedido(){
        this.formPedido.setVisible(true);
    }

    public Producto getSelectedProducto(){
        return this.formPedido.getProducto();
    }
    public String getCantDelPedido(){
        return this.formPedido.getCant();
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

    public void renderListaPedidos(ArrayList<Pedido> pedidos) {
        DefaultListModel<Pedido> listaContratoDefault = new DefaultListModel<>();

        for (Pedido pedido : pedidos)
            listaContratoDefault.addElement(pedido);
        this.listaProductos.setModel(listaContratoDefault);
        contentPane.add(listaMozos);

    }
}
