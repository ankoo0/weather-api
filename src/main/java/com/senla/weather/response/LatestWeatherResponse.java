package com.senla.weather.response;

import java.time.LocalDateTime;

public record LatestWeatherResponse(
        String name,
        String country,
        LocalDateTime lastUpdated,
        Double tempC,
        String currentWeather,
        Double windMps,
        Double pressureMb,
        Integer humidity
) {
}
