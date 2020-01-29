package org.lqf.learn.leetCode.greedy.canJump_55;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    /**
     * 递归  加了记忆功能，leetcode过了
     * 从前往后走
     * @param nums
     * @return
     */
    static Index[] memo;
    public static boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for(int i=0;i<nums.length-1;i++) {
            memo[i] = Index.unknow;
        }
        memo[nums.length-1] = Index.good;
        return canJumpFromPosition(0,nums);
    }

    private static boolean canJumpFromPosition(int position, int[] nums) {
        if(memo[position] != Index.unknow) {
            return memo[position] == Index.good?true:false;
        }
        int futherPosition = Math.min(position+nums[position],nums.length-1);
        for(int nextPosition = position+1;nextPosition<=futherPosition;nextPosition++) {
            if(canJumpFromPosition(nextPosition,nums)) {
                memo[position] = Index.good;
                return true;
            }
        }
        memo[position] = Index.bad;
        return false;
    }
    enum Index{
        bad,good,unknow;
    }
}
