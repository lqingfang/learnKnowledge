package org.lqf.learn.leetCode.binarySearch.search_33;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        if(len == 1) {
            if(nums[0] == target) {
                return 0;
            }else {
                return -1;
            }
        }
        int left = 0;
        int right = len-1;
        if(nums[left] <nums[right]) {
            return searchTarget(left,right,target,nums);
        }
        int min = 0;
        //找到最小值的位置
        //4 5 6 7 8 9 1 2 3
        //6 7 1 2 3 4 5
        while (left < right) {
            int mid = (left+right)>>1;
            if(nums[mid] > nums[mid+1]) {
                min = mid+1;
                break;
            }
            if(nums[mid-1] > nums[mid]) {
                min = mid;
                break;
            }
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        if(nums[0] <= target && target <= nums[min-1]) {
            return searchTarget(0,min-1,target,nums);
        }else if(nums[min] <= target && target <= nums[len-1]) {
            return searchTarget(min,nums.length-1,target,nums);
        }
        return -1;
    }

    private static int searchTarget(int left, int right, int target, int[] nums) {
        if(target < nums[left]  || nums[right] < target) {
            return -1;
        }
        while (left < right) {
            int mid = (left+right) >>1;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        if(nums[left] == target) {
            return left;
        }
        return -1;
    }
}
