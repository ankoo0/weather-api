package com.senla.weather.service;

import com.senla.weather.dto.Weather;
import com.senla.weather.integration.WeatherFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    public final WeatherFeignClient feignClient;
    public final WeatherService weatherService;

    @Scheduled(fixedDelay = 10000)
    @Override
    public void getDataFromApi() {
        Weather weather = feignClient.get("53.90060110,27.55897200");
        weatherService.save(weather);
    }
}
