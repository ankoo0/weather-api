package com.senla.weather.controller;

import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.AverageTemperatureResponse;
import com.senla.weather.response.LatestWeatherResponse;
import com.senla.weather.service.SchedulerServiceImpl;
import com.senla.weather.service.WeatherServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    AverageTemperatureResponse getAverageTemperature(@Valid @RequestBody WeatherPeriodRequest periodRequest) {
        return weatherService.getAverageTemperatureByPeriod(periodRequest);
    }
}
