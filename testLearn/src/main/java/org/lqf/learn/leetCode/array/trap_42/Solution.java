package org.lqf.learn.leetCode.array.trap_42;

public class Solution {
    public int trap(int[] height) {
        int heightAddress = 0;
        int heightValue = 0;
        int len = height.length;
        //找到最高点
        for(int i=0;i<len;i++) {
            if(height[i] > heightValue) {
                heightValue = height[i];
                heightAddress = i;
            }
        }
        int res = 0;

        //左边的为墙
        for(int left=0;left<heightAddress;left++) {
            for(int i=left+1;i<=heightAddress;i++) {
                if(height[i]<height[left]) {
                    res += height[left]-height[i];
                }else {
                    left = i;
                }
            }
        }
        //右边的为墙
        for(int right=len-1;right>heightAddress;right--) {
            for(int i=right-1;i>=heightAddress;i--) {
                if(height[i]<height[right]) {
                    res += height[right]-height[i];
                }else {
                    right = i;
                }
            }
        }
        return res;
    }
}
