package vistas;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPassword extends JFrame implements  Ivista{

    private JPanel contentPane;
    private JTextField inputPassword;
    private JButton btnPassword;

    /**
     * Launch the application.
     */
    public void ejecutar(){
        this.setVisible(true);
    }

    public void hideForm(){
        this.setVisible(false);
    }

    public void setActionListener(ActionListener controlador) {
        this.btnPassword.addActionListener(controlador);
    }
    public FormPassword() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 301);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        JLabel lblNewLabel = new JLabel("Ingrese la nueva password");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(45, 40, 258, 27);
        contentPane.add(lblNewLabel);

        btnPassword = new JButton("Modificar");
        btnPassword.setActionCommand("PASSWORD_ADMIN");
        btnPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnPassword.setBounds(45, 162, 130, 41);
        contentPane.add(btnPassword);

        inputPassword = new JTextField();
        inputPassword.setBounds(45, 93, 258, 35);
        contentPane.add(inputPassword);
        inputPassword.setColumns(10);
    }

    public String getPassword(){
        return this.inputPassword.getText();
    }
}
