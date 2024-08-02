package com.james_storr.strategy_pattern.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.james_storr.strategy_pattern.collaborator.WeatherAPIClient;
import com.james_storr.strategy_pattern.model.WeatherAPIResponse;


import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherServiceImpl {

    private final WeatherAPIClient weatherAPIClient;
    private final ObjectMapper objectMapper; 
    
    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherServiceImpl(WeatherAPIClient weatherAPIClient) {
        this.weatherAPIClient = weatherAPIClient;
        this.objectMapper = new ObjectMapper();
    }

    public CompletableFuture<String> getWeather(String location)
    {
        return CompletableFuture.supplyAsync(() -> {   
            try{
                String rawWeatherData = weatherAPIClient.getCurrent(location, apiKey);
                WeatherAPIResponse WeatherAPIResponse = objectMapper.readValue(rawWeatherData, WeatherAPIResponse.class);
                return WeatherAPIResponse.getCurrent().getCondition().getText();
            }        
            catch (Exception e) {
                return null;
            }
          
        });
    }

}
