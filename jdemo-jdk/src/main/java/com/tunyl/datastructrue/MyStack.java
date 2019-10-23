package com.tunyl.datastructrue;

import java.util.Stack;

/**
 * @author create by Tunyl on 2019/10/11
 * @version 1.0
 */
public class MyStack {
    Stack<Integer[]> s ;
    Integer min ;


    /** initialize your data structure here. */
    public MyStack() {
        s =  new Stack<>();
    }

    public void push(int x) {
        if(s.empty()){
            min = x;
        }
        min = min>x?x:min;
        s.push(new Integer[]{x,min});

    }

    public void pop() {
        s.pop();
        if(!s.empty()){
            min = getMin();
        }
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
    }

    public static void main(String[] args) {
        MyStack minStack = new MyStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.getMin();
        minStack.pop();



    }
}
