package org.lqf.learn.leetCode.dynamic.rob_213;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int first = getRob2(nums,0,nums.length-1);
        int end = getRob2(nums,1,nums.length);
        return Math.max(first,end);
    }

    private static int getRob(int[] nums, int start, int end) {
        int pre_0 = 0;
        int pre_1 = 0;
        for(int i=start;i<end;i++) {
            int cur = Math.max(pre_0+nums[i],pre_1);
            pre_0 = pre_1;
            pre_1 = cur;
        }
        return Math.max(pre_0,pre_1);
    }
    private static int getRob2(int[] nums, int start, int end) {
        int[] dp = new int[nums.length+1];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<end;i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end-1];
    }
}
