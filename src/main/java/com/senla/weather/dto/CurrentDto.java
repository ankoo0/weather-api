package com.senla.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrentDto (
    long last_updated_epoch,
    String last_updated,
    double temp_c,
    double temp_f,
    int is_day,
    @JsonProperty(value = "condition")
    ConditionDto conditionDto,
    double wind_mph,
    double wind_kph,
    int wind_degree,
    String wind_dir,
    double pressure_mb,
    double pressure_in,
    double precip_mm,
    double precip_in,
    int humidity,
    int cloud,
    double feelslike_c,
    double feelslike_f,
    double vis_km,
    double vis_miles,
    double uv,
    double gust_mph,
    double gust_kph
){
}