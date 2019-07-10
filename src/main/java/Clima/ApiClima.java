package Clima;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiClima {

    public String obtenerHttp(){

        //String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/7894?apikey=fQCOo61H6Xu5CYLqCG0y7I1diIswXpaY";
        String url = "http://dataservice.accuweather.com/currentconditions/v1/7894.json?apikey=fQCOo61H6Xu5CYLqCG0y7I1diIswXpaY";

        CloseableHttpClient cliente = HttpClients.createDefault(); //Crea cliente
        HttpGet get = new HttpGet(url); //convierte URL en un GET
        CloseableHttpResponse respuesta = null; //instancio la response

        Gson gson = new Gson();

        try{
            respuesta = cliente.execute(get); //hago la llamada y obtengo la response
            HttpEntity entity = respuesta.getEntity();
            System.out.println(EntityUtils.toString(entity));  //imprimo el Json
            //En el println muestra una lista de objetos, por eso la segunda opción.
            //Header cabecera = gson.fromJson(EntityUtils.toString(entity), Header.class); //Intento de mapeo Json a Objeto
            ListaHeader listacabeceras = gson.fromJson(EntityUtils.toString(entity), ListaHeader.class); //Intento de mapeo Json a Objeto
            //String temperatura = EntityUtils.toString(entity);
            //String temperatura = "chau";
            return "chau";
        }
        catch (IOException ioe) { System.err.println("Hubo un error al consultar el clima: "); ioe.printStackTrace();}
        catch (Exception e ){ System.err.println("Error desconocido: "); e.printStackTrace();}

        return "hola";
    }
}

