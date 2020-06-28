package com.market.myapplication.MyObserver;

public class ForecastDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float airpressure;
    private Subject subject;

    public ForecastDisplay(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float airpressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airpressure = airpressure;
        this.display();
    }

    @Override
    public void display() {
        System.out.println("气温："+ this.temperature+"\t"+"湿度："+this.humidity+"\t"+"气压："+this.airpressure);
    }
}
