package com.senla.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Condition(
        @JsonProperty("text")
        String currentWeather
) {
}
