import Clima.ApiClimaAccuweather;
import org.junit.Test;

public class MapeoClima {

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


        Float gradosCelcius = api.currentConditions.getTemperatura().getMetric().getValue();
        System.out.println("La temperatura actual en grados celcius es: " + gradosCelcius);

    }

}
