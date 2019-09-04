package Clima;

public class HeaderAccuweather {
    private String LocalObservationDateTime;
    private int EpochTime;
    private String WeatherText;
    private int WeatherIcon;
    private Boolean HasPrecipitation;
    private int PrecipitationType;
    private Boolean IsDayTime;
    private ClassTemperatura Temperature;
    private String MobileLink;
    private String Link;




    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        LocalObservationDateTime = localObservationDateTime;
    }

    public int getEpochTime() {
        return EpochTime;
    }

    public void setEpochTime(int epochTime) {
        EpochTime = epochTime;
    }

    public String getWeatherText() {
        return WeatherText;
    }

    public void setWeatherText(String weatherText) {
        WeatherText = weatherText;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public Boolean getHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public int getPrecipitationType() {
        return PrecipitationType;
    }

    public void setPrecipitationType(int precipitationType) {
        PrecipitationType = precipitationType;
    }

    public Boolean getDayTime() {
        return IsDayTime;
    }

    public void setDayTime(Boolean dayTime) {
        IsDayTime = dayTime;
    }

    public ClassTemperatura getTemperature() {
        return Temperature;
    }

    public void setTemperature(ClassTemperatura temperature) {
        Temperature = temperature;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
