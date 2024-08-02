package com.james_storr.strategy_pattern.strategy;

import org.springframework.stereotype.Component;

@Component("Patchy rain nearby")
public class RainyActivityStrategy implements ActivityStrategy {
    @Override
    public String suggestActivity(){
        return "Play a boardgame";
    }    
}
