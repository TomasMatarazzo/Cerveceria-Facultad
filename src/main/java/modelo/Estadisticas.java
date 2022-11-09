package modelo;

import java.util.TreeSet;

public class Estadisticas {

    public static Mozo mayorVolumenVenta(TreeSet<Mozo> mozos){
        double max = -10;
        Mozo mozoMax = null;
        for (Mozo mozo:mozos){
            if (mozo.getVentas() > max){
                max = mozo.getVentas();
                mozoMax = mozo;
            }
        }

        return mozoMax;
    }

    public static Mozo menorVolumenMesa(TreeSet<Mozo> mozos){
        double min = 10000000;
        Mozo mozoMax = null;
        for (Mozo mozo:mozos){
            if (mozo.getVentas() < min){
                min = mozo.getVentas();
                mozoMax = mozo;
            }
        }

        return mozoMax;
    }

//    public static double promedioPorMesa(){
//        System.out.printf("completar");
//    }
}
