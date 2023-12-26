package com.senla.weather.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public record WeatherPeriodRequest(

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        LocalDate from,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        LocalDate to
) {
}
