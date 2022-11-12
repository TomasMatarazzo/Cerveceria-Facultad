package vistas;

import modelo.Producto;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.TreeSet;

public class FormPedido extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField inputCant;
    public JButton botonModificar;
    private JLabel lblCrearproducto;
    private JLabel lblProducto;
    private JList<Producto> listaProductos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Producto prod1 = new Producto("hola1",12,24,15);
                    Producto prod2 = new Producto("hola1",12,24,15);
                    Producto prod3 = new Producto("hola1",12,24,15);

                    TreeSet<Producto> productos = new TreeSet<>();
                    productos.add(prod1);
                    productos.add(prod2);
                    productos.add(prod3);
                    FormPedido frame = new FormPedido(productos);
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
    public FormPedido(TreeSet<Producto> productos) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 615, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblNewLabel = new JLabel("Cantidad de productos");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(347, 59, 277, 39);
        contentPane.add(lblNewLabel);

        inputCant = new JTextField();
        inputCant.setBounds(346, 106, 245, 33);
        contentPane.add(inputCant);
        inputCant.setColumns(10);

        botonModificar = new JButton("CREAR");
        botonModificar.setActionCommand("CREAR_PEDIDO");
        botonModificar.setFont(new Font("Arial", Font.PLAIN, 21));
        botonModificar.setBounds(212, 262, 190, 56);
        contentPane.add(botonModificar);

        lblCrearproducto = new JLabel("PEDIDO");
        lblCrearproducto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblCrearproducto.setBounds(249, 10, 200, 39);
        contentPane.add(lblCrearproducto);

        lblProducto = new JLabel("Producto");
        lblProducto.setFont(new Font("Arial", Font.PLAIN, 21));
        lblProducto.setBounds(21, 59, 277, 39);
        contentPane.add(lblProducto);

        listaProductos = new JList<Producto>();
        renderListaProductos(productos);
        listaProductos.setBounds(21, 106, 293, 126);
        contentPane.add(listaProductos);
    }

    public Producto getProducto(){
        return this.listaProductos.getSelectedValue();
    }

    public String getCant(){
        return this.inputCant.getText();
    }
    
    public void renderListaProductos( TreeSet<Producto> productos){
        DefaultListModel<Producto> listaContratoDefault = new DefaultListModel<>();

        for (Producto producto : productos) {
            listaContratoDefault.addElement(producto);
        }
        this.listaProductos.setModel(listaContratoDefault);
        contentPane.add(listaProductos);
        }


}