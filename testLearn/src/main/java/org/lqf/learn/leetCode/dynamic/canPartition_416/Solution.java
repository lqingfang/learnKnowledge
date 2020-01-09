package org.lqf.learn.leetCode.dynamic.canPartition_416;

public class Solution {
    public static void main(String[] args) {
        //int[] nums = {1,3,4,4};
        int[] nums = {1,2,5,4,6};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        if(nums.length <2) {
            return false;
        }
        if(nums.length == 2) {
            return nums[0]==nums[1];
        }
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num:nums) {
            for(int i=target;i >=num;i--) {
                if(dp[i-num] == true) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
