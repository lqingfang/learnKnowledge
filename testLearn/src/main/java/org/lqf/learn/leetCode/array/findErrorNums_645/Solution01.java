package org.lqf.learn.leetCode.array.findErrorNums_645;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[]{-1,-1};
        int[] count = new int[nums.length+1];
        for(int i=0;i<nums.length;i++) {
            count[nums[i]]++;
        }
        for(int i=1;i<=nums.length;i++) {
            if(count[i]==0) {
                res[1]= i;
            }
            if(count[i]==2) {
                res[0] = i;
            }
        }
        return res;
    }
}
