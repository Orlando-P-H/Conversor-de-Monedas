package Principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;


public class ObtenerConversion {

    public ObtenerConversion() {
    }


    public String obtenerDatos(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/5a3cb2c82914612b47d7aa12/pair/"+baseCurrency+"/"+targetCurrency
                +"/"+20.0;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        return response.body();
    }




}
