package vistas;

import controladores.ControladorLogin;
import controladores.ControladorRegistrarse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class VistaRegistrarse extends JFrame {

        private JPanel contentPane;
        private JTextField inputApellido;
        private JTextField inputUsuario;
        private JLabel lblNewLabel;
        private JLabel lblContrasena;
        private JLabel lblPassword;
        private JTextField inputPassword;
        private JLabel lblRegistreOperario;
        private JButton botonRegistrarse;

        public void setActionListener(ActionListener controlador) {
            this.botonRegistrarse.addActionListener(controlador);
        }

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        VistaRegistrarse frame = new VistaRegistrarse();
                        ControladorRegistrarse controlador = new ControladorRegistrarse(frame);
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
        public VistaRegistrarse() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 550, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            inputApellido = new JTextField();
            inputApellido.setBounds(10, 128, 375, 28);
            contentPane.add(inputApellido);
            inputApellido.setColumns(10);

            inputUsuario = new JTextField();
            inputUsuario.setColumns(10);
            inputUsuario.setBounds(10, 209, 375, 28);
            contentPane.add(inputUsuario);

            botonRegistrarse = new JButton("Ingresar");
            botonRegistrarse.setActionCommand("REGISTRARSE");
            botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 21));
            botonRegistrarse.setBounds(224, 396, 132, 33);
            contentPane.add(botonRegistrarse);

            lblNewLabel = new JLabel("Apellido");
            lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
            lblNewLabel.setBounds(10, 85, 116, 33);
            contentPane.add(lblNewLabel);

            lblContrasena = new JLabel("Usuario");
            lblContrasena.setFont(new Font("Arial", Font.PLAIN, 21));
            lblContrasena.setBounds(10, 166, 116, 33);
            contentPane.add(lblContrasena);

            lblPassword = new JLabel("Password");
            lblPassword.setFont(new Font("Arial", Font.PLAIN, 21));
            lblPassword.setBounds(10, 247, 116, 33);
            contentPane.add(lblPassword);

            inputPassword = new JTextField();
            inputPassword.setColumns(10);
            inputPassword.setBounds(10, 290, 375, 28);
            contentPane.add(inputPassword);

            lblRegistreOperario = new JLabel("Registre operario");
            lblRegistreOperario.setFont(new Font("Arial", Font.PLAIN, 21));
            lblRegistreOperario.setBounds(211, 20, 174, 33);
            contentPane.add(lblRegistreOperario);
        }

        public String getUsuario() {
            return this.inputUsuario.getText();
        }

        public String getContrasena() {
            return this.inputPassword.getText();
        }

        public String getApellido() {
            return this.inputApellido.getText();
        }

}
