package org.lqf.learn.leetCode.array.threeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution03 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (start<end) {
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    while (start<end && nums[start]==nums[start+1]) {
                        start++;
                    }
                    while (start<end && nums[end]==nums[end-1]) {
                        end--;
                    }
                    start++;
                    end--;
                }
                if(sum < 0) {
                    start++;
                }
                if(sum > 0) {
                    end--;
                }
            }
        }
        return res;
    }
}
