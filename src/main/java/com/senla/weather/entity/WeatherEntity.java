package com.senla.weather.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
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
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String country;
    @NotNull
    private LocalDateTime updatedAt;
    @Column(columnDefinition = "DECIMAL(10,2)")
    @NotNull
    private Double tempInCelsius;
    @NotBlank
    private String currentWeather;
    @Column(columnDefinition = "DECIMAL(10,2)")
    @NotNull
    private Double windInMps;
    @Column(columnDefinition = "DECIMAL(10,2)")
    @NotNull
    private Double pressureInMb;
    @NotNull
    private Integer humidity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherEntity that = (WeatherEntity) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!country.equals(that.country)) return false;
        if (!updatedAt.equals(that.updatedAt)) return false;
        if (!tempInCelsius.equals(that.tempInCelsius)) return false;
        if (!currentWeather.equals(that.currentWeather)) return false;
        if (!windInMps.equals(that.windInMps)) return false;
        if (!pressureInMb.equals(that.pressureInMb)) return false;
        return humidity.equals(that.humidity);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + updatedAt.hashCode();
        result = 31 * result + tempInCelsius.hashCode();
        result = 31 * result + currentWeather.hashCode();
        result = 31 * result + windInMps.hashCode();
        result = 31 * result + pressureInMb.hashCode();
        result = 31 * result + humidity.hashCode();
        return result;
    }
}
