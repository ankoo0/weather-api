package com.senla.weather.integration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${integration.weather-api.key}")
    private String apiKey;
    @Value("${integration.weather-api.host}")
    private String host;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("X-RapidAPI-Key", apiKey);
            requestTemplate.header("X-RapidAPI-Host",host);
        };
    }


}
