package org.lqf.learn.leetCode.stackAndQueue.myQueue_232;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack = new Stack();
    Stack<Integer> popStack = new Stack();
    public MyQueue() {

    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if(popStack.isEmpty()) {
            while (!stack.isEmpty()) {
                popStack.push(stack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()) {
            while (!stack.isEmpty()) {
                popStack.push(stack.pop());
            }
        }

        return popStack.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && popStack.isEmpty();
    }
}
