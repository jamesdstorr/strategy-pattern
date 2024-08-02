package com.james_storr.strategy_pattern.service;

import java.util.concurrent.CompletableFuture;

public interface WeatherService {
    CompletableFuture<String> getWeather(String location);
}
