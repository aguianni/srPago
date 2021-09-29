package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class Config {

    @Value("${station.rest.template.connectTimeoutMs:500}")
    private Long connectTimeoutMs;

    @Value("${station.rest.template.readTimeoutMs:5000}")
    private Long readTimeoutMs;

    @Bean(name = "stationRestTemplate")
    public RestTemplate profileUsersRestTemplate() {
        var builder = new RestTemplateBuilder()
                .setConnectTimeout(Duration.of(connectTimeoutMs, ChronoUnit.MILLIS))
                .setReadTimeout(Duration.of(readTimeoutMs, ChronoUnit.MILLIS));
        return builder.build();
    }
}
