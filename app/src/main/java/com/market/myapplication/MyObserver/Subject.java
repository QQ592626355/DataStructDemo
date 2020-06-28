package com.market.myapplication.MyObserver;


//创建被观察者接口，增加部分方法
public interface Subject {
    /**
     * 添加观察者
     * @param observer
     */
    public void addObserver(Observer observer);

    /**
     * 删除指定观察者
     * @param observer
     */
    public void deleteObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyObservers();

}
