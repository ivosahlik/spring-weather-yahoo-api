package cz.ivosahlik.weatheryahooapi.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "initial project";
    }

}
