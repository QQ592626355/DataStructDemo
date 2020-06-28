package com.market.myapplication.MyObserver;

//创建观察者接口及方法
public interface Observer {

    void update(float temperature, float humidity, float airpressure);
}
