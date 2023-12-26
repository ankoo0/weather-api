package com.senla.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Current(
        @JsonProperty("temp_c")
    double tempInCelsius,
    @JsonProperty(value = "condition")
        Condition condition,
        @JsonProperty("wind_kph")
    double windInKph,
        @JsonProperty("pressure_mb")
    double pressureInMb,
        @JsonProperty("humidity")
    int humidity
){
}