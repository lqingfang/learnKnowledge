package org.lqf.learn.leetCode.binarySearch.search_81;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int target = 3;
        System.out.println(search(nums,target));
    }

    private static boolean search(int[] nums, int target) {
        if(null == nums || nums.length==0) {
            return false;
        }
        int length = nums.length;
        while (length>1 && nums[length-1] == nums[0]) {
            length--;
        }
        if(length == 1) {
            return nums[0] == target;
        }
        if(nums[0] < nums[length-1]) {
            return binSearch(nums,target,0,length-1);
        }
        int minIndex = searchMinIndex(nums,length);

        if(nums[minIndex] == target) {
            return true;
        }
        if(nums[0] > target) {
            return binSearch(nums,target,minIndex,length-1);
        }else {
            return binSearch(nums,target,0,minIndex-1);
        }
    }
   //6712345
    //67812
    private static int searchMinIndex(int[] nums,int length) {
        int left = 0;
        int right = length-1;
        if(nums[0] < nums[nums.length-1]) {
            return 0;
        }
        int mid = 0;
        while (left<=right) {
            mid = (left+right)>>>1;
            if(nums[mid+1] < nums[mid]) {
                return mid+1;
            }
            if(nums[mid] < nums[left]) {
                right = right-1;

            } else {
                left = mid+1;
            }
        }
        return mid;
    }
//
    private static boolean binSearch(int[] nums, int target, int left, int right) {
        int mid = 0;
        while (left<=right) {
            mid = (left+right) >>> 1;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] > target) {
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}
