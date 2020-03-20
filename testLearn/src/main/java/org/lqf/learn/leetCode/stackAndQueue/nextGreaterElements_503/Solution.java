package org.lqf.learn.leetCode.stackAndQueue.nextGreaterElements_503;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        int[] res = nextGreaterElements(array);
        System.out.println(Arrays.toString(res));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            res[i] = nextGreater(i,nums);
        }
        return res;
    }

    private static int nextGreater(int index, int[] nums) {
        int i = index +1;
        while (i != index) {
            if(i == nums.length) {
                i = 0;
                continue;
            }
            if(nums[i] > nums[index]){
                return nums[i];
            }
            i++;
        }
        return -1;
    }
}
