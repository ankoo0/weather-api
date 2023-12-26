package com.senla.weather.service;

import com.senla.weather.dto.Weather;
import com.senla.weather.entity.WeatherEntity;
import com.senla.weather.mappers.WeatherMapper;
import com.senla.weather.repository.WeatherRepository;
import com.senla.weather.request.WeatherPeriodRequest;
import com.senla.weather.response.AverageTemperatureResponse;
import com.senla.weather.response.LatestWeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public void save(Weather weather) {
        WeatherEntity entity = WeatherMapper.fromDtoToEntity(weather);
        weatherRepository.save(entity);
    }

    @Override
    public LatestWeatherResponse getLatestWeather() {
        return WeatherMapper.fromEntityToLatestWeatherResponse(weatherRepository.findFirstByOrderByUpdatedAtDesc());
    }

    @Override
    public AverageTemperatureResponse getAverageTemperatureByPeriod(WeatherPeriodRequest periodRequest) {
        LocalDate fromDate = periodRequest.from();
        LocalDate toDate = periodRequest.to();

        LocalDateTime fromDateTime = fromDate.atStartOfDay();
        LocalDateTime toDateTime = toDate.atTime(LocalTime.MAX);

        return new AverageTemperatureResponse(weatherRepository.getAverageTemperatureBetweenDates(fromDateTime,toDateTime));
    }
}
