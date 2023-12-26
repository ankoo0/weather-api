package com.senla.weather.integration;

import com.senla.weather.dto.WeatherRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "weather",
        url = "${integration.weather-api.url}",
        configuration = FeignConfig.class
)
public interface WeatherFeignClient {

    @GetMapping("/current.json")
    WeatherRequest getLatestWeatherInfo(@RequestParam("q") String latLong);
}
