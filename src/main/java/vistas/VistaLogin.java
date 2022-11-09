package vistas;
import controladores.ControladorLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class VistaLogin extends JFrame {

    private JPanel contentPane;
    private JTextField inputUsuario;
    private JTextField inputContrasena;
    private JLabel lblNewLabel;
    private JLabel lblContrasena;
    private JButton botonLogin;

    public void setActionListener(ActionListener controlador) {
        this.botonLogin.addActionListener(controlador);
    }


    public VistaLogin() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        inputUsuario = new JTextField();
        inputUsuario.setBounds(10, 75, 375, 28);
        contentPane.add(inputUsuario);
        inputUsuario.setColumns(10);

        inputContrasena = new JTextField();
        inputContrasena.setColumns(10);
        inputContrasena.setBounds(10, 160, 375, 28);
        contentPane.add(inputContrasena);

        this.botonLogin = new JButton("Ingresar");
        this.botonLogin.setActionCommand("LOGIN");
        this.botonLogin.setFont(new Font("Arial", Font.PLAIN, 21));
        this.botonLogin.setBounds(143, 198, 132, 33);
        contentPane.add(this.botonLogin);

        lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(10, 32, 116, 33);
        contentPane.add(lblNewLabel);

        lblContrasena = new JLabel("Contrasena");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 21));
        lblContrasena.setBounds(10, 117, 116, 33);
        contentPane.add(lblContrasena);
    }

    public String getUsuario() {
        return this.inputUsuario.getText();
    }

    public String getContrasena() {
        return this.inputContrasena.getText();
    }

}