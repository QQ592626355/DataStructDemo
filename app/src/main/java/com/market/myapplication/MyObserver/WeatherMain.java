package com.market.myapplication.MyObserver;

public class WeatherMain {
    public static void main(String[] args) {
        //被观察者
        WeatherData weatherData = new WeatherData();

        //观察者对象
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80, 85, 90);

    }
}
