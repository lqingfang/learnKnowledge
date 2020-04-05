package org.lqf.learn.leetCode.array.maxArea_11;

public class Solution04 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while (left < right) {
            int curArea = (right-left)*Math.min(height[left],height[right]);
            area = Math.max(area,curArea);
            if(height[right] > height[left]) {
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
}
