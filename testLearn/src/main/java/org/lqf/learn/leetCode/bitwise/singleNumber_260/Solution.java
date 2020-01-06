package org.lqf.learn.leetCode.bitwise.singleNumber_260;

import java.util.Arrays;

/**
 * 明白了
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res = singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i:nums){
            xor ^=i;
        }
        //得到最低位的1
        int mask = xor &(-xor);
        int[] ans = new int[2];
        for(int i:nums) {
            if((mask & i) ==0) {
                ans[0] ^= i;
            }else {
                ans[1] ^= i;
            }
        }
        return ans;
    }
}
