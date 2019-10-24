package org.lqf.learn.leetCode.binarySearch.findMin_154;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,1,3};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right) {
            mid = (left+right) >>>1;
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right-1;
            }
        }
        return nums[left];
    }
}
