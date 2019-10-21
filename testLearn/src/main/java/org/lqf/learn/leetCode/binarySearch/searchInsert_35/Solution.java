package org.lqf.learn.leetCode.binarySearch.searchInsert_35;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        System.out.println(searchInsert(nums,target));
    }

    private static int searchInsert(int[] nums, int target) {
        if( null == nums ||nums[0] >=target) {
            return 0;
        }
        if(nums[nums.length-1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left+right) >>1;

            if(nums[mid] == target) {
                return mid;
            }else if (target < nums[mid]) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return left;
    }
}
