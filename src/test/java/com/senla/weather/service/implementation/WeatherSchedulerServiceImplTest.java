package com.senla.weather.service.implementation;

import com.senla.weather.dto.WeatherRequest;
import com.senla.weather.integration.WeatherFeignClient;
import com.senla.weather.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import static org.instancio.Instancio.create;
import static org.mockito.Mockito.*;

@TestPropertySource(properties = { "city.latitude=52.520008", "city.longitude=13.404954" })
@ExtendWith(MockitoExtension.class)
class WeatherSchedulerServiceImplTest {

    @Mock
    private WeatherFeignClient weatherFeignClient;
    @Mock
    private WeatherService weatherService;
    @InjectMocks
    private WeatherSchedulerServiceImpl weatherSchedulerService;
    @Value("${city.latitude}" + "," + "${city.longitude}")
    private String location;

    @Test
    void getDataFromApi_ShouldGetWeatherInfoAndSave() {
        WeatherRequest weatherRequest = create(WeatherRequest.class);
        when(weatherFeignClient.getLatestWeatherInfo(location)).thenReturn(weatherRequest);

        weatherSchedulerService.getDataFromApi();

        verify(weatherFeignClient, times(1)).getLatestWeatherInfo(location);
        verify(weatherService, times(1)).save(weatherRequest);
    }
}