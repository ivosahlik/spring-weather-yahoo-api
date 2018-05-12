package cz.ivosahlik.weatheryahooapi.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.ivosahlik.weatheryahooapi.dto.CurrentForecastDto;
import cz.ivosahlik.weatheryahooapi.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService{

    @Autowired
    WeatherDataRestServiceImpl weatherDataRestService;

    private static final String QUERY = "query";
    private static final String RESULTS = "results";
    private static final String CHANNEL = "channel";
    private static final String ITEM = "item";
    private static final String FORECAST = "forecast";


    @Override
    public CurrentForecastDto getCurrentForecastOfCity(String cityName) throws Exception {
        String weather = weatherDataRestService.getCurrentForecastOfCity(cityName);
        log.info(weather);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode queryNode = mapper.readTree(weather).get(QUERY);

        log.info(queryNode.toString());

        CurrentForecastDto currentForecastDto = null;

        currentForecastDto = mapper.treeToValue(queryNode
                        .path(RESULTS)
                        .path(CHANNEL).
                                path(0)
                        .path(ITEM)
                        .path(FORECAST),
                CurrentForecastDto.class);

        currentForecastDto.setCity(cityName.toUpperCase());
        currentForecastDto.setLocalDateTimeString();

        log.info(currentForecastDto.getDay());
        log.info(currentForecastDto.getText());
        log.info(currentForecastDto.getHigh().toString());
        log.info(currentForecastDto.getLow().toString());
        log.info(currentForecastDto.getCity());
        log.info(currentForecastDto.getLocalDateTimeString());

        return currentForecastDto;
    }
}
