package com.market.myapplication.Observer;

import java.util.Observable;

public class WeatherData  extends Observable {
    private float temperature;
    private float humidity;
    private float airpressure;
    public WeatherData() {}

    /**
     * 被观察者数据发生改变
     * @param temperature
     * @param humidity
     * @param airpressure
     */
    public void setMeasurements(float temperature, float humidity, float airpressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airpressure = airpressure;
        this.measurementsChanged();
    }
    /**
     * 修改后，通知观察者
     */
    public void measurementsChanged() {
        super.setChanged();
        super.notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getAirpressure() {
        return airpressure;
    }



}
