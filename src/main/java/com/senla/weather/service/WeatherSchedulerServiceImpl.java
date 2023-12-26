package com.senla.weather.service;

import com.senla.weather.dto.Weather;
import com.senla.weather.integration.WeatherFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherSchedulerServiceImpl implements WeatherSchedulerService {

    private final WeatherFeignClient weatherFeignClient;
    private final WeatherService weatherService;
    @Value("${city.latitude}" + "," + "${city.longitude}")
    private String location;

    @Scheduled(fixedDelay = 10000)
    @Override
    public void getDataFromApi() {
        Weather weather = weatherFeignClient.getLatestWeatherInfo(location);
        weatherService.save(weather);
    }
}
