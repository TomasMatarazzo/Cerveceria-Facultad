package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormNombreySueldo extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField inputNombre;
    private JLabel lblCantidadDeHijos;
    private JTextField inputSueldo;
    public JButton botonModificar;
    private JLabel lblCrearMesa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormNombreySueldo frame = new FormNombreySueldo();
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
    public FormNombreySueldo() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 615, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre Empresa");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(10, 58, 200, 39);
        contentPane.add(lblNewLabel);

        inputNombre = new JTextField();
        inputNombre.setBounds(10, 102, 245, 33);
        contentPane.add(inputNombre);
        inputNombre.setColumns(10);

        lblCantidadDeHijos = new JLabel("Sueldo Base");
        lblCantidadDeHijos.setFont(new Font("Arial", Font.PLAIN, 21));
        lblCantidadDeHijos.setBounds(10, 145, 200, 39);
        contentPane.add(lblCantidadDeHijos);

        inputSueldo = new JTextField();
        inputSueldo.setColumns(10);
        inputSueldo.setBounds(10, 185, 245, 33);
        contentPane.add(inputSueldo);

        botonModificar = new JButton("MODIFICAR");
        botonModificar.setActionCommand("MODIFICAR_DATOS");
        botonModificar.setFont(new Font("Arial", Font.PLAIN, 21));
        botonModificar.setBounds(200, 242, 190, 56);
        contentPane.add(botonModificar);

        lblCrearMesa = new JLabel("DATOS EMPRESA");
        lblCrearMesa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblCrearMesa.setBounds(212, 10, 200, 39);
        contentPane.add(lblCrearMesa);
    }

    public String getNombre(){
        return this.inputNombre.getText();
    }

    public String getSueldo(){
        return this.inputSueldo.getText();
    }


}