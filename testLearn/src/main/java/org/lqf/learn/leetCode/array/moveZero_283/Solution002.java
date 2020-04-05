package org.lqf.learn.leetCode.array.moveZero_283;

import java.util.Arrays;

public class Solution002 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int num:nums) {
            if(num==0) {
                continue;
            }
            nums[index] = num;
            index++;
        }
        Arrays.fill(nums,index,nums.length,0);
    }
}
