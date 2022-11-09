package modelo;

import java.util.ArrayList;
import java.util.TreeSet;

public class Estadisticas {

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
