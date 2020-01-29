package org.lqf.learn.leetCode.greedy.canJump_55;

public class Solution03 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    /**
     * 递归，从后向前走，==》动态规划
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
        for(int i = nums.length-2;i>=0;i--) {
            int futherPosition = Math.min(i+nums[i],nums.length-1);
            for(int nextPosition = i+1;nextPosition<=futherPosition;nextPosition++) {
                if(memo[nextPosition] == Index.good) {
                    memo[i] = Index.good;
                    break;
                }
            }
        }
        return memo[0] == Index.good?true:false;
    }

    enum Index{
        bad,good,unknow;
    }
}
