package org.lqf.learn.leetCode.hash.longestConsecutive_128;

import java.util.Arrays;

public class Solution01 {
    public int longestConsecutive(int[] nums) {
        if(nums== null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longLen = 1;
        int currentLen = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i-1]+1){
                currentLen++;
                longLen = Math.max(currentLen,longLen);
            }else if(nums[i] == nums[i-1]){
                currentLen = currentLen;
            }else {
                currentLen = 1;
            }
        }
        return longLen;
    }
}
