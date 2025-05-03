package Principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;


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

}
