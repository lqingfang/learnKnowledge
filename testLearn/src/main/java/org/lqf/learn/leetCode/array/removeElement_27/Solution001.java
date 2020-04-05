package org.lqf.learn.leetCode.array.removeElement_27;

import java.util.Arrays;

public class Solution001 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int num :nums) {
            if(num == val) {
                continue;
            }
            nums[index] = num;
            index++;
        }
        Arrays.fill(nums,index,nums.length,val);
        return index;
    }
}
