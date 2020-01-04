package org.lqf.learn.leetCode.dynamic.largestRectangleArea_84;

import java.util.Stack;

public class Solution03 {
    public static void main(String[] args) {
        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(heights[stack.pop()] * (i-stack.peek()-1),maxArea);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(heights[stack.pop()] * (heights.length-stack.peek()-1),maxArea);
        }
        return maxArea;
    }
}
