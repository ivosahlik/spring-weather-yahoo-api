package cz.ivosahlik.weatheryahooapi.controller;

import cz.ivosahlik.weatheryahooapi.dto.CurrentForecastDto;
import cz.ivosahlik.weatheryahooapi.enumeration.WeatherForecastEnum;
import cz.ivosahlik.weatheryahooapi.service.impl.WeatherDataRestServiceImpl;
import cz.ivosahlik.weatheryahooapi.service.impl.WeatherDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
@Controller
public class IndexController {

    @Autowired
    private WeatherDataRestServiceImpl weatherDataRestService;

    @Autowired
    private WeatherDataServiceImpl weatherDataService;

    private static final String PARAM_WEATHER = "weather";

    private static final String PARAM_INDEX = "index";


    @GetMapping("/")
    public String index() {
        return PARAM_INDEX;
    }


    @RequestMapping("/weather")
    public String getCurrentForecastForCity(Model model) throws Exception {

        model.addAttribute(PARAM_WEATHER, weatherDataService.getCurrentForecastOfCity(WeatherForecastEnum.PRAGUE.getCityName()));

        return PARAM_WEATHER;
    }

}
