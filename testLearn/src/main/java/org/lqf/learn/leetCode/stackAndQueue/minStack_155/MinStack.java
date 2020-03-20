package org.lqf.learn.leetCode.stackAndQueue.minStack_155;

import java.util.Stack;

public class MinStack {

    Stack<Integer> dataStack = new Stack();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        dataStack.add(x);
        min = Math.min(min,x);
        minStack.add(min);
    }

    public void pop() {
        minStack.pop();
        dataStack.pop();
        min = dataStack.isEmpty()?Integer.MAX_VALUE:minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return min;
    }
}
