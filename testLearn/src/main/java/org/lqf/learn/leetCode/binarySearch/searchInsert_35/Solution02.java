package org.lqf.learn.leetCode.binarySearch.searchInsert_35;

public class Solution02 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i] >= target ) {
                return i;
            }
        }
        return nums.length;
    }
}
