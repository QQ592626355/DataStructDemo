package com.market.myapplication.MyObserver;

import java.util.ArrayList;

//创建被观察者对象，实现接口
public class WeatherData implements Subject {
    //温度
    private float temperature;
    //湿度
    private float humidity;
    //气压
    private float airpressure;

    //观察者列表
    private ArrayList<Observer> observerArrayList;
    public WeatherData() {
        this.observerArrayList = new ArrayList<Observer>();
    }



    @Override
    public void addObserver(Observer observer) {
        this.observerArrayList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        int i;
        if((i = observerArrayList.indexOf(observer)) != -1) {
            this.observerArrayList.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : this.observerArrayList) {
            observer.update(this.temperature, this.humidity, this.airpressure);
        }

    }

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
        this.notifyObservers();
    }

}
