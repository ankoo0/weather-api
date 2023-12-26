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
    private LocalDateTime lastUpdated;
    private Double tempC;
    private String currentWeather;
    private Double windMps;
    private Double pressureMb;
    private Integer humidity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity entity = (WeatherEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(name, entity.name) && Objects.equals(country, entity.country) && Objects.equals(lastUpdated, entity.lastUpdated) && Objects.equals(tempC, entity.tempC) && Objects.equals(currentWeather, entity.currentWeather) && Objects.equals(windMps, entity.windMps) && Objects.equals(pressureMb, entity.pressureMb) && Objects.equals(humidity, entity.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, lastUpdated, tempC, currentWeather, windMps, pressureMb, humidity);
    }
}
