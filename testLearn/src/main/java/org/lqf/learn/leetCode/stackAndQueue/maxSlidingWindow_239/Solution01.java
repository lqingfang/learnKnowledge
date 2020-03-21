package org.lqf.learn.leetCode.stackAndQueue.maxSlidingWindow_239;

public class Solution01 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len <1) {
            return new int[0];
        }
        int[] res = new int[len-k+1];
        for(int i=0;i<len-k+1;i++) {
            res[i] = getSlidMax(i,nums,k);
        }
        return res;
    }

    private int getSlidMax(int index, int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=index;i<index+k;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}
