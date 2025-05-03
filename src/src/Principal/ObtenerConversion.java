package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ObtenerConversion {

    public ObtenerConversion() {
    }


    public String obtenerDatos(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/5a3cb2c82914612b47d7aa12/pair/" + baseCurrency + "/" + targetCurrency;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificamos que el código de estado de correcto.
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Error: la API devolvió un código de estado " + response.statusCode());
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida al conectarse con la API: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La solicitud fue interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: la URL de la solicitud es inválida.");
        }

        return "{}";
    }

    public void registro(String baseCurrency, String targetCurrency, float cantidadOriginal, float cantidadConvertida) {
        String archivo = "registro_conversiones.txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formatter);

        String linea = String.format("[%s] %s => %s | %.2f => %.2f\n",
                fechaHora, baseCurrency, targetCurrency, cantidadOriginal, cantidadConvertida);

        try (FileWriter writer = new FileWriter(archivo, true)) { // true = modo append
            writer.write(linea);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de registro: " + e.getMessage());
        }
    }

    public void mostrarHistorial() {
        String archivo = "registro_conversiones.txt";
        System.out.println("\n--- Historial de conversiones ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean hayContenido = false;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
                hayContenido = true;
            }

            if (!hayContenido) {
                System.out.println("No hay conversiones registradas todavía.");
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer el historial: " + e.getMessage());
        }
    }
}
