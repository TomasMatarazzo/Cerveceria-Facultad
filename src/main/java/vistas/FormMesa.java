package vistas;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormMesa extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField inputNro;
    private JLabel lblCantidadDeHijos;
    private JTextField inputCant;
    public JButton botonNuevaMesa;
    private JLabel lblCrearMesa;

    public void setActionListener(ActionListener controlador) {
        this.botonNuevaMesa.addActionListener(controlador);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormMesa frame = new FormMesa();
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
    public FormMesa() {
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

        lblNewLabel = new JLabel("Nro");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(10, 58, 200, 39);
        contentPane.add(lblNewLabel);

        inputNro = new JTextField();
        inputNro.setBounds(10, 102, 245, 33);
        contentPane.add(inputNro);
        inputNro.setColumns(10);

        lblCantidadDeHijos = new JLabel("Cantidad de sillas");
        lblCantidadDeHijos.setFont(new Font("Arial", Font.PLAIN, 21));
        lblCantidadDeHijos.setBounds(10, 145, 200, 39);
        contentPane.add(lblCantidadDeHijos);

        inputCant = new JTextField();
        inputCant.setColumns(10);
        inputCant.setBounds(10, 185, 245, 33);
        contentPane.add(inputCant);

        botonNuevaMesa = new JButton("Nueva mesa");
        botonNuevaMesa.setActionCommand("NUEVAMESA");
        botonNuevaMesa.setFont(new Font("Arial", Font.PLAIN, 21));
        botonNuevaMesa.setBounds(200, 242, 190, 56);
        contentPane.add(botonNuevaMesa);

        lblCrearMesa = new JLabel("CREAR MESA");
        lblCrearMesa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblCrearMesa.setBounds(212, 10, 200, 39);
        contentPane.add(lblCrearMesa);
    }

    public String getCantidadSillas(){
        return this.inputCant.getText();
    }

    public String getNroMesa(){
        return this.inputNro.getText();
    }

    public void setAgregarMesa(){
        botonNuevaMesa.setText("Agregar mesa");
        botonNuevaMesa.setActionCommand("NUEVAMESA");
    }
    public void setModificarMesa(){
        botonNuevaMesa.setText("Modificar mesa");
        botonNuevaMesa.setActionCommand("MODIFICAR_MESA");
    }

}
