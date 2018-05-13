package cz.ivosahlik.weatheryahooapi.service.impl;

import cz.ivosahlik.weatheryahooapi.service.WeatherDataRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
@Service
public class WeatherDataRestServiceImpl implements WeatherDataRestService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.base.url}")
    private String baseUrl;

    @Value("${weather.forecast.query}")
    private String forecastQuery;

    @Value("${weather.forecast.query.full.url}")
    private String forecastQuesryFullUrl;

    private static final String QUERY_PARAM = "q";

    private static final String CITY_PLACEHOLDER = "##CITY##";

    private static final String BASE_URL = "https://query.yahooapis.com/v1/public/yql?" + QUERY_PARAM + "={query}&format=json";

    private static final String SEARCH_QUERY = "select item.forecast from weather.forecast where woeid in ( select woeid from geo.places(1) where text='" + CITY_PLACEHOLDER + "' ) and u='c'";


    @Override
    public String getCurrentForecastOfCity(String cityName) {
        return restTemplate.getForObject(BASE_URL, String.class, SEARCH_QUERY.replaceAll(CITY_PLACEHOLDER, cityName));
    }


    @Override
    public String getCurrentForecastOfCityFromConfig(String cityName) {
        return restTemplate.getForObject(baseUrl, String.class, forecastQuery.replaceAll(CITY_PLACEHOLDER, cityName));
    }


    @Override
    public String getCurrentForecastOfCityFromConfigFullUrl(String cityName) {
        return restTemplate.getForObject(forecastQuesryFullUrl, String.class, forecastQuery.replaceAll(CITY_PLACEHOLDER, cityName));
    }
}
