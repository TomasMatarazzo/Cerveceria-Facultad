package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormProducto extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField inputNombre;
    private JLabel lblFechaDeNacimiento;
    private JTextField inputCosto;
    private JLabel lblNewLabel_2;
    private JTextField inputVenta;
    private JLabel lblCantidadDeHijos;
    private JTextField inputStock;
    public JButton botonAgregar;

    public void setActionListener(ActionListener controlador) {
        this.botonAgregar.addActionListener(controlador);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormProducto frame = new FormProducto();
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
    public FormProducto() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 615, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre Producto");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(10, 25, 200, 39);
        contentPane.add(lblNewLabel);

        inputNombre = new JTextField();
        inputNombre.setBounds(10, 74, 245, 33);
        contentPane.add(inputNombre);
        inputNombre.setColumns(10);

        lblFechaDeNacimiento = new JLabel("Precio Costo");
        lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 21));
        lblFechaDeNacimiento.setBounds(10, 125, 200, 39);
        contentPane.add(lblFechaDeNacimiento);

        inputCosto = new JTextField();
        inputCosto.setColumns(10);
        inputCosto.setBounds(10, 174, 245, 33);
        contentPane.add(inputCosto);

        lblNewLabel_2 = new JLabel("Precio Venta");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(316, 125, 200, 39);
        contentPane.add(lblNewLabel_2);

        inputVenta = new JTextField();
        inputVenta.setColumns(10);
        inputVenta.setBounds(316, 174, 245, 33);
        contentPane.add(inputVenta);

        lblCantidadDeHijos = new JLabel("Stock Inicial");
        lblCantidadDeHijos.setFont(new Font("Arial", Font.PLAIN, 21));
        lblCantidadDeHijos.setBounds(316, 25, 200, 39);
        contentPane.add(lblCantidadDeHijos);

        inputStock = new JTextField();
        inputStock.setColumns(10);
        inputStock.setBounds(316, 74, 245, 33);
        contentPane.add(inputStock);

        botonAgregar = new JButton("Nuevo producto");
        botonAgregar.setActionCommand("NUEVOPRODUCTO");
        botonAgregar.setFont(new Font("Arial", Font.PLAIN, 21));
        botonAgregar.setBounds(200, 242, 190, 56);
        contentPane.add(botonAgregar);
    }

    public String getNombre(){
        return this.inputNombre.getText();
    }

    public String getCosto(){
        return this.inputCosto.getText();
    }

    public String getStock(){
        return this.inputStock.getText();
    }

    public String getVenta(){
        return this.inputVenta.getText();
    }
}