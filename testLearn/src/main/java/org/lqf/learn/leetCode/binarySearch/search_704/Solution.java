package org.lqf.learn.leetCode.binarySearch.search_704;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        if(nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right) {
            int mid = (left+right)>>1;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
