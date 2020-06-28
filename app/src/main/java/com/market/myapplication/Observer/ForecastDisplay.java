package com.market.myapplication.Observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float airpressure;
    private Observable observeable;

    public ForecastDisplay(Observable observeable) {
        this.observeable = observeable;
        this.observeable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData) {
            this.temperature = ((WeatherData) o).getTemperature();
            this.humidity = ((WeatherData) o).getHumidity();
            this.airpressure = ((WeatherData) o).getAirpressure();
            this.display();
        }
    }

    @Override
    public void display() {
        System.out.println("气温："+ this.temperature+"\t"+"湿度："+this.humidity+"\t"+"气压："+this.airpressure);
    }

}

