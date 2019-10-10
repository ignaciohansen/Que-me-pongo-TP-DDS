import Api.Clima.Weatherbit.ApiClimaWeatherbit;
import org.junit.Test;

public class MapeoClima {
/*
    @Test
    public void Mapeo(){


        ApiClimaAccuweather api = new ApiClimaAccuweather();
        System.out.println("Se crea la api");

        api.obtenerHttpAccu();
        System.out.println("Se hace el llamado a la Api y se mapea");

        System.out.println("El LocalObservationDateTime es: " + api.currentConditions.getLocalObservationDateTime());
        System.out.println("El EpochTime es: " + api.currentConditions.getEpochTime());
        System.out.println("El WeatherText es: " + api.currentConditions.getWeatherText());
        System.out.println("El WeatherIcon es: " + api.currentConditions.getWeatherIcon());
        System.out.println("El HasPrecipitation es: " + api.currentConditions.getHasPrecipitation());
        System.out.println("El PrecipitationType es: " + api.currentConditions.getPrecipitationType());
        System.out.println("El IsDayTime es: " + api.currentConditions.getDayTime());
        System.out.println("El MobileLink es: " + api.currentConditions.getMobileLink());
        System.out.println("El Link es: " + api.currentConditions.getLink());

        System.out.println("Paso 1");
        ClassTemperatura temperatura = api.currentConditions.getTemperature();
        System.out.println("Paso 2");
        ClassSistemaUnidades unidad = temperatura.getMetric();
        System.out.println("Paso 3");
        double valor = unidad.getValue();
        System.out.println("Paso 4");
        System.out.println(valor);
        //double gradosCelcius = api.currentConditions.getTemperatura().getMetric().getValue();
        //System.out.println("La temperatura actual en grados celcius es: " + gradosCelcius);

    }

    @Test
    public void mapeoAMano(){

        Header header = new Header();
        ClassTemperatura temperatura = new ClassTemperatura();
        ClassSistemaUnidades unidades = new ClassSistemaUnidades();
        header.setWeatherText("Clear");
        header.setWeatherIcon(33);
        header.setTemperature(temperatura);
        temperatura.setMetric(unidades);
        unidades.setValue(10.2);
        unidades.setUnit("C");
        unidades.setUnitType(17);
        header.setLink("Link");

        Gson gson = new Gson();
        ArrayList<Header> lista = new ArrayList<Header>();
        lista.add(header);
        String JSON = gson.toJson(lista);
        System.out.println(JSON);

        Type listType = new TypeToken<ArrayList<Header>>(){}.getType();
        ArrayList<Header> array = gson.fromJson(JSON, listType);

        Header header2 = array.remove(0);

        System.out.println("El WeatherText es: " + header2.getWeatherText());
        System.out.println("El WeatherIcon es: " + header2.getWeatherIcon());
        System.out.println("El Link es: " + header2.getLink());
        System.out.println("El value es :" + header.getTemperature().getMetric().getValue());

    }
*/

@Test
public void llamadoWeatherbit(){
    ApiClimaWeatherbit api = new ApiClimaWeatherbit();

    int grados = api.getTemperatura();

    System.out.println(grados);
}
}
