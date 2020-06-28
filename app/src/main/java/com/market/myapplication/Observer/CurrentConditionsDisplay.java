package com.market.myapplication.Observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private float airpressure;
    private Observable observable;

    //通过构造注入被观察者，观察者持有被观察者对象的引用
    //完成绑定
    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
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
