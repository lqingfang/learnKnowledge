package org.lqf.learn.leetCode.array.findMaxConsecutiveOnes_485;

public class Solution001 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for(int num:nums) {
            if(num == 1) {
                count++;
                res = Math.max(res,count);
            }else {
                count=0;
            }

        }
        return res;
    }
}
