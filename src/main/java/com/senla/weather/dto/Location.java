package com.senla.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        @JsonProperty("name")
        String name,
        @JsonProperty("country")
        String country
){

}