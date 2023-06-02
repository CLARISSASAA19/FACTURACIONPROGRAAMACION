public class Producto {
    private String nombre;
    private double precioNormal;
    private double precioMayorista;
    private int unidadesMayorista;

    public Producto(String nombre, double precioNormal, double precioMayorista, int unidadesMayorista) {
        this.nombre = nombre;
        this.precioNormal = precioNormal;
        this.precioMayorista = precioMayorista;
        this.unidadesMayorista = unidadesMayorista;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioMayorista() {
        return precioMayorista;
    }

    public int getUnidadesMayorista() {
        return unidadesMayorista;
    }
}
