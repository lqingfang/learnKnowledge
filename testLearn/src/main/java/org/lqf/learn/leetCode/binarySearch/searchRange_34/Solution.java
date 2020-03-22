package org.lqf.learn.leetCode.binarySearch.searchRange_34;


import java.util.Arrays;

public class Solution {
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
        res[0] = binarySearch1(nums,target);
        res[1] = binarySearch2(nums,target);
        return res;
    }

    //找到最左边的最大值，最右边的最小值
    private static int binarySearch1(int[] nums, int target) {
        int l = -1;
        int r = nums.length-1;
        while (l+1 < r) {
            int m = (l+r)/2;
            //nums[l] 一定 是比target 小
            //nums[r] 一定 是比target 大(或等于)
            if(nums[m] < target) {
                l = m;
            }else {
                r = m;
            }
        }
        if(nums[r] == target) {
            return r;
        }
        return -1;
    }

    private static int binarySearch2(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l+1 < r) {
            int m = (l+r)/2;
            //nums[l] 一定比target 小(或等于)
            //nums[r] 一定比target 大
            if(nums[m] <= target) {
                l = m;
            }else {
                r = m;
            }
        }
        if(nums[l] == target) {
            return l;
        }
        return -1;
    }
}
