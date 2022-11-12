package vistas;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FormMozo extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField inputNombre;
    private JLabel lblFechaDeNacimiento;
    private JTextField inputFecha;
    private JLabel lblNewLabel_2;
    private JLabel lblCantidadDeHijos;
    private JTextField inputCantHijos;
    public JButton botonAgregar;
    private JComboBox<String> inputEstado;

    public void setActionListener(ActionListener controlador) {
        this.botonAgregar.addActionListener(controlador);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormMozo frame = new FormMozo();
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
    public FormMozo() {
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

        lblNewLabel = new JLabel("Nombre y Apellido");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(10, 25, 200, 39);
        contentPane.add(lblNewLabel);

        inputNombre = new JTextField();
        inputNombre.setBounds(10, 74, 245, 33);
        contentPane.add(inputNombre);
        inputNombre.setColumns(10);

        lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
        lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 21));
        lblFechaDeNacimiento.setBounds(10, 125, 200, 39);
        contentPane.add(lblFechaDeNacimiento);

        inputFecha = new JTextField();
        inputFecha.setColumns(10);
        inputFecha.setBounds(10, 174, 245, 33);
        contentPane.add(inputFecha);

        lblNewLabel_2 = new JLabel("Estado");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(316, 125, 200, 39);
        contentPane.add(lblNewLabel_2);

        lblCantidadDeHijos = new JLabel("Cantidad de hijos");
        lblCantidadDeHijos.setFont(new Font("Arial", Font.PLAIN, 21));
        lblCantidadDeHijos.setBounds(316, 25, 200, 39);
        contentPane.add(lblCantidadDeHijos);

        inputCantHijos = new JTextField();
        inputCantHijos.setColumns(10);
        inputCantHijos.setBounds(316, 74, 245, 33);
        contentPane.add(inputCantHijos);

        botonAgregar = new JButton();
        botonAgregar.setText("Agregar mozo");
        botonAgregar.setActionCommand("NUEVOMOZO");
        botonAgregar.setFont(new Font("Arial", Font.PLAIN, 21));
        botonAgregar.setBounds(200, 242, 190, 56);
        contentPane.add(botonAgregar);

        String[] choices = {"activo","ausente","franco"};

        inputEstado = new JComboBox(choices) ;
        inputEstado.setBounds(316, 174, 245, 33);
        contentPane.add(inputEstado);
    }

    public void setModificarMozo(){
        botonAgregar.setText("Modificar mozo");
        botonAgregar.setActionCommand("MODIFICAR_MOZO");
    }

    public void setAgregarMozo(){
        botonAgregar.setText("Agregar mozo");
        botonAgregar.setActionCommand("NUEVOMOZO");
    }


    public String getNombre(){
        return this.inputNombre.getText();
    }

    public String getCantHijos(){
        return this.inputCantHijos.getText();
    }

    public String getFecha(){
        return this.inputFecha.getText();
    }

    public int getEstado(){
        return this.inputEstado.getSelectedIndex();
    }
}