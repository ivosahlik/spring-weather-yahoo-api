package cz.ivosahlik.weatheryahooapi.enumeration;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
public enum WeatherForecastEnum {

    PRAGUE("Prague");


    private String cityName;

    WeatherForecastEnum(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

}
