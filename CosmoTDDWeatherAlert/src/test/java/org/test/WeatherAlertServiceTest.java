package org.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherAlertServiceTest {
    @Mock
    private IWeatherService weatherServiceMock;

    @InjectMocks
    private WeatherAlertService alertService;

    /*class WeatherServiceStub implements  IWeatherService {
        private  WeatherData currentWeather = new WeatherData(20, "sunny");

        public void setWeather(int temperature, String conditions) {
            this.currentWeather = new WeatherData(temperature, conditions);
        }

        @Override
        public WeatherData getCurrentWeather(String location) {
            return currentWeather;
        }
    }

    @BeforeEach
    public void setUp() {
        weatherService = new WeatherServiceStub();
        alertService = new WeatherAlertService(weatherService);
    }

    @Test
    public void testShouldReturnHeatWarningWhenTemperatureIsAbove35() {
        weatherService.setWeather(36, "sunny");

        String alert = alertService.shouldSendAlert("London");

        assertEquals("Extreme weather warning", alert);
    }*/

    @Test
    public void shouldReturnHeatWarningWhenTemperatureIsAbove35() {
        // Arrange
        when(weatherServiceMock.getCurrentWeather("London"))
                .thenReturn(new WeatherData(36, "sunny"));

        // Act
        String alert = alertService.shouldSendAlert("London");

        // Assert
        assertEquals("Extreme heat warning. Stay hydrated!", alert);
    }
}