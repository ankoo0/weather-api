package com.senla.weather.response;

import java.time.LocalDateTime;

public record LatestWeatherResponse(
        String name,
        String country,
        LocalDateTime updatedAt,
        Double tempInCelsius,
        String currentWeather,
        Double windInMps,
        Double pressureInMb,
        Integer humidity
) {
}
