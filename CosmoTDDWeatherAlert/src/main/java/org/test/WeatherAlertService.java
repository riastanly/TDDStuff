package org.test;

public class WeatherAlertService {
    private final IWeatherService weatherService;

    public WeatherAlertService(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String shouldSendAlert(String location) {
        WeatherData weather = weatherService.getCurrentWeather(location);

        if(weather.getTemperature() > 35) {
            return "Extreme weather warning";
        }
        return null;
    }
}
