package com.senla.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherRequest(
        @JsonProperty(value = "location")
        Location location,
        @JsonProperty(value = "current")
        Current current
) {
}
