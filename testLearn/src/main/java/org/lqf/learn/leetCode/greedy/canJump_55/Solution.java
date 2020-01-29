package org.lqf.learn.leetCode.greedy.canJump_55;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0,nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if(position == nums.length-1) {
            return true;
        }
        int futherJump = Math.min(position+nums[position],nums.length-1);
        for(int nextPosition = position+1;nextPosition<=futherJump;nextPosition++) {
            if(canJumpFromPosition(nextPosition,nums)) {
                return true;
            }
        }
        return false;
    }
}
