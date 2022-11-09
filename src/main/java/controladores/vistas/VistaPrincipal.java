package controladores.vistas;

import controladores.ControladorPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
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


    public void setActionListener(ActionListener controlador) {
        this.btnModificarN.addActionListener(controlador);
        this.formSueldo.botonModificar.addActionListener(controlador);
        this.btnEstadisticas.addActionListener(controlador);
        this.btnComandas.addActionListener(controlador);
        this.btnGestiones.addActionListener(controlador);
        this.btnPromociones.addActionListener(controlador);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    VistaPrincipal frame = new VistaPrincipal();
                    ControladorPrincipal controlador = new ControladorPrincipal(frame);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public VistaPrincipal( ) {
        this.nombre = "Igna";
        this.sueldo = "40000";
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 685, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        botonOperario = new JButton("Nuevo operario");
        botonOperario.setFont(new Font("Arial", Font.BOLD, 21));
        botonOperario.setBounds(33, 180, 185, 35);
        contentPane.add(botonOperario);

        btnComandas = new JButton("Comandas");
        btnComandas.setActionCommand("COMANDAS");
        btnComandas.setFont(new Font("Arial", Font.BOLD, 21));
        btnComandas.setBounds(33, 240, 185, 35);
        contentPane.add(btnComandas);

        btnEstadisticas = new JButton("Estadisticas");
        btnEstadisticas.setActionCommand("ESTADISTICAS");
        btnEstadisticas.setFont(new Font("Arial", Font.BOLD, 21));
        btnEstadisticas.setBounds(33, 297, 185, 35);
        contentPane.add(btnEstadisticas);

        btnPromociones = new JButton("Promociones");
        this.btnPromociones.setActionCommand("PROMOCIONES");
        btnPromociones.setFont(new Font("Arial", Font.BOLD, 21));
        btnPromociones.setBounds(33, 354, 185, 35);
        contentPane.add(btnPromociones);

        btnGestiones = new JButton("Gestiones");
        btnGestiones.setActionCommand("GESTIONES");
        btnGestiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnGestiones.setFont(new Font("Arial", Font.BOLD, 21));
        btnGestiones.setBounds(33, 410, 185, 35);
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
