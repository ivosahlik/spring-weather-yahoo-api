package cz.ivosahlik.weatheryahooapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableCaching(proxyTargetClass = true)
@EnableScheduling
@PropertySource(value = {"classpath:/config/weather-config.properties"}, ignoreResourceNotFound = true)
@SpringBootApplication
public class WeatherYahooApiApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherYahooApiApplication.class, args);
	}
}
