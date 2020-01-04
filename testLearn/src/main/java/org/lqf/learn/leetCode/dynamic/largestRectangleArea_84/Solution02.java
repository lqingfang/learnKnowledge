package org.lqf.learn.leetCode.dynamic.largestRectangleArea_84;

public class Solution02 {
    public static void main(String[] args) {

    }
    public int largestRectangleArea(int[] heights) {
        return calculate(heights,0,heights.length-1);
    }

    private int calculate(int[] heights, int start, int end) {
        if(start>end) {
            return 0;
        }
        int minHeight = start;
        for(int i= start;i<=end;i++) {
            if(heights[minHeight] > heights[i]) {
                minHeight = i;
            }
        }
        return Math.max(heights[minHeight] * (end-start+1),Math.max(calculate(heights,start,minHeight-1),calculate(heights,minHeight+1,end)));
    }
}
