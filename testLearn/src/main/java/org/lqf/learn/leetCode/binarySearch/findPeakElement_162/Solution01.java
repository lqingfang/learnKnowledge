package org.lqf.learn.leetCode.binarySearch.findPeakElement_162;

public class Solution01 {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 1 2 3 4 3 2
        while (left < right) {
            int mid = (left+right)>>1;
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
