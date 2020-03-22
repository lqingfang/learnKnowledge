package org.lqf.learn.leetCode.binarySearch.findMin_154;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,3,3,3,1,3};
        //int[] nums = {10,1,10,10,10};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
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
            if(mid-1 >=0 && nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            // 3 4 5 6 1 2
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else if(nums[mid] < nums[right]) {
                right = mid-1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
