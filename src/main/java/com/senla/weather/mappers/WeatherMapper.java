package com.senla.weather.mappers;

import com.senla.weather.dto.WeatherRequest;
import com.senla.weather.entity.WeatherEntity;
import com.senla.weather.response.LatestWeatherResponse;
import lombok.experimental.UtilityClass;
import java.time.LocalDateTime;

@UtilityClass
public class WeatherMapper {

  public static WeatherEntity fromDtoToEntity(WeatherRequest weatherRequest) {
      WeatherEntity weatherEntity = new WeatherEntity();
      weatherEntity.setName(weatherRequest.location().name());
      weatherEntity.setCountry(weatherRequest.location().country());
      weatherEntity.setCurrentWeather(weatherRequest.current().condition().currentWeather());
      weatherEntity.setHumidity(weatherRequest.current().humidity());
      weatherEntity.setPressureInMb(weatherRequest.current().pressureInMb());
      weatherEntity.setTempInCelsius(weatherRequest.current().tempInCelsius());
      weatherEntity.setWindInMps(convertKphToMps(weatherRequest.current().windInKph()));
      weatherEntity.setUpdatedAt(LocalDateTime.now());
      return weatherEntity;
  }

  public static LatestWeatherResponse fromEntityToLatestWeatherResponse(WeatherEntity entity){
      return new LatestWeatherResponse(
              entity.getName(),
              entity.getCountry(),
              entity.getUpdatedAt(),
              entity.getTempInCelsius(),
              entity.getCurrentWeather(),
              entity.getWindInMps(),
              entity.getPressureInMb(),
              entity.getHumidity()
      );
  }

    private static Double convertKphToMps(Double kph) {
        return kph / 3.6;
    }

}
