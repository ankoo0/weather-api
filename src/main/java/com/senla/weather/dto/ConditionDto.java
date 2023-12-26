package com.senla.weather.dto;

public record ConditionDto(
        String text,
        String icon,
        int code
) {
}
