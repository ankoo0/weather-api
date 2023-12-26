package com.senla.weather.service.implementation;

import com.senla.weather.dto.WeatherRequest;
import com.senla.weather.integration.WeatherFeignClient;
import com.senla.weather.service.WeatherSchedulerService;
import com.senla.weather.service.WeatherService;
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

    @Scheduled(fixedDelayString ="${integration.weather-api.delay}")
    @Override
    public void getDataFromApi() {
        WeatherRequest weatherRequest = weatherFeignClient.getLatestWeatherInfo(location);
        weatherService.save(weatherRequest);
    }
}
