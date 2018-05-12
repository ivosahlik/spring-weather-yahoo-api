package cz.ivosahlik.weatheryahooapi.service;

import cz.ivosahlik.weatheryahooapi.dto.CurrentForecastDto;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
public interface WeatherDataService {

    CurrentForecastDto getCurrentForecastOfCity(String cityName) throws Exception;

}
