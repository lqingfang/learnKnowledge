package org.lqf.learn.leetCode.binarySearch.findPeakElement_162;

public class Solution {
    public static void main(String[] args) {
        int[] A = {4,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }
    private static int peakIndexInMountainArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (middle == nums.length - 1 || nums[middle] > nums[middle + 1]) { // 递减
                right = middle - 1;
            } else { // 递增
                left = middle + 1;
            }
        }

        return left;
    }

}
