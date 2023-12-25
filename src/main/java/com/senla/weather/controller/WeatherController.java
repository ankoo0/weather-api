package com.senla.weather.controller;

import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.LatestWeatherResponse;
import com.senla.weather.service.impl.SchedulerServiceImpl;
import com.senla.weather.service.impl.WeatherServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.senla.weather.controller.PathUtils.ROOT;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT)
public class WeatherController {

    private final SchedulerServiceImpl schedulerService;
    private final WeatherServiceImpl weatherService;

    @GetMapping
    LatestWeatherResponse getLatestWeather() {
        return weatherService.getLatestWeather();
    }

    @PostMapping
    Double getAverageTemperature(@Valid WeatherPeriodRequest periodRequest) {
        return weatherService.getAverageTemperatureByPeriod(periodRequest);
    }
}
