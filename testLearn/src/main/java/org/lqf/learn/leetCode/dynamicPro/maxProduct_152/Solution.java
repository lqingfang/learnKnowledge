package org.lqf.learn.leetCode.dynamicPro.maxProduct_152;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int resultMax = nums[0];
        int min = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++) {
            min = min * nums[i];
            max = max * nums[i];
            int curMin = getMin(min,max,nums[i]);
            int curMax = getMax(min,max,nums[i]);

            min = curMin;
            max = curMax;
            resultMax = Math.max(max,resultMax);
        }
        return resultMax;
    }
    public static int getMax(int x,int y,int z){
        int m1 = Math.max(x,y);
        return Math.max(m1,z);
    }
    public static int getMin(int x,int y,int z){
        int m1 = Math.min(x,y);
        return Math.min(m1,z);
    }
}
