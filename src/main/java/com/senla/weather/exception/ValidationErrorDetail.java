package com.senla.weather.exception;

public record ValidationErrorDetail(
        String message,
        Object value,
        String field
) {

}
