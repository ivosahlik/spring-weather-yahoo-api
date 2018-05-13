package cz.ivosahlik.weatheryahooapi.cache;

import cz.ivosahlik.weatheryahooapi.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Intellij Idea
 * Created by ivosahlik on 13/05/2018
 */
@Slf4j
@Component
public class Cache {

    /**
     *
     * Run every day
     *
     * This method remove cache on server, launch remove cache is set cron
     *
     * 0 0 5,17 * * * = 5:00 AM and 5:00 PM every day.
     * 0 0 5 * * * = 5:00 AM every day.
     *
     */
    @Scheduled(cron = "0 0 1 * * *")
//    @Scheduled(fixedDelay = 20_000)
    @CacheEvict(value = Constants.FORECAST_OF_WEATHER, allEntries = true)
    public void clearCache() {
        log.info("cache cleared ... {} " + LocalDateTime.now());
    }

}
