package org.lqf.learn.leetCode.array.maxArea_11;

public class Solution03 {
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        for(int i=0;i<height.length-1;i++) {
            for(int j=1;j<height.length;j++) {
                int curArea = (j-i)*Math.min(height[i],height[j]);
                area = Math.max(curArea,area);
            }
        }
        return area;
    }
}
