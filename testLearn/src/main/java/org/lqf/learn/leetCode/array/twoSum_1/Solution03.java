package org.lqf.learn.leetCode.array.twoSum_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution03 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums,6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int d = target-nums[i];
            if(null != map.get(d)) {
                return new int[]{map.get(d),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
