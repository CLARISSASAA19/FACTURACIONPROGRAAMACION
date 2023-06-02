public class Descuento {
    private static final double descuento0 = 0.0;
    private static final double descuento1= 0.05;
    private static final double descuento2 = 0.07;
    private static final double descuento3= 0.10;

    public static double calcularDescuento(double subtotal) {
        if (subtotal <= 100) {
            return descuento0;
        } else if (subtotal <= 500) {
            return descuento1;
        } else if (subtotal <= 1000) {
            return descuento2;
        } else {
            return descuento3;
        }
    }

    public static double calcularTotalConDescuento(double subtotal) {
        double descuento = calcularDescuento(subtotal);
        double total = subtotal - (subtotal * descuento);
        return total;
    }
}
