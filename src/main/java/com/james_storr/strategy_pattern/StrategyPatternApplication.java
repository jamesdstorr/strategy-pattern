package com.james_storr.strategy_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients 
public class StrategyPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrategyPatternApplication.class, args);
	}

}
