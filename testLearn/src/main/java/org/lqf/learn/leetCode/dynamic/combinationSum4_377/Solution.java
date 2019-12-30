package org.lqf.learn.leetCode.dynamic.combinationSum4_377;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int target = 7;
        System.out.println(combinationSum4(nums,target));
    }
    public static int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=target;i++) {
            for(int j=0;j<len;j++) {
                if(i - nums[j]>=0) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
