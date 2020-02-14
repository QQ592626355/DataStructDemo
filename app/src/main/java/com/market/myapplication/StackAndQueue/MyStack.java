package com.market.myapplication.StackAndQueue;

import java.lang.reflect.Array;

/**
 * 用数组实现的一个简单的栈结构
 * @param <T>
 */
public class MyStack<T> {
    private static final int DEFULT_SIZE =12;
    private T[] mArray;
    private int count;

    public MyStack(Class<T> type){
        this(type,DEFULT_SIZE);
    }

    public MyStack(Class<T> type,int size){
        //使用反射机制生成数组
        mArray = (T[])Array.newInstance(type,size);
        count =0;
    }
    //入栈
    public void push(T value){
        mArray[count++] =value;
    }
    //返回栈顶元素
    public T peek(){
       return mArray[count-1];
    }
    //返回栈顶元素并且删除
    public T pop(){
        T ret = mArray[count-1];
        count--;
        return ret;
    }
    //返回栈的大小
    public int size(){
        return count;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return count == 0;
    }
    //打印栈
    public void printArrayStack(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        System.out.println("Stack size is:"+size());
        int i = count-1;
        while (i>=0){
            System.out.println(mArray[i]);
            i--;
        }

    }



}
