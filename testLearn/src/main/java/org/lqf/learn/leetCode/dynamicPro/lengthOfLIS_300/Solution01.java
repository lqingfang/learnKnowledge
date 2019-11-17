package org.lqf.learn.leetCode.dynamicPro.lengthOfLIS_300;

public class Solution01 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length+1];
        for(int i=0;i<dp.length;i++) {
            dp[i] = 1;
        }
        int res = 1;
        for(int i=1;i<nums.length;i++) {
            for(int j=i-1;j>=0;j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
