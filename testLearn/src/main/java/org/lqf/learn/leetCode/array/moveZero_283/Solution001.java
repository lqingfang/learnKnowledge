package org.lqf.learn.leetCode.array.moveZero_283;

import java.util.Arrays;

public class Solution001 {
    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = i+1;
        while (j<len && i<len) {
            while (i<len && nums[i] !=0) {
                i++;
            }
            j=i+1;
            while (j<len && nums[j] ==0) {
                j++;
            }

            if(j<len && i<len) {
                nums[i] = nums[j];
                nums[j] = 0;
                i = i+1;
            }
        }
    }
}
