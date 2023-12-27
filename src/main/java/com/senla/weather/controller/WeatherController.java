package com.senla.weather.controller;

import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.AverageTemperatureResponse;
import com.senla.weather.response.LatestWeatherResponse;
import com.senla.weather.service.implementation.WeatherSchedulerServiceImpl;
import com.senla.weather.service.implementation.WeatherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import static com.senla.weather.controller.PathUtils.ROOT;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT)
public class WeatherController {

    private final WeatherSchedulerServiceImpl schedulerService;
    private final WeatherServiceImpl weatherService;

    @GetMapping
    @Operation(description = "Returns the latest weather information")
    LatestWeatherResponse getLatestWeather() {
        return weatherService.getLatestWeather();
    }

    @PostMapping
    @Operation(description = "Returns the average temperature for the given period")
    @Parameter(
            name =  "periodRequest",
            description  = "Chosen period to retrieve average temperature",
            example = """
                      {
                      “from”: “23-12-2023”,
                      “to”: “27-12-2023”
                      }
                      """,
            required = true)
    AverageTemperatureResponse getAverageTemperature(@Valid
                                                     @RequestBody
                                                     WeatherPeriodRequest periodRequest) {
        return weatherService.getAverageTemperatureByPeriod(periodRequest);
    }
}
