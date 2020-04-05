package org.lqf.learn.leetCode.array.rotate_189;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int[] newNums = new int[len];
        int index = 0;
        for(int i=len-k;i<len;i++) {
            newNums[index++] = nums[i];
        }
        for(int i=0;i<len-k;i++) {
            newNums[index++] = nums[i];
        }
        for(int i=0;i<len;i++) {
            nums[i] = newNums[i];
        }

    }
}
