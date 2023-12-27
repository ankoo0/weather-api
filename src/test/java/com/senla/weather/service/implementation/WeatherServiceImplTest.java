package com.senla.weather.service.implementation;

import com.senla.weather.dto.WeatherRequest;
import com.senla.weather.entity.WeatherEntity;
import com.senla.weather.mappers.WeatherMapper;
import com.senla.weather.repository.WeatherRepository;
import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.AverageTemperatureResponse;
import com.senla.weather.response.LatestWeatherResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static org.instancio.Instancio.create;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    @Mock
    private WeatherRepository weatherRepository;
    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    void save_ShouldSaveWeatherEntity() {
        WeatherRequest weatherRequest = create(WeatherRequest.class);
        WeatherEntity weatherEntity = WeatherMapper.fromDtoToEntity(weatherRequest);
        when(weatherRepository.save(any())).thenReturn(weatherEntity);

        weatherService.save(weatherRequest);

        assertEquals(weatherEntity, weatherRepository.save(any()));
    }

    @Test
    void getLatestWeather_ShouldReturnLatestWeatherResponse() {
        WeatherEntity weatherEntity = create(WeatherEntity.class);
        when(weatherRepository.findFirstByOrderByUpdatedAtDesc()).thenReturn(weatherEntity);

        LatestWeatherResponse expectedResponse = WeatherMapper.fromEntityToLatestWeatherResponse(weatherEntity);

        LatestWeatherResponse actualResponse = weatherService.getLatestWeather();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getAverageTemperatureByPeriod_ShouldReturnAverageTemperatureResponse() {
        LocalDate fromDate = LocalDate.of(2023, 12, 25);
        LocalDate toDate = LocalDate.of(2023, 12, 26);

        LocalDateTime fromDateTime = fromDate.atStartOfDay();
        LocalDateTime toDateTime = toDate.atTime(LocalTime.MAX);

        Double averageTemperature = 20.0;
        when(weatherRepository.getAverageTemperatureBetweenDates(fromDateTime, toDateTime)).thenReturn(averageTemperature);
        AverageTemperatureResponse expectedResponse = new AverageTemperatureResponse(20.0);

        AverageTemperatureResponse actualResponse = weatherService.getAverageTemperatureByPeriod(new WeatherPeriodRequest(fromDate, toDate));

        assertEquals(expectedResponse, actualResponse);
    }

}