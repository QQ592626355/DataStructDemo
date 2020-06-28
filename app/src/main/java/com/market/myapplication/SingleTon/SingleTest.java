package com.market.myapplication.SingleTon;

import java.io.Serializable;

//懒汉式写法
 class SingleTon1 {
    //私有构造
    private SingleTon1() {
    }

    private static SingleTon1 instance;

    public static SingleTon1 getInstance() {
        if (instance == null) {
            instance = new SingleTon1();
        }
        return instance;
    }
}

//饿汉式写法
 class SingleTon2 {
    //私有构造
    private SingleTon2() {}

    private static SingleTon2 instance = new SingleTon2();
    public static SingleTon2 getInstance() {
        return instance;
    }
}

//加锁单例
class SingleTon3{
    //私有构造
    private SingleTon3() {}

    private static SingleTon3 instance = null;

    public static SingleTon3 getInstance(){
        synchronized (SingleTon3.class){
            if (instance ==null){
                instance = new SingleTon3();
            }
        }
        return instance;
    }
}

//DCL
class SingleTon4{
    //私有构造
    private SingleTon4() {}
    //保证原子性
    private static volatile SingleTon4 instance = null;

    public  static SingleTon4 getInstance(){
        if (instance==null){
            synchronized (SingleTon4.class){
                if (instance ==null){
                    instance = new SingleTon4();
                }
            }
        }

        return instance;
    }
}

//静态内部类
//这种设计模式在序列化和反序列化的时候会失效，可以使用seriable接口来优化
class SingleTon5 implements Serializable {

    //私有构造
    private SingleTon5() {}

    private static class InstanceHolder{
        private static SingleTon5 instance = new SingleTon5();
    }
    public static SingleTon5 getInstance(){
        return InstanceHolder.instance;
    }
}

//枚举类来实现
enum SingleTon6{
    INSTANCE
}





public class SingleTest{
public static void main(String[] args) {


        }
        }