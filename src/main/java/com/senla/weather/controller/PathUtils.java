package com.senla.weather.controller;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathUtils {

    public static final String BASE = "/api";
    public static final String BASE_VERSION_1 = BASE + "/v1";
    public static final String WEATHER = "/weather";
    public static final String ROOT = BASE_VERSION_1 + WEATHER;
}
