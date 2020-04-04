package org.lqf.learn.leetCode.array.threeSumClosest_16;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int tempSum = nums[i]+nums[start]+nums[end];
                if(Math.abs(target -tempSum) < Math.abs(target-closetSum)) {
                    closetSum = tempSum;
                }
                if(tempSum > target) {
                    end--;
                } else if(tempSum < target) {
                    start++;
                } else {
                    return tempSum;
                }
            }
        }
        return closetSum;
    }
}
