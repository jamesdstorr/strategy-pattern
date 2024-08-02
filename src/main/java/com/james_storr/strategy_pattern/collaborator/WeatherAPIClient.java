package com.james_storr.strategy_pattern.collaborator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-api", url="${weather.api.url}")
public interface WeatherAPIClient {
    @GetMapping("/current.json")
    public String getCurrent(@RequestParam("q") String location, @RequestParam("key") String key );
}
