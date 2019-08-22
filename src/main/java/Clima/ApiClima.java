package Clima;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

// La que se usa actualmente, de el json que devuelve, se toma solo la temperatura, no se mapea a objetos.

public class ApiClima {

    public int obtenerHttp(){
        //String key = "xJpW9TCJKSPSyf95QV5TWKvHT8Tq3Ggs";
        String key = "fQCOo61H6Xu5CYLqCG0y7I1diIswXpaY";
        //String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/7894?apikey=fQCOo61H6Xu5CYLqCG0y7I1diIswXpaY";
        //String url = "http://dataservice.accuweather.com/currentconditions/v1/7894.json?apikey="+key;
        String url = "http://dataservice.accuweather.com/currentconditions/v1/6462.json?apikey="+key; //Ushuaia

        CloseableHttpClient cliente = HttpClients.createDefault(); //Crea cliente
        HttpGet get = new HttpGet(url); //convierte URL en un GET
        CloseableHttpResponse respuesta = null; //instancio la response

        Gson gson = new Gson();

        try{
            respuesta = cliente.execute(get); //hago la llamada y obtengo la response
            HttpEntity entity = respuesta.getEntity();
            //System.out.println(EntityUtils.toString(entity));  //imprimo el Json
            //EntityUtils.consume(entity);
            //En el println muestra una lista de objetos, por eso la segunda opción.
            //Header cabecera = gson.fromJson(EntityUtils.toString(entity), Header.class); //Intento de mapeo Json a Objeto
            //ListaHeader listacabeceras = gson.fromJson(EntityUtils.toString(entity), ListaHeader.class); //Intento de mapeo Json a Objeto
            //String temperatura = EntityUtils.toString(entity);
            //String temperatura = "chau";
            //String retorno = entity.getContentEncoding().toString();
            //String json = EntityUtils.toString(entity).toString();
            String responseString = new BasicResponseHandler().handleResponse(respuesta);
            System.out.println(responseString);

            int indiceValue = responseString.indexOf("Value");

            int indiceTemperatura = indiceValue + 7;

            String valorTemperatura = responseString.substring(indiceTemperatura, indiceTemperatura+2);

            System.out.println("Temperatura en String: " + valorTemperatura);
            if (valorTemperatura.substring(1).equals(".")){
                valorTemperatura = valorTemperatura.substring(0,1   );
            }
            System.out.println("Temperatura en String despues: " + valorTemperatura);
            int temperatura = Integer.parseInt(valorTemperatura);

            return temperatura;
        }
        catch (IOException ioe) { System.err.println("Hubo un error al consultar el clima: "); ioe.printStackTrace();}
        catch (Exception e ){ System.err.println("Error desconocido: "); e.printStackTrace();}


        //String json = "[{\"LocalObservationDateTime\":\"2019-07-10T14:35:00-03:00\",\"EpochTime\":1562780100,\"WeatherText\":\"Sunny\",\"WeatherIcon\":1,\"HasPrecipitation\":false,\"PrecipitationType\":null,\"IsDayTime\":true,\"Temperature\":{\"Metric\":{\"Value\":13.9,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":57.0,\"Unit\":\"F\",\"UnitType\":18}},\"MobileLink\":\"http://m.accuweather.com/en/ar/buenos-aires/7894/current-weather/7894?lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ar/buenos-aires/7894/current-weather/7894?lang=en-us\"}]";

        //ListaHeader listacabeceras = gson.fromJson(json, ListaHeader.class);

        //System.out.println(Header.getTemperatura().getMetric().getValue());

        return 0;
    }
}

