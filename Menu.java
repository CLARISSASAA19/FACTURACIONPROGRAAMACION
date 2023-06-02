import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private List<Producto> productos;
    private int cantidadUnidades;
    public Menu() {
        scanner = new Scanner(System.in);
        productos = new ArrayList<>();
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("--Bienvenidos a farmacia Madagascar--");
            System.out.println("Seleccione una opción:");
            System.out.println("a. Ingresar producto");
            System.out.println("b. Facturar producto");
            System.out.println("c. Imprimir factura");
            System.out.println("d. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextLine().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    ingresarProducto();
                    break;
                case 'b':
                    facturarProducto();
                    break;
                case 'c':
                    imprimirFactura();
                    break;
                case 'd':
                    System.out.println("Gracias por su compra, vuelva pronto.");
                    return;
                default:
                    System.out.println("Opción invalida. Por favor, ingrese una opción valida.");
                    break;
            }

            System.out.println();
        } while (true);
    }

    private void ingresarProducto() {

        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio normal del producto:");
        double precioNormal = scanner.nextDouble();
        System.out.println("Ingrese el precio al por mayor del producto:");
        double precioMayorista = scanner.nextDouble();
        System.out.println("Ingrese el número de unidades para aplicar el precio al por mayor:");
        int unidadesMayorista = scanner.nextInt();
        Producto producto = new Producto(nombre, precioNormal, precioMayorista, unidadesMayorista);
        productos.add(producto);
        scanner.nextLine();

        System.out.println("Producto ingresado exitosamente.");

        System.out.println("¿Desea ingresar otro producto? (SI/NO)");
        String respuesta = scanner.nextLine().toLowerCase();
        if (respuesta.equals("si")) {
            ingresarProducto();
        }
    }

    private void facturarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos ingresados. Por favor, ingrese al menos un producto.");
            return;
        }
        System.out.println("Seleccione un producto:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre() + " (Precio normal: $" + producto.getPrecioNormal() +
                    ") (Precio al por mayor, más de " + producto.getUnidadesMayorista() +
                    " unidades: $" + producto.getPrecioMayorista() + ")");
        }

        int opcionProducto = scanner.nextInt();

        if (opcionProducto < 1 || opcionProducto > productos.size()) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            return;
        }

        Producto productoSeleccionado = productos.get(opcionProducto - 1);

        System.out.println("Ingrese la cantidad dde unidades que desea llevar:");
        this.cantidadUnidades = scanner.nextInt();



        scanner.nextLine();
    }
    private void imprimirFactura() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos ingresados. Por favor, ingrese al menos un producto.");
            return;
        }


        System.out.println("----- DATOS DEL CLIENTE PARA LA FACTURACION-----");
        System.out.println("Ingrese el nombre del cliente:");
        String nombredelCliente = scanner.nextLine();
        System.out.println("Ingrese el número de cédula del comprador:");
        String ceduladelCliente = scanner.nextLine();

        System.out.println("Productos:");
        double subtotal = 0.0;


        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            double precioProducto = producto.getPrecioNormal();

            if (this.cantidadUnidades >= producto.getUnidadesMayorista()) {
                precioProducto = producto.getPrecioMayorista();
            }

            double precioTotalProducto = precioProducto * this.cantidadUnidades;
            subtotal += precioTotalProducto;

            System.out.println((i + 1) + ". " + producto.getNombre() + " x " + this.cantidadUnidades +
                    " (Precio unitario: $" + precioProducto + ") (Total: $" + precioTotalProducto + ")");
        }

        double descuento = Descuento.calcularDescuento(subtotal);
        double totalConDescuento = Descuento.calcularTotalConDescuento(subtotal);
        System.out.println("Nombre del Cliente: " + nombredelCliente);
        System.out.println("Cédula del cliente: " + ceduladelCliente);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: " + (descuento * 100) + "%");
        System.out.println("Total con descuento: $" + totalConDescuento);
    }




}




