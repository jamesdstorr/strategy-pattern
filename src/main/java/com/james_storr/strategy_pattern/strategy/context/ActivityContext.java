package com.james_storr.strategy_pattern.strategy.context;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;

import com.james_storr.strategy_pattern.strategy.ActivityStrategy;

@Component
public class ActivityContext {
    private final Map<String, ActivityStrategy> strategyMap;

    public ActivityContext(Map<String, ActivityStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }
    
    public String suggestActivity(String weatherCondition) {

        ActivityStrategy strategy = strategyMap.get(weatherCondition);
        if (strategy != null) {
            return strategy.suggestActivity();
        } else {
            return "No activity suggestion available for this weather condition.";
        }
    }
}
