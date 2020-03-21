package org.lqf.learn.leetCode.binarySearch.findDuplicate_287;

import java.util.HashSet;
import java.util.Set;

public class Solution01 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return 0;
    }
}
