package org.lqf.learn.leetCode.dynamic.maxProduct_152;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max = nums[0];
        dp[0][0] = dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++) {
            dp[i][0] = dp[i][1] = nums[i];
            dp[i][0] = Math.max(dp[i-1][1]*nums[i],Math.max(dp[i][0],dp[i-1][0]*nums[i]));
            dp[i][1] = Math.min(dp[i-1][1]*nums[i],Math.min(dp[i][1],dp[i-1][0]*nums[i]));
            max = Math.max(max,dp[i][0]);
        }
        return max;
    }
}
