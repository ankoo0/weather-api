package com.senla.weather.exception;

public class InvalidDateRangeException extends RuntimeException {
    public InvalidDateRangeException(String reason) {
        super(reason);
    }
}
