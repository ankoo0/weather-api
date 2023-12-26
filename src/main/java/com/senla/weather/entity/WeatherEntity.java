package com.senla.weather.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "weather_info")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;
    private String name;
    private String country;
    private LocalDateTime updatedAt;
    private Double tempInCelsius;
    private String currentWeather;
    private Double windInMps;
    private Double pressureInMb;
    private Integer humidity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity entity = (WeatherEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(name, entity.name) && Objects.equals(country, entity.country) && Objects.equals(updatedAt, entity.updatedAt) && Objects.equals(tempInCelsius, entity.tempInCelsius) && Objects.equals(currentWeather, entity.currentWeather) && Objects.equals(windInMps, entity.windInMps) && Objects.equals(pressureInMb, entity.pressureInMb) && Objects.equals(humidity, entity.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, updatedAt, tempInCelsius, currentWeather, windInMps, pressureInMb, humidity);
    }
}
