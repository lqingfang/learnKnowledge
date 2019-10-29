package org.lqf.learn.leetCode.binarySearch.myStack_225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
    private Queue<Integer> queue = new LinkedList<>();
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.size() <1) {
            return -1;
        }
        int l = queue.size();
        while (l>1) {
            queue.add(queue.remove());
            l--;
        }
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        if(queue.size() <1) {
            return -1;
        }
        int l = queue.size();
        while (l>1) {
            queue.add(queue.remove());
            l--;
        }
        int result = queue.remove();
        queue.add(result);
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
