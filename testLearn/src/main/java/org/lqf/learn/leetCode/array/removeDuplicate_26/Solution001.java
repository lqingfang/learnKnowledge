package org.lqf.learn.leetCode.array.removeDuplicate_26;

public class Solution001 {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
