package com.senla.weather.mappers;

import com.senla.weather.dto.Weather;
import com.senla.weather.entity.WeatherEntity;
import com.senla.weather.response.LatestWeatherResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class WeatherMapper {

  public static WeatherEntity fromDtoToEntity(Weather weather) {
      WeatherEntity weatherEntity = new WeatherEntity();
      weatherEntity.setName(weather.location().name());
      weatherEntity.setCountry(weather.location().country());
      weatherEntity.setCurrentWeather(weather.current().conditionDto().text());
      weatherEntity.setHumidity(weather.current().humidity());
      weatherEntity.setPressureInMb(weather.current().pressure_mb());
      weatherEntity.setTempInCelsius(weather.current().temp_c());
      weatherEntity.setWindInMps(convertKphToMps(weather.current().wind_kph()));
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
