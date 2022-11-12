package vistas;

import java.awt.*;

import modelo.Comanda;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaNuevaComandas extends JFrame {

    private JPanel contentPane;
    private JButton btnModificarComanda;
    private JButton btnCrearFactura;
    private JLabel lblNewLabel;
    private JLabel lblPedidos;
    private JList<Comanda> listaComandas;
    private JList<Pedido> listaPedidos;
    private JLabel lblNewLabel_1;

    public void setActionListener(ActionListener controlador) {
        this.btnModificarComanda.addActionListener(controlador);
        this.btnCrearFactura.addActionListener(controlador);
    }

    public VistaNuevaComandas(ArrayList<Comanda> comandas, ArrayList<Pedido> pedidos) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 564, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        btnModificarComanda = new JButton("Agregar pedido");
        btnModificarComanda.setActionCommand("MODIFICAR_COMANDA");
        btnModificarComanda.setFont(new Font("Arial", Font.PLAIN, 21));
        btnModificarComanda.setBounds(45, 250, 216, 33);
        contentPane.add(btnModificarComanda);

        lblNewLabel = new JLabel("Comandas");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        lblNewLabel.setBounds(79, 60, 103, 19);
        contentPane.add(lblNewLabel);

        lblPedidos = new JLabel("Pedidos");
        lblPedidos.setFont(new Font("Arial", Font.PLAIN, 21));
        lblPedidos.setBounds(365, 60, 103, 19);
        contentPane.add(lblPedidos);

        listaComandas = new JList();
        listaComandas.setBounds(10, 102, 246, 105);
        contentPane.add(listaComandas);

        listaPedidos = new JList();
        listaPedidos.setBounds(292, 102, 246, 105);
        contentPane.add(listaPedidos);

        lblNewLabel_1 = new JLabel("Seleccion una comanda y agregue un pedido");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(63, 10, 431, 25);
        contentPane.add(lblNewLabel_1);

        btnCrearFactura = new JButton("Crear factura");
        btnCrearFactura.setFont(new Font("Arial", Font.PLAIN, 21));
        btnCrearFactura.setActionCommand("CREAR_FACTURA");
        btnCrearFactura.setBounds(282, 250, 216, 33);
        contentPane.add(btnCrearFactura);

        this.renderListaComandas(comandas);
        this.renderListaPedidos(pedidos);
    }



    public void ejecutar(){
        try{
            this.setVisible(true);
        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }

    public Comanda getSelectedComanda(){
        return this.listaComandas.getSelectedValue();
    }

    public Pedido getSelectedPedido(){
        return this.listaPedidos.getSelectedValue();
    }

    public void renderListaComandas(ArrayList<Comanda> comandas){
        DefaultListModel<Comanda> listaContratoDefault = new DefaultListModel<>();

        for (Comanda comanda : comandas) {
            listaContratoDefault.addElement(comanda);
        }
        this.listaComandas.setModel(listaContratoDefault);
        contentPane.add(listaComandas);
    }

    public void renderListaPedidos(ArrayList<Pedido> pedidos){
        DefaultListModel<Pedido> listaContratoDefault = new DefaultListModel<>();

        for (Pedido pedido : pedidos) {
            listaContratoDefault.addElement(pedido);
        }
        this.listaPedidos.setModel(listaContratoDefault);
        contentPane.add(listaPedidos);
    }

    public void hideVista(){
        this.setVisible(false);
    }
}