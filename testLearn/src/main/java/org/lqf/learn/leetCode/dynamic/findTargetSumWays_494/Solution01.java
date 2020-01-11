package org.lqf.learn.leetCode.dynamic.findTargetSumWays_494;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays(nums,S));
    }
    static int count = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        calcuate(nums,0,0,S);
        return count;
    }

    private static void calcuate(int[] nums, int sum, int index, int target) {
        if(index == nums.length) { //因为是index+1后的判断，所以是nums.length,不是nums.length
            if(sum == target) {
                count++;
            }
        }else {
            calcuate(nums,sum+nums[index],index+1,target);
            calcuate(nums,sum-nums[index],index+1,target);
        }
    }

}
