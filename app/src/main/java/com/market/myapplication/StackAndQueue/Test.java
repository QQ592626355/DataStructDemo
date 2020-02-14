package com.market.myapplication.StackAndQueue;

import java.util.Stack;

/**
 * 用2个栈来实现一个队列
 */
public class Test<T> {

    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    //入队
    public void add(T value){
        stack1.push(value);
    }
    //出队
    public T pop(){
    if (stack1.empty()&&stack2.empty()){
        throw new RuntimeException("empty");
    }else if (stack2.empty()){
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }
        return (T) stack2.pop();
    }

}
