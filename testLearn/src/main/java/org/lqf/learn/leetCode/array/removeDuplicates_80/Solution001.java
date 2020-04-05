package org.lqf.learn.leetCode.array.removeDuplicates_80;

import java.util.Arrays;

public class Solution001 {
    public static void main(String[] args) {
        int[] nums = new int[] {
          1,1,1,2,2,2,3
        };
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int index = 2;
        for(int i=2;i<nums.length;i++) {
            if(nums[i] == nums[index-2]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
