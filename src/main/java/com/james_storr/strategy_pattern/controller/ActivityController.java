package com.james_storr.strategy_pattern.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james_storr.strategy_pattern.service.WeatherServiceImpl;
import com.james_storr.strategy_pattern.strategy.context.ActivityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/activity")
public class ActivityController {
    
    private final ActivityContext activityContext;
    private final WeatherServiceImpl weatherService;

    public ActivityController(ActivityContext activityContext, WeatherServiceImpl weatherService) {
        this.activityContext = activityContext;
        this.weatherService = weatherService;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<String>> suggestActivity(@RequestParam String location) {
       
        return weatherService.getWeather(location).thenApply( condition -> {
            String activitySuggestion = activityContext.suggestActivity(condition);
            return ResponseEntity.ok().body(activitySuggestion);
        }).exceptionally(ex -> ResponseEntity.status(500).body("Error occurred while fetching weather data"));
    }    
}
