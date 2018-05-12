package cz.ivosahlik.weatheryahooapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import cz.ivosahlik.weatheryahooapi.enumeration.WeatherConditionCodes;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Intellij Idea
 * Created by ivosahlik on 04/04/2018
 */
@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentForecastDto {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd MMM yyyy", locale = "en_US")
    private Date date;

    @JsonProperty(value = "day")
    private String day;

    @JsonProperty(value = "high")
    private Integer high;

    @JsonProperty(value = "low")
    private Integer low;

    @JsonProperty(value = "text")
    private String text;

    @JsonIgnore
    private String city;

    @JsonIgnore
    private WeatherConditionCodes weatherConditionCodes;

    @JsonIgnore
    private String localDateTimeString;


    @JsonProperty(value = "code")
    public void setWeatherConditionCodes(int code) {
        this.weatherConditionCodes = WeatherConditionCodes.fromInt(code);
    }

    public WeatherConditionCodes getWeatherConditionCodes() {
        return weatherConditionCodes;
    }


    /**
     * This method convert Date to LocaleDateTime, set property localDateTimeString in format dd.M.yyyy
     */
    public void setLocalDateTimeString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(this.date.toInstant(), ZoneId.systemDefault());
        this.localDateTimeString = localDateTime.format(dateTimeFormatter);
    }


    public String getLocalDateTimeString() {
        return localDateTimeString;
    }

    @Override
    public String toString() {
        return "CurrentForecastDto{" +
                "date=" + date +
                ", day='" + day + '\'' +
                ", high=" + high +
                ", low=" + low +
                ", text='" + text + '\'' +
                ", city='" + city + '\'' +
                ", weatherConditionCodes=" + weatherConditionCodes +
                ", localDateTimeString='" + localDateTimeString + '\'' +
                '}';
    }
}
