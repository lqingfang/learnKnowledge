package org.lqf.learn.leetCode.array.arrayNesting_565;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,0,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }
    public static int arrayNesting(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            int a = i;
            int count =0;
            while (!set.contains(nums[a])) {
                set.add(nums[a]);
                count++;
                a = nums[a];
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
