package vistas;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import modelo.Producto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private TreeSet<Producto> productos;
    private TreeSet<Mesa> mesas;
    private TreeSet<Mozo> mozos;
    private ArrayList<Pedido> pedidos;



    public void setActionListener(ActionListener controlador) {
        this.botonIngresarProducto.addActionListener(controlador);
        this.formPedido.botonModificar.addActionListener(controlador);
        this.botonRegistrarse.addActionListener(controlador);
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
    public VistaComandas( TreeSet<Producto> productos, TreeSet<Mesa> mesas,TreeSet<Mozo> mozos,ArrayList<Pedido> pedidos) {
        this.productos = productos;
        this.mozos = mozos;
        this.mesas = mesas;
        this.pedidos = pedidos;

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 901, 670);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        botonRegistrarse = new JButton("Crear comanda");
        botonRegistrarse.setActionCommand("NUEVA_COMANDA");
        botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 21));
        botonRegistrarse.setBounds(355, 530, 214, 33);
        contentPane.add(botonRegistrarse);

        lblRegistreOperario = new JLabel("Nueva comanda - Seleccione un mozo, mesa y pedido");
        lblRegistreOperario.setVerticalAlignment(SwingConstants.TOP);
        lblRegistreOperario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lblRegistreOperario.setBounds(68, 10, 771, 45);
        contentPane.add(lblRegistreOperario);

        listaProductos = new JList();
        listaProductos.setBounds(0, 410, 877, 100);
        contentPane.add(listaProductos);

        botonIngresarProducto = new JButton("CREAR PEDIDO");
        botonIngresarProducto.setFont(new Font("Arial", Font.PLAIN, 21));
        botonIngresarProducto.setActionCommand("FORM_PEDIDO");
        botonIngresarProducto.setBounds(163, 369, 241, 33);
        contentPane.add(botonIngresarProducto);

        listaMesas = new JList();
        listaMesas.setBounds(0, 259, 877, 100);
        contentPane.add(listaMesas);

        listaMozos = new JList();
        listaMozos.setBounds(0, 106, 877, 100);

        JLabel lblMozos = new JLabel("Mozos");
        lblMozos.setFont(new Font("Arial", Font.BOLD, 30));
        lblMozos.setBounds(10, 63, 174, 33);
        contentPane.add(lblMozos);

        JLabel lblMesas = new JLabel("Mesas");
        lblMesas.setFont(new Font("Arial", Font.BOLD, 30));
        lblMesas.setBounds(10, 216, 174, 33);
        contentPane.add(lblMesas);

        JLabel lblProductos = new JLabel("Pedidos");
        lblProductos.setFont(new Font("Arial", Font.BOLD, 30));
        lblProductos.setBounds(10, 369, 174, 33);
        contentPane.add(lblProductos);

        formPedido = new FormPedido(productos);
        formPedido.setVisible(false);

        this.renderListaMozos(mozos);
        this.renderListaMesas(mesas);
        this.renderListaPedidos(pedidos);
    }

    public void hideFormPedido(){
        this.formPedido.setVisible(false);
    }

    public void showFormPedido(){
        this.formPedido.setVisible(true);
    }

    public Producto getSelectedProducto(){return this.formPedido.getProducto();}
    public Pedido getSelectedPedido(){ return this.listaProductos.getSelectedValue();}
    public Mozo getSelectedMozo(){ return this.listaMozos.getSelectedValue();}
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

    public TreeSet<Producto> getProductos() {
        return productos;
    }

    public void setProductos(TreeSet<Producto> productos) {
        this.productos = productos;
    }
}
