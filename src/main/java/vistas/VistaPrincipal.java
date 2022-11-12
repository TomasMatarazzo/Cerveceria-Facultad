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
import java.awt.event.WindowListener;

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
    private JButton btnComenzarJornada;


    public void setActionListener(ActionListener controlador) {
        this.btnModificarN.addActionListener(controlador);
        this.formSueldo.botonModificar.addActionListener(controlador);
        this.btnEstadisticas.addActionListener(controlador);
        this.btnComandas.addActionListener(controlador);
        this.btnGestiones.addActionListener(controlador);
        this.btnPromociones.addActionListener(controlador);
        this.botonOperario.addActionListener(controlador);
        this.btnNuevasComandas.addActionListener(controlador);
        this.btnComenzarJornada.addActionListener(controlador);
        this.addWindowListener((WindowListener) controlador);
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
        contentPane.setFont(new Font("Tahoma", Font.PLAIN, 19));
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
            botonOperario.setFont(new Font("Arial", Font.BOLD, 18));
            botonOperario.setBounds(33, 190, 185, 35);
            contentPane.add(botonOperario);
        }

        btnComandas = new JButton("Nueva comanda");
        btnComandas.setActionCommand("COMANDAS");
        btnComandas.setFont(new Font("Arial", Font.BOLD, 18));
        btnComandas.setBounds(33, 284, 185, 35);
        contentPane.add(btnComandas);

        btnEstadisticas = new JButton("Estadisticas");
        btnEstadisticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnEstadisticas.setActionCommand("ESTADISTICAS");
        btnEstadisticas.setFont(new Font("Arial", Font.BOLD, 21));
        btnEstadisticas.setBounds(33, 413, 185, 35);
        contentPane.add(btnEstadisticas);

        btnPromociones = new JButton("Promociones");
        btnPromociones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.btnPromociones.setActionCommand("PROMOCIONES");
        btnPromociones.setFont(new Font("Arial", Font.BOLD, 21));
        btnPromociones.setBounds(33, 370, 185, 35);
        contentPane.add(btnPromociones);

        btnGestiones = new JButton("Mozos-Mesas");
        btnGestiones.setActionCommand("GESTIONES");
        btnGestiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnGestiones.setFont(new Font("Arial", Font.BOLD, 17));
        btnGestiones.setBounds(33, 241, 185, 35);
        contentPane.add(btnGestiones);

        lblNewLabel = new JLabel("Cerveceria");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(234, 8, 260, 134);
        contentPane.add(lblNewLabel);

        Nombre = new JLabel("Nombre:");
        Nombre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        Nombre.setBounds(252, 175, 260, 45);
        contentPane.add(Nombre);

        lblSueldoBase = new JLabel("Sueldo base:");
        lblSueldoBase.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblSueldoBase.setBounds(507, 167, 260, 61);
        contentPane.add(lblSueldoBase);

        btnModificarN = new JButton("Modificar");
        btnModificarN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnModificarN.setActionCommand("FORMDATOS");
        btnModificarN.setFont(new Font("Arial", Font.BOLD, 21));
        btnModificarN.setBounds(463, 283, 185, 35);
        contentPane.add(btnModificarN);


        nombreVariable = new JLabel();
        nombreVariable.setText(this.nombre);
        nombreVariable.setFont(new Font("Arial",   Font.ITALIC, 21));
        nombreVariable.setBounds(252, 230, 216, 45);
        contentPane.add(nombreVariable);

        sueldoVariable = new JLabel();
        sueldoVariable.setText(this.sueldo);
        sueldoVariable.setFont(new Font("Arial",   Font.ITALIC, 21));
        sueldoVariable.setBounds(507, 228, 164, 45);

        contentPane.add(sueldoVariable);

        btnNuevasComandas = new JButton("Comandas");
        btnNuevasComandas.setFont(new Font("Arial", Font.BOLD, 21));
        btnNuevasComandas.setActionCommand("NUEVAS_COMANDAS");
        btnNuevasComandas.setBounds(33, 327, 185, 35);
        contentPane.add(btnNuevasComandas);

        btnComenzarJornada = new JButton("Comenzar jornada");
        btnComenzarJornada.setFont(new Font("Arial", Font.BOLD, 21));
        btnComenzarJornada.setActionCommand("COMENZAR_JORNADA");
        btnComenzarJornada.setBounds(216, 519, 234, 35);
        contentPane.add(btnComenzarJornada);

        formSueldo = new FormNombreySueldo();
        formSueldo.setVisible(false);
        this.btnPromociones.setEnabled(false);
        this.btnNuevasComandas.setEnabled(false);
        this.btnEstadisticas.setEnabled(false);
    }

    public void arrancoJornada(){
        this.btnPromociones.setEnabled(true);
        this.btnNuevasComandas.setEnabled(true);
        this.btnEstadisticas.setEnabled(true);
        this.btnComenzarJornada.setText("Finalizar jornada");
        this.btnComenzarJornada.setActionCommand("FINALIZAR_JORNADA");
    }

    public void terminoJornada(){
        this.btnPromociones.setEnabled(false);
        this.btnNuevasComandas.setEnabled(false);
        this.btnEstadisticas.setEnabled(false);
        this.btnComenzarJornada.setText("Comenzar jornada");
        this.btnComenzarJornada.setActionCommand("COMENZAR_JORNADA");
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
