package org.lqf.learn.leetCode.hash.longestConsecutive_128;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int currentLen = 1;
        int longestLen = 1;
        for(int i = 1;i<nums.length;i++) {
            if(nums[i] == nums[i-1]+1) {
                currentLen = currentLen+1;
                longestLen = Math.max(currentLen,longestLen);
            }else if(nums[i] == nums[i-1]){
                currentLen = currentLen;
            }else {
                currentLen = 1;
            }
        }
        return longestLen;
    }
}
