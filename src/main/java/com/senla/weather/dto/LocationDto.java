package com.senla.weather.dto;

public record LocationDto(
        String name,
        String region,
        String country,
        double lat,
        double lon,
        String tz_id,
        long localtime_epoch,
        String localtime
){

}