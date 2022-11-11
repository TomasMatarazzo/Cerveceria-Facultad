package modelo;

import java.util.ArrayList;
import java.util.TreeSet;

public class Estadisticas {

    /**
     * Permite saber el nombre y apellido del mozo con mayor monto de ventas acumuladas
     * @param mozos debera ser distinto de null<br>
     * @return el nombre y apellido del mozo que tiene el mayor monto de ventas acumulado
     */
    public static String mayorVolumenVenta(TreeSet<Mozo> mozos){
        double max = -10;
        Mozo mozoMax = null;
        for (Mozo mozo:mozos){
            if (mozo.getVentas() > max){
                max = mozo.getVentas();
                mozoMax = mozo;
            }
        }

        return mozoMax.getNombreYApellido();
    }

    /**
     * Permite saber el nombre y apellido del mozo con menor monto de ventas acumuladas
     * @param mozos debera ser distinto de null<br>
     * @return el nombre y apellido del mozo que tiene el menor monto de ventas acumulado
     */
    public static String menorVolumenVenta(TreeSet<Mozo> mozos){
        double min = 10000000;
        Mozo mozoMax = null;
        for (Mozo mozo:mozos){
            if (mozo.getVentas() < min){
                min = mozo.getVentas();
                mozoMax = mozo;
            }
        }

        return mozoMax.getNombreYApellido();
    }

    /**
     * Permite saber el promedio de ventas por mesa
     * @param mesas debera ser distinto de null
     * @return un double con el consumo promedio por mesa
     */
    public static double promedioPorMesa(TreeSet<Mesa> mesas){
        double acum = 0;
        double acum2 = 0;
        for (Mesa mesa : mesas) {
            acum += mesa.getTotalComandas();
            acum2 += mesa.getCantComandas();
        }
        return acum / acum2;
    }
}
