package com.james_storr.strategy_pattern.strategy;

import org.springframework.stereotype.Component;

@Component("Partly Cloudy")
public class PartlyCloudyStrategy implements ActivityStrategy {
    @Override
    public String suggestActivity(){
        return "Go for a nice walk";
    }
    
}
