package vistas;

import modelo.Operario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JFrame {

    private JPanel contentPane;
    private JButton botonOperario;
    private JButton btnComandas;
    private JButton btnEstadisticas;
    private JButton btnPromociones;
    private JButton btnGestiones;
    private JLabel lblNewLabel;
    private JLabel Nombre;
    private JLabel lblSueldoBase;
    private JButton btnModificarN;
    private JButton botonModificarS;
    private JLabel nombreVariable;
    private JLabel sueldoVariable;
    private String nombre = "";
    private String sueldo = "";
    private FormNombreySueldo formSueldo;
    private JButton btnNuevasComandas;


    public void setActionListener(ActionListener controlador) {
        this.btnModificarN.addActionListener(controlador);
        this.formSueldo.botonModificar.addActionListener(controlador);
        this.btnEstadisticas.addActionListener(controlador);
        this.btnComandas.addActionListener(controlador);
        this.btnGestiones.addActionListener(controlador);
        this.btnPromociones.addActionListener(controlador);
        this.botonOperario.addActionListener(controlador);
        this.btnNuevasComandas.addActionListener(controlador);
    }

    public void ejecutar(){
        this.setVisible(true);
    }

    public VistaPrincipal(Operario op) {
        this.setVisible(false);
        this.nombre = "Igna";
        this.sueldo = "40000";
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 685, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        botonOperario = new JButton("Nuevo operario");
        botonOperario.setActionCommand("REGISTRAR");
        if (op.esAdministrador()) {
            botonOperario.setFont(new Font("Arial", Font.BOLD, 15));
            botonOperario.setBounds(33, 180, 185, 35);
            contentPane.add(botonOperario);
        }

        btnComandas = new JButton("Nueva comanda");
        btnComandas.setActionCommand("COMANDAS");
        btnComandas.setFont(new Font("Arial", Font.BOLD, 15));
        btnComandas.setBounds(33, 297, 185, 35);
        contentPane.add(btnComandas);

        btnEstadisticas = new JButton("Estadisticas");
        btnEstadisticas.setActionCommand("ESTADISTICAS");
        btnEstadisticas.setFont(new Font("Arial", Font.BOLD, 21));
        btnEstadisticas.setBounds(33, 354, 185, 35);
        contentPane.add(btnEstadisticas);

        btnPromociones = new JButton("Promociones");
        btnPromociones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.btnPromociones.setActionCommand("PROMOCIONES");
        btnPromociones.setFont(new Font("Arial", Font.BOLD, 21));
        btnPromociones.setBounds(33, 402, 185, 35);
        contentPane.add(btnPromociones);

        btnGestiones = new JButton("Gestiones");
        btnGestiones.setActionCommand("GESTIONES");
        btnGestiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnGestiones.setFont(new Font("Arial", Font.BOLD, 21));
        btnGestiones.setBounds(33, 460, 185, 35);
        contentPane.add(btnGestiones);

        lblNewLabel = new JLabel("Cerveceria");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(228, 10, 260, 134);
        contentPane.add(lblNewLabel);

        Nombre = new JLabel("Nombre:");
        Nombre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        Nombre.setBounds(252, 175, 260, 45);
        contentPane.add(Nombre);

        lblSueldoBase = new JLabel("Sueldo base:");
        lblSueldoBase.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblSueldoBase.setBounds(252, 284, 260, 61);
        contentPane.add(lblSueldoBase);

        btnModificarN = new JButton("Modificar");
        btnModificarN.setActionCommand("FORMDATOS");
        btnModificarN.setFont(new Font("Arial", Font.BOLD, 21));
        btnModificarN.setBounds(462, 180, 185, 35);
        contentPane.add(btnModificarN);


        nombreVariable = new JLabel();
        nombreVariable.setText(this.nombre);
        nombreVariable.setFont(new Font("Arial",   Font.ITALIC, 21));
        nombreVariable.setBounds(252, 230, 260, 45);
        contentPane.add(nombreVariable);

        sueldoVariable = new JLabel();
        sueldoVariable.setText(this.sueldo);
        sueldoVariable.setFont(new Font("Arial",   Font.ITALIC, 21));
        sueldoVariable.setBounds(252, 344, 260, 45);
        contentPane.add(sueldoVariable);

        btnNuevasComandas = new JButton("Comandas");
        btnNuevasComandas.setFont(new Font("Arial", Font.BOLD, 21));
        btnNuevasComandas.setActionCommand("NUEVAS_COMANDAS");
        btnNuevasComandas.setBounds(33, 240, 185, 35);
        contentPane.add(btnNuevasComandas);

        formSueldo = new FormNombreySueldo();
        formSueldo.setVisible(false);


    }

    public void showFormSueldo(){
        this.formSueldo.setVisible(true);
    }

    public void hideFormSueldo(){
        this.formSueldo.setVisible(false);
    }
    public FormNombreySueldo getFormSueldo() {
        return formSueldo;
    }

    public void setNombre(String nombre){
        this.nombreVariable.setText( nombre);
    }

    public void setSueldo(String sueldo) {
        this.sueldoVariable.setText( sueldo);
    }
}
