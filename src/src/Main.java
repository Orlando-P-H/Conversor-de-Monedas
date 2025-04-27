import Principal.ObtenerConversion;
import com.google.gson.Gson;
import modelos.Moneda;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Pruebas

        ObtenerConversion conv = new ObtenerConversion();

        String datos = conv.obtenerDatos("USD","GBP");

        //Creamos el objeto de la biblioteca para convertir  de JSON a Objeto.
        Gson gson = new Gson();

        //Creamos el objeto moneda.
        Moneda mon1 = gson.fromJson(datos, Moneda.class);

        //System.out.println(mon1.Conversion(20.0f));








    }
}