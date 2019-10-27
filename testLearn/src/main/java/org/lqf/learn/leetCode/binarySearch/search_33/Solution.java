package org.lqf.learn.leetCode.binarySearch.search_33;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(searche(nums,target));
    }

    private static int searche(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0] == target?0:-1;
        }
        int latestIndex = nums.length - 1;

        if(nums[0] < nums[latestIndex]) {
            return binSearch(0,latestIndex,nums,target);
        }
        int minIndex = findMin(nums);

        if(target < nums[0]) {
            return binSearch(minIndex,latestIndex,nums,target);
        }else {
            return binSearch(0,minIndex-1,nums,target);
        }
    }


    //678123456
    //4567123
    private static int findMin(int[] nums) {
        int latestIndex = nums.length - 1;
        if(nums[0] <nums[latestIndex]) {
            return 0;
        }
        int left = 0;
        int right = latestIndex;
        int mid = 0;
        while (left <= right) {
            mid = (left+right) >>>1;
            if(nums[mid] > nums[mid +1]) {
                return mid+1;
            }
            if(nums[mid] < nums[left]) {
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return mid;
    }
    private static int binSearch(int left,int right,int[] nums,int target) {
        int mid = 0;
        while (left <= right) {
            mid = (left+right) >>>1;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
