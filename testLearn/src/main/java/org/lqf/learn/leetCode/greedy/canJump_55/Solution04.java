package org.lqf.learn.leetCode.greedy.canJump_55;

public class Solution04 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int maxJump = nums.length-1;
        for(int j= nums.length-2;j>=0;j--) {
            if(j+nums[j]>=maxJump) {
                maxJump = j;
            }
        }
        return maxJump==0;
    }
}
