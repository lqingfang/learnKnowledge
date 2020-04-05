package org.lqf.learn.leetCode.array.findDuplicates_442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i-1]) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
