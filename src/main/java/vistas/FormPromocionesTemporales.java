package vistas;

import modelo.Mozo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.ArrayList;
import java.util.TreeSet;

public class FormPromocionesTemporales extends JFrame {

    private JPanel contentPane;
    private JTextField inputNombre;
    private JComboBox inputPago;
    private JLabel Nombre;
    private JLabel lblNombre;
    private JLabel inputPorcentaje;
    private JComboBox comboBox_1;
    private JLabel Nombre_2;
    private JComboBox comboBox_2;
    private JComboBox comboBox3;
    private JLabel Nombre_3;
    private JLabel Nombre_4;
    private JLabel Nombre_5;
    private JLabel Nombre_6;
    private JLabel Nombre_7;
    private JLabel Nombre_8;
    private JLabel Nombre_9;
    private JLabel Nombre_10;
    private JCheckBox chckbxNewCheckBox;
    private JCheckBox chckbxNewCheckBox_1;
    private JCheckBox chckbxNewCheckBox_2;
    private JCheckBox chckbxNewCheckBox_3;
    private JCheckBox chckbxNewCheckBox_4;
    private JCheckBox chckbxNewCheckBox_5;
    private JCheckBox chckbxNewCheckBox_6;
    private ArrayList<FormPromocionesTemporales> promos;
    public JButton btnAgregar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPromocionesTemporales frame = new FormPromocionesTemporales();
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
    public FormPromocionesTemporales() {
        String[] choices1 = {"Efectivo","Tarjeta","MercadoPago","CuentaDNI"};
        String[] choices2 = {"10%","20%","30%","40%","50%"};
        String[] choices3 = {"SI","NO"};
        String[] choices4 = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 392);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        inputNombre = new JTextField();
        inputNombre.setBounds(8, 47, 258, 24);
        contentPane.add(inputNombre);
        inputNombre.setColumns(10);

        inputPago = new JComboBox(choices1);
        inputPago.setBounds(8, 115, 258, 24);
        contentPane.add(inputPago);

        Nombre = new JLabel("Forma de pago");
        Nombre.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre.setBounds(8, 79, 166, 28);
        contentPane.add(Nombre);

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNombre.setBounds(8, 11, 125, 28);
        contentPane.add(lblNombre);

        inputPorcentaje = new JLabel("Porcentaje");
        inputPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 21));
        inputPorcentaje.setBounds(8, 147, 166, 28);
        contentPane.add(inputPorcentaje);

        comboBox_1 = new JComboBox(choices2);
        comboBox_1.setBounds(8, 183, 258, 24);
        contentPane.add(comboBox_1);

        Nombre_2 = new JLabel("Acumulable");
        Nombre_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_2.setBounds(8, 215, 166, 28);
        contentPane.add(Nombre_2);

        comboBox_2 = new JComboBox(choices3);
        comboBox_2.setBounds(8, 251, 258, 24);
        contentPane.add(comboBox_2);

        Nombre_3 = new JLabel("Dias");
        Nombre_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_3.setBounds(392, 11, 166, 28);
        contentPane.add(Nombre_3);

        Nombre_4 = new JLabel("Lunes");
        Nombre_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_4.setBounds(331, 43, 166, 28);
        contentPane.add(Nombre_4);

        Nombre_5 = new JLabel("Martes");
        Nombre_5.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_5.setBounds(331, 79, 166, 28);
        contentPane.add(Nombre_5);

        Nombre_6 = new JLabel("Miercoles");
        Nombre_6.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_6.setBounds(331, 115, 166, 28);
        contentPane.add(Nombre_6);

        Nombre_7 = new JLabel("Jueves");
        Nombre_7.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_7.setBounds(331, 147, 166, 28);
        contentPane.add(Nombre_7);

        Nombre_8 = new JLabel("Viernes");
        Nombre_8.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_8.setBounds(331, 183, 166, 28);
        contentPane.add(Nombre_8);

        Nombre_9 = new JLabel("Sabado");
        Nombre_9.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_9.setBounds(331, 215, 166, 28);
        contentPane.add(Nombre_9);

        Nombre_10 = new JLabel("Domingo");
        Nombre_10.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_10.setBounds(331, 251, 166, 28);
        contentPane.add(Nombre_10);

        Nombre_3 = new JLabel("Dias");
        Nombre_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
        Nombre_3.setBounds(8, 283, 166, 28);
        contentPane.add(Nombre_3);

        comboBox3 = new JComboBox(choices4);
        comboBox3.setBounds(8, 319, 258, 24);
        contentPane.add(comboBox3);

        btnAgregar = new JButton("Agregar promocion");
        btnAgregar.setActionCommand("INGRESAR_P1");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAgregar.setBounds(331, 306, 194, 37);
        contentPane.add(btnAgregar);


    }

    public String getNombre(){
        return this.inputNombre.getText();
    }

    public Object getFormaDePago(){
        return this.inputPago.getItemAt(this.inputPago.getSelectedIndex());
    }
    public int getDto(){
        return this.comboBox_1.getSelectedIndex();
    }
    public int getAcumulable(){
        return this.comboBox_2.getSelectedIndex();
    }

    public void ejecutar(){
        this.setVisible(true);
    }

    public void esconder(){
        this.setVisible(false);
    }

    public int getDias(){
        return this.comboBox3.getSelectedIndex();
    }

//    public void renderPromocionesT(ArrayList<FormPromocionesTemporales> promos){
//        DefaultListModel<FormPromocionesTemporales> listaContratoDefault = new DefaultListModel<>();
//        this..setModel(listaContratoDefault);
//        for (Mozo promo: promos) {
//            listaContratoDefault.addElement(promo);
//        }
//        this.promos.setModel(listaContratoDefault);
//        contentPane.add(promos);
//        this.promos.clearSelection();
//    }

}