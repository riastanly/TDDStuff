package org.test;

public class WeatherData {
    private final int temperature;
    private final String conditions;

    public WeatherData(int temperature, String conditions) {
        this.temperature = temperature;
        this.conditions = conditions;
    }

    public int getTemperature() {
        return  temperature;
    }

    public String getConditions() {
        return conditions;
    }
}
