package Api.Clima.Weatherbit;

import java.io.IOException;

import Api.Clima.ApiClima;
import Api.Clima.Weatherbit.Current.HeaderWeatherbit;
import com.google.gson.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ApiClimaWeatherbit implements ApiClima {

    public HeaderWeatherbit currentConditions = new HeaderWeatherbit();

    public int getTemperatura(){

        //String key = "79b2b51fa3c770512d83aecefbbed648"; //openweathermap
        String key = "b761c834eedb4016b77ca40d8c904ef5";
        //String url = "api.openweathermap.org/data/2.5/weather?id=2172797&APPID" + key;
        //String url = "api.openweathermap.org/data/2.5/weather?id=2172797";
        String url = "https://api.weatherbit.io/v2.0/current?city=BuenosAires,AR&key=" + key;

        CloseableHttpClient cliente = HttpClients.createDefault(); //Crea cliente
        HttpGet get = new HttpGet(url); //convierte URL en un GET
        CloseableHttpResponse respuesta = null; //instancio la response

        try {
            respuesta = cliente.execute(get); //hago la llamada y obtengo la response
            HttpEntity entity = respuesta.getEntity();
            String responseString = new BasicResponseHandler().handleResponse(respuesta);

            System.out.println(" ↓↓ Respuesta JSON de la Api ↓↓ ");
            System.out.println(responseString);

            Gson gson = new Gson();

            currentConditions = gson.fromJson(responseString, HeaderWeatherbit.class);

            float gradosFloat = currentConditions.getData().remove(0).getTemp();
            return (int) Math.round(gradosFloat);
        }
        catch (IOException ioe) { System.err.println("Hubo un error al consultar el clima: "); ioe.printStackTrace();}
        catch (Exception e ){ System.err.println("Error desconocido: "); e.printStackTrace();}

        return 0;
    }


}
