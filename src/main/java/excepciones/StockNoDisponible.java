package excepciones;

public class StockNoDisponible extends Exception{
    public StockNoDisponible(String message) {
        super(message);
    }
}
