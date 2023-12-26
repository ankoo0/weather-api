package com.senla.weather.service;

import com.senla.weather.dto.WeatherRequest;
import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.AverageTemperatureResponse;
import com.senla.weather.response.LatestWeatherResponse;

public interface WeatherService {

    void save(WeatherRequest weatherRequest);

    LatestWeatherResponse getLatestWeather();

    AverageTemperatureResponse getAverageTemperatureByPeriod(WeatherPeriodRequest periodRequest);
}
