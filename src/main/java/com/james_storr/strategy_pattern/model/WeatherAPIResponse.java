package com.james_storr.strategy_pattern.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class WeatherAPIResponse {
    private Location location;
    private Current current;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;
        private String tzId;
        private long localtimeEpoch;
        private String localtime;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Current {
        private long lastUpdatedEpoch;
        private String lastUpdated;
        private double tempC;
        private double tempF;
        private int isDay;
        private Condition condition;
        private double windMph;
        private double windKph;
        private int windDegree;
        private String windDir;
        private double pressureMb;
        private double pressureIn;
        private double precipMm;
        private double precipIn;
        private int humidity;
        private int cloud;
        private double feelslikeC;
        private double feelslikeF;
        private double windchillC;
        private double windchillF;
        private double heatindexC;
        private double heatindexF;
        private double dewpointC;
        private double dewpointF;
        private int visKm;
        private int visMiles;
        private int uv;
        private double gustMph;
        private double gustKph;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Data
        public static class Condition {
            private String text;
            private String icon;
            private int code;
        }
    }

}
