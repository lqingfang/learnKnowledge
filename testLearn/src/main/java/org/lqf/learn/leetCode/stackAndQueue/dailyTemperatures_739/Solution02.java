package org.lqf.learn.leetCode.stackAndQueue.dailyTemperatures_739;

import java.util.Arrays;
import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        int[] T = new int[] {
                73, 74, 75, 71, 69, 72, 76, 73
        };
        int[] res = dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for(int i=0;i<len;i++) {
            if(valueStack.isEmpty()) {
                indexStack.add(i);
                valueStack.add(T[i]);
            }else {
                while (!valueStack.isEmpty() && T[i] > valueStack.peek()) {
                    valueStack.pop();
                    int index = indexStack.pop();
                    res[index] = i-index;
                }
                indexStack.add(i);
                valueStack.add(T[i]);
            }
        }
        return res;
    }
}
