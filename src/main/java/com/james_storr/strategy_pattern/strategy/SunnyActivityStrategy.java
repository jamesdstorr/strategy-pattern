package com.james_storr.strategy_pattern.strategy;

import org.springframework.stereotype.Component;

@Component("Clear")
public class SunnyActivityStrategy implements ActivityStrategy {
    @Override
    public String suggestActivity(){
        return "Go to the beach";
    }
    
}
