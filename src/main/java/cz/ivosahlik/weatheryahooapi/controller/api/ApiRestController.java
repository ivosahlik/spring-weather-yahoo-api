package cz.ivosahlik.weatheryahooapi.controller.api;

import cz.ivosahlik.weatheryahooapi.dto.CurrentForecastDto;
import cz.ivosahlik.weatheryahooapi.enumeration.WeatherForecastEnum;
import cz.ivosahlik.weatheryahooapi.service.impl.WeatherDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Intellij Idea
 * Created by ivosahlik on 13/05/2018
 */
@RequestMapping("/api")
@RestController
public class ApiRestController {

    @Autowired
    private WeatherDataServiceImpl weatherDataService;

    @RequestMapping("/weather")
    public CurrentForecastDto getCurrentForecastForCityJson(Model model) throws Exception {
        return weatherDataService.getCurrentForecastOfCity(WeatherForecastEnum.PRAGUE.getCityName());
    }

}
