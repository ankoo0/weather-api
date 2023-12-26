package com.senla.weather.integration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("X-RapidAPI-Key", "e850b19bfcmshfe7aea336ee5198p1bb5e3jsn2fcd74fc3057");
            requestTemplate.header("X-RapidAPI-Host","weatherapi-com.p.rapidapi.com");
        };
    }


}
