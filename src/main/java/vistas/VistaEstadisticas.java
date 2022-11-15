package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.*;

public class VistaEstadisticas extends JFrame implements Ivista{

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblCantidadDeHijos;
    private JLabel lblCrearMesa;
    private JLabel promedioVariable;
    private JLabel menosVentasVariables;
    private JLabel lblConsumoPromedioX_2;
    private JLabel maxVentasVariable;
    private String maxVentas;
    private String minVentas;
    private String promedioMesa;

    public VistaEstadisticas( String maxVentas , String minVentas , String promedioMesa) {
        this.maxVentas = maxVentas;
        this.minVentas = minVentas;
        this.promedioMesa = promedioMesa;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 677, 442);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblNewLabel = new JLabel("Empleado con menos ventas");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblNewLabel.setBounds(18, 69, 307, 39);
        contentPane.add(lblNewLabel);

        lblCantidadDeHijos = new JLabel("Empleado con mas ventas");
        lblCantidadDeHijos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblCantidadDeHijos.setBounds(174, 189, 294, 39);
        contentPane.add(lblCantidadDeHijos);

        lblCrearMesa = new JLabel("ESTADISTICAS");
        lblCrearMesa.setForeground(Color.BLUE);
        lblCrearMesa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblCrearMesa.setBounds(228, 10, 200, 39);
        contentPane.add(lblCrearMesa);

        promedioVariable = new JLabel();
        promedioVariable.setText(this.promedioMesa);
        promedioVariable.setFont(new Font("Arial", Font.PLAIN, 21));
        promedioVariable.setBounds(335, 118, 307, 39);
        contentPane.add(promedioVariable);

        menosVentasVariables = new JLabel();
        menosVentasVariables.setText(this.minVentas);
        menosVentasVariables.setFont(new Font("Arial", Font.PLAIN, 21));
        menosVentasVariables.setBounds(18, 118, 307, 39);
        contentPane.add(menosVentasVariables);

        lblConsumoPromedioX_2 = new JLabel("Consumo promedio x Mesas");
        lblConsumoPromedioX_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
        lblConsumoPromedioX_2.setBounds(335, 69, 307, 39);
        contentPane.add(lblConsumoPromedioX_2);

        maxVentasVariable = new JLabel();
        maxVentasVariable.setText(this.maxVentas);
        maxVentasVariable.setFont(new Font("Arial", Font.PLAIN, 21));
        maxVentasVariable.setBounds(174, 236, 307, 39);
        contentPane.add(maxVentasVariable);
    }

    public void ejecutar(){
        try {
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setMaxVentas(String maxVentas) {
        this.maxVentas = maxVentas;
    }

    public void setMinVentas(String minVentas) {
        this.minVentas = minVentas;
    }

    public void setPromedioMesa(String promedioMesa) {
        this.promedioMesa = promedioMesa;
    }
}
