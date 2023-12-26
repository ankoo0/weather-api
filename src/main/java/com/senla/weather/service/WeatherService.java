package com.senla.weather.service;

import com.senla.weather.dto.Weather;
import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.AverageTemperatureResponse;
import com.senla.weather.response.LatestWeatherResponse;

public interface WeatherService {

    void save(Weather weather);

    LatestWeatherResponse getLatestWeather();

    AverageTemperatureResponse getAverageTemperatureByPeriod(WeatherPeriodRequest periodRequest);
}
