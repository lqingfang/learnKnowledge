package org.lqf.learn.leetCode.dynamic.findTargetSumWays_494;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays(nums,S));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0]+1000] = 1;
        dp[0][-nums[0]+1000] = dp[0][-nums[0]+1000]+1;
        for(int i=1;i<nums.length;i++) {
            for(int sum=-1000;sum<=1000;sum++) {
                if(dp[i-1][sum+1000] >0) {
                    dp[i][sum+nums[i]+1000] = dp[i][sum+nums[i]+1000]+dp[i-1][sum+1000];
                    dp[i][sum-nums[i]+1000] = dp[i][sum-nums[i]+1000]+dp[i-1][sum+1000];
                }
            }
        }
        return S>1000?0:dp[nums.length-1][S+1000];
    }
}
