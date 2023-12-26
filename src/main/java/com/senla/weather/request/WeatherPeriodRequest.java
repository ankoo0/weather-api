package com.senla.weather.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record WeatherPeriodRequest(

        @JsonFormat(pattern = "dd-MM-yyyy")
//        @DateTimeFormat(pattern = "dd-MM-yyyy")
        LocalDate from,

        @JsonFormat(pattern = "dd-MM-yyyy")
//        @DateTimeFormat(pattern = "dd-MM-yyyy")
        LocalDate to
) {
}
