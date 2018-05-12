package cz.ivosahlik.weatheryahooapi.service;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
public interface WeatherDataRestService {

    String getCurrentForecastOfCity(String cityName);

    String getCurrentForecastOfCityFromConfig(String cityName);

    String getCurrentForecastOfCityFromConfigFullUrl(String cityName);

}
