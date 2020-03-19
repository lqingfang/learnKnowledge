package org.lqf.learn.leetCode.stackAndQueue.myStact_225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue = new LinkedList();
    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if(queue.size() <1) {
            return -1;
        }
        int l = queue.size();
        while (l >1) {
           queue.add(queue.remove());
           l--;
        }

        return queue.remove();
    }

    public int top() {
        if(queue.size() <1) {
            return -1;
        }
        int l = queue.size();
        while (l >1) {
            queue.add(queue.remove());
            l--;
        }
        int res = queue.remove();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
