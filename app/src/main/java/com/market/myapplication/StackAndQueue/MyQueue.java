package com.market.myapplication.StackAndQueue;

import java.lang.reflect.Array;

/**
 * 使用数组实现一个队列，可以存储任意类型
 */
public class MyQueue<T> {

    private T[] mArray;
    private int mCount;

    public MyQueue(Class<T> type,int count){
        mArray = (T[]) Array.newInstance(type,count);
        mCount = count;
    }
    //将元素添加到队尾
    public void add(T value){
        mArray[mCount-1] = value;
    }
    //返回队列头元素
    public T front(){
        return mArray[0];
    }
    //返回队头元素，并且删除
    public T pop(){
        T ret = mArray[0];
        mCount--;
        //循环往前移一位
        for (int i=1;i<mCount;i++){
            mArray[i-1] = mArray[i];
        }
        return ret;
    }
    //返回个数
    public int size(){
        return mCount;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return mCount==0;
    }

}
