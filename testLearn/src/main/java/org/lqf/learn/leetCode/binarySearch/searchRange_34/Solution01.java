package org.lqf.learn.leetCode.binarySearch.searchRange_34;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length == 0) {
            return res;
        }
        res[0] = findMinEqual(nums,target);
        res[1] = findMaxEqual(nums,target);
        return res;
    }
    //找到最左边的最大值，最右边的最小值
    private static int findMinEqual(int[] nums, int target) {
        int left = -1;
        int right = nums.length -1;
        while (left+1<right) {
            int mid = (left+right) >>1;
            //nums[l] 一定 是比target 小
            //nums[r] 一定 是比target 大(或等于)
            if(nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if(nums[right] == target) {
            return right;
        }
        return -1;
    }
    private static int findMaxEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length ;
        while (left+1<right) {
            int mid = (left+right) >>1;
            //nums[l] 一定比target 小(或等于)
            //nums[r] 一定比target 大
            if(nums[mid] <= target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if(nums[left] == target) {
            return left;
        }
        return -1;
    }
}
