package Clima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class ApiClimaOpenWeatherMap {

    private static Object Map;

    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public static void obtenerHttpOpen(){
        String API_KEY;
    }
}
