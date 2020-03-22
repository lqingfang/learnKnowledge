package org.lqf.learn.leetCode.binarySearch.findMin_153;

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int mid = (left+right)>>1;
            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            // 3 4 5 6 1 2
            if(nums[mid] > nums[right]) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
