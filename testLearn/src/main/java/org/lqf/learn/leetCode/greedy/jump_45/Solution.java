package org.lqf.learn.leetCode.greedy.jump_45;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int step = 0;
        for(int index=0; ; ) {
            if(index+nums[index] >= nums.length-1) {
                step++;
                break;
            }
            index = findMaxStep(nums,index,nums[index]);
            step++;
        }
        return step;
    }

    private static int findMaxStep(int[] nums, int start, int num) {
        int maxStep = 0;
        int maxStepIndex = 0;
        for(int i=start;i<=start+num && i<nums.length;i++) {
            if(maxStep < nums[i]+i) {
                maxStep = nums[i]+i;
                maxStepIndex = i;
            }
        }
        return maxStepIndex;
    }
}
