import Principal.ObtenerConversion;
import com.google.gson.Gson;
import modelos.Moneda;
import java.util.Scanner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ObtenerConversion conv = new ObtenerConversion();
        Gson gson = new Gson();

        int opcion;
        float cantidad;

        do {
            System.out.println("\n****************************************************" +
                    "\nSea bienvenido/a al Conversor de Monedas   =)" +
                    "\n1) Dólar => Peso Mexicano" +
                    "\n2) Peso Mexicano => Dólar" +
                    "\n3) Dólar => Bolívar Venezolano" +
                    "\n4) Bolívar Venezolano => Dólar" +
                    "\n5) Dólar => Peso Colombiano" +
                    "\n6) Peso Colombiano => Dólar" +
                    "\n7) Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertir("USD", "MXN", "dólares", "pesos mexicanos", scanner, conv, gson);
                case 2 -> convertir("MXN", "USD", "pesos mexicanos", "dólares", scanner, conv, gson);
                case 3 -> convertir("USD", "VES", "dólares", "bolívares venezolanos", scanner, conv, gson);
                case 4 -> convertir("VES", "USD", "bolívares venezolanos", "dólares", scanner, conv, gson);
                case 5 -> convertir("USD", "COP", "dólares", "pesos colombianos", scanner, conv, gson);
                case 6 -> convertir("COP", "USD", "pesos colombianos", "dólares", scanner, conv, gson);
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();

    }

    private static void convertir(String origen, String destino, String nombreOrigen, String nombreDestino,
                                  Scanner scanner, ObtenerConversion conv, Gson gson) throws IOException, InterruptedException {
        System.out.printf("Introduce la cantidad de %s (%s):%n", nombreOrigen, origen);
        float cantidad = scanner.nextFloat();

        String datos = conv.obtenerDatos(origen, destino);
        Moneda moneda = gson.fromJson(datos, Moneda.class);
        float resultado = moneda.Conversion(cantidad);

        System.out.printf("La cantidad de %.2f %s es igual a %.2f %s.%n",
                cantidad, nombreOrigen, resultado, nombreDestino);
    }

}


