package Clima;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiClimaAccuweather {

    public Header currentConditions = new Header();

    public void obtenerHttpAccu(){
        String key = "tymgDsqWKkeA0C0u9lVQupuhTSCjCoim";
        //String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/7894?apikey=fQCOo61H6Xu5CYLqCG0y7I1diIswXpaY";
        String url = "http://dataservice.accuweather.com/currentconditions/v1/7894.json?apikey="+key;

        CloseableHttpClient cliente = HttpClients.createDefault(); //Crea cliente
        HttpGet get = new HttpGet(url); //convierte URL en un GET
        CloseableHttpResponse respuesta = null; //instancio la response

        try{
            respuesta = cliente.execute(get); //hago la llamada y obtengo la response
            HttpEntity entity = respuesta.getEntity();
            String responseString = new BasicResponseHandler().handleResponse(respuesta);

            System.out.println(" ↓↓ Respuesta JSON de la Api ↓↓ ");
            System.out.println(responseString);

            Gson gson = new Gson();
            ArrayList<Header> listaClima = new ArrayList<>();

            Type listType = new TypeToken<ArrayList<Header>>(){}.getType();
            listaClima = gson.fromJson(responseString, listType);

            currentConditions = listaClima.remove(0);

        }
        catch (IOException ioe) { System.err.println("Hubo un error al consultar el clima: "); ioe.printStackTrace();}
        catch (Exception e ){ System.err.println("Error desconocido: "); e.printStackTrace();}

    }

    public Float getTemperatura(){
        return currentConditions.getTemperatura().getMetric().getValue();
    }
}