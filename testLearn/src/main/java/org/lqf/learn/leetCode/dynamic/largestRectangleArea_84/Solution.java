package org.lqf.learn.leetCode.dynamic.largestRectangleArea_84;

public class Solution {
    public static void main(String[] args) {

    }
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0;i<heights.length;i++) {
            for(int j=i;j<heights.length;j++) {
                int minHeight = Integer.MAX_VALUE;
                for(int k= i;k<=j;k++) {
                    minHeight = Math.min(minHeight,heights[k]);
                }
                res = Math.max(res,minHeight*(j-i+1));

            }
        }
        return res;
    }
}
